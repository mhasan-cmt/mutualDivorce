package com.project.mutualDivorce.Repository;

import com.project.mutualDivorce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.DoubleStream;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}