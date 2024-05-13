package com.example.demo.auth.repo;


import com.example.demo.user.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthRepository extends CrudRepository<Users,Long> {

    UserDetails findByUsername(String username);

}
