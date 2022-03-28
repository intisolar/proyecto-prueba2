package com.exams.createexams.repositories;

import com.exams.createexams.models.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

    List<User> findBySoftDeleteFalseOrderByFirstName();

}
