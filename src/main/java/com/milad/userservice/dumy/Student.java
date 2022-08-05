package com.milad.userservice.dumy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component

public class Student {

    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Student(Address address) {
        this.address = address;
    }

    public String write() {
        return "live in " + address.getStreet();
    }

}

