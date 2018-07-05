package com.mystudy.spring.repository;

import com.mystudy.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>
{
}
