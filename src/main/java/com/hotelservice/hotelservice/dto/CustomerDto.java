package com.hotelservice.hotelservice.dto;


import com.hotelservice.hotelservice.entity.enums.Role;
import jakarta.persistence.*;

public class CustomerDto {

    private  int id;
    private String userName;
    @Enumerated(EnumType.STRING)
    Role role;
}
