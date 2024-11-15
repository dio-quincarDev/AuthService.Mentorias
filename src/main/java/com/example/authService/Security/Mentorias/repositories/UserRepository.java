package com.example.authService.Security.Mentorias.repositories;

import com.example.authService.Security.Mentorias.common.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
