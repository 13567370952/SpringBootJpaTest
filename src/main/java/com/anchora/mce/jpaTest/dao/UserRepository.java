package com.anchora.mce.jpaTest.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anchora.mce.jpaTest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByNameNotNull();

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);


}
