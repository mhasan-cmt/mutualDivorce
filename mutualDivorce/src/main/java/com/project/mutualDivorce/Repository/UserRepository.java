package com.project.mutualDivorce.Repository;

import com.project.mutualDivorce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserBySurname(String surname);

    void deleteById(long id);
}
