package com.project.mutualDivorce.Repository;

import com.project.mutualDivorce.Entity.Divorce;
import com.project.mutualDivorce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DivorceRepository extends JpaRepository<Divorce, Long> {
    Divorce findById(long id);
    Optional<List<Divorce>> findAllByUser(User user);

}