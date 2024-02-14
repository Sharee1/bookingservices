package com.hotelservice.hotelservice.entity;


import com.hotelservice.hotelservice.entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String userName;

    @Enumerated (EnumType.STRING)
    Role role;




}
