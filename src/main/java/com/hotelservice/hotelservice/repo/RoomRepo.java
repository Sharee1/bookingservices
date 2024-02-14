package com.hotelservice.hotelservice.repo;

import com.hotelservice.hotelservice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {



}