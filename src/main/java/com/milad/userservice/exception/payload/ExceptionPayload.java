package com.milad.userservice.exception.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public final class ExceptionPayload implements Serializable {
        private static final long serialVersionUID = 1L;
        public static final String ZONED_DATE_TIME_FORMAT = "dd-MM-yyyy__HH:mm:ss:SSSSSS";

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ZONED_DATE_TIME_FORMAT)
        private final ZonedDateTime timestamp;

        @JsonInclude(value = JsonInclude.Include.NON_NULL)
        private Throwable throwable;

        private final HttpStatus httpStatus;

        private final String msg;
}
