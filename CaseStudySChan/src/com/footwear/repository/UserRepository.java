package com.footwear.repository;

import com.footwear.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

 //   User findByUser(String username);

	User findByUsername(String username);


    //TODO: Find users by between dates --> List<Login>
//    List<Login> findByDateOfBirthBetween
    //List<User> findByDateOfBirth(Date dob);
}
