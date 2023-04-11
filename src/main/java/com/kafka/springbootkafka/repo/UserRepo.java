package com.kafka.springbootkafka.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.springbootkafka.model.USRDATA;

@Repository
public interface UserRepo extends JpaRepository<USRDATA, Long> {

}
