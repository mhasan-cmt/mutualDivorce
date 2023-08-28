package com.project.mutualDivorce.Repository;

import com.project.mutualDivorce.Entity.Divorce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivorceRepository extends JpaRepository<Divorce, Long> {
    Divorce findById(long id);


}