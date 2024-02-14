package com.hotelservice.hotelservice.repo;
import com.hotelservice.hotelservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo  extends JpaRepository<Customer, Integer> {
}
