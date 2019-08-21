package com.test.demo.domain.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Integer>{

    @Query(value = "select * from address where address like ?",nativeQuery = true)
    List<Address> queryListByName(String name);
}