package org.example.securtiy_role_and_jwt_1.myjpas;

import org.example.securtiy_role_and_jwt_1.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserLoginJpa extends JpaRepository<UserLogin,Long> {
    UserLogin findByUsername(String username);
}
