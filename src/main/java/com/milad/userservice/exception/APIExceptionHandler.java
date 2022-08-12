package com.milad.userservice.exception;

import com.milad.userservice.exception.payload.ExceptionPayload;
import com.milad.userservice.exception.wrapper.UserModelNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice @RequiredArgsConstructor @Slf4j
public class APIExceptionHandler {


//    @ExceptionHandler(RuntimeException.class)
//    public <T extends Exception> ResponseEntity<ExceptionPayload> handleValidationException(final T e) {
//
//        log.error("**ApiExceptionHandler controller, handle validation exception*\n");
//            return new ResponseEntity<>(
//                ExceptionPayload.builder()
//                        .msg("ExeptionHandler say:" + e.getMessage() + "\n"+
//                              "Cause:"+e.getCause()+"\n"
//                                )
//                        .httpStatus(HttpStatus.BAD_REQUEST)
//                        .timestamp(ZonedDateTime.now(ZoneId.systemDefault()))
//                        .build(), HttpStatus.BAD_REQUEST);
//    }





    @ExceptionHandler(value = {
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class
    })
    public <T extends BindException> ResponseEntity<ExceptionPayload> handleValidationException(final T e) {

        log.info("**ApiExceptionHandler controller, handle validation exception*\n");
        return new ResponseEntity<>(
                ExceptionPayload.builder()
                        .msg("*" + e.getBindingResult().getFieldError().getDefaultMessage() + "!**")
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .timestamp(ZonedDateTime.now(ZoneId.systemDefault()))
                        .build(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {UserModelNotFoundException.class})
    public <T extends RuntimeException> ResponseEntity<ExceptionPayload> handleApiRequestException(final T e) {

        log.info("**ApiExceptionHandler controller, handle API request*\n");
        final var badRequest = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(
                ExceptionPayload.builder()
                        .msg("#### " + e.getMessage() + "! ####")
                        .httpStatus(badRequest)
                        .timestamp(ZonedDateTime
                                .now(ZoneId.systemDefault()))
                        .build(), badRequest);
    }
}
