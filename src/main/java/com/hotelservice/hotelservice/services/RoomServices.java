package com.hotelservice.hotelservice.services;

import com.hotelservice.hotelservice.dto.RoomDto;
import com.hotelservice.hotelservice.entity.Room;
import com.hotelservice.hotelservice.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServices {

    @Autowired
    private RoomRepo roomRepo;

    public Room createRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room object cannot be null.");
        }
        return roomRepo.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    public Optional<Room> getRoomById(Long roomId) {
        if (roomId == null) {
            throw new IllegalArgumentException("Room ID cannot be null.");
        }
        return roomRepo.findById(roomId);
    }

    public RoomDto updateRoom(Long roomId, Room updatedRoom) {
        if (roomId == null || updatedRoom == null) {
            throw new IllegalArgumentException("Room ID and updated room object cannot be null.");
        }

        Optional<Room> optionalRoom = roomRepo.findById(roomId);
        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
            existingRoom.setRoomType(updatedRoom.getRoomType());
            return toDto(roomRepo.save(existingRoom));
        } else {
            throw new RuntimeException("Room with ID " + roomId + " not found.");
        }
    }

    public void deleteRoom(Long roomId) {
        if (roomId == null) {
            throw new IllegalArgumentException("Room ID cannot be null.");
        }
        roomRepo.deleteById(roomId);
    }

    public RoomDto toDto(Room room) {
        return RoomDto.builder()
                .roomId(room.getRoomId())
                .roomNumber(room.getRoomNumber())
                .roomSize(room.getRoomSize())
                .roomType(room.getRoomType())
                .roomOccupied(room.isRoomOccupied())
                .build();
    }
}
