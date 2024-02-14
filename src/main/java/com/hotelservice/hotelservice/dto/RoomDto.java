package com.hotelservice.hotelservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private Long roomId;
    private  Long roomNumber;
    private  String  roomType;
    private int roomSize;
    private  boolean roomOccupied;
}
