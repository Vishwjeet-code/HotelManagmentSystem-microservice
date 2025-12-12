package com.vishwjeet.User.Service.Repository;

import com.vishwjeet.User.Service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
