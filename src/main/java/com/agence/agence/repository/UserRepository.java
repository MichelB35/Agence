package com.agence.agence.repository;

import com.agence.agence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByLoginAndMdp(String login, String mdp);

    @Query("SELECT count(*) FROM User WHERE userRole = 'admin'")
    int countUserRoleAdmin();

    @Query("SELECT count(*) FROM User WHERE userRole = 'user'")
    int countUserRole();
    @Query("SELECT count(*) FROM User")
    int countIdUser();
}
