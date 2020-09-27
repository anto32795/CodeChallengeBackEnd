package com.codechallenge2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codechallenge2.models.User;


public interface UserDao extends JpaRepository<User, Integer>{

}
