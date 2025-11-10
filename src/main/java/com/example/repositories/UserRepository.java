package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entities.User;
import java.util.List;



public interface UserRepository extends JpaRepository<User, Long>
{
	User findByEmail(String email);
	User findByPhoneno(String phoneno);
	User findById(long id);
}
