package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.example.demo.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long >{
    @Query("select u from Users u where u.user_name =?1 ")
    Optional<Users> getUserByUsername(String username);

    @Query("select u from Users u where u.user_name =?1  and u.password =?2")
    Optional<Users> getUserByUsernameAndPassword(String username, String password);

    @Query("select u.user_id from Users u where u.user_name =?1 ")
    Long getUserById(String username);
}
