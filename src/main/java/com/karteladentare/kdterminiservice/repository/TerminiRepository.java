package com.karteladentare.kdterminiservice.repository;

import com.karteladentare.kdterminiservice.domain.Termini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TerminiRepository extends JpaRepository<Termini, Long> {
    List<Termini> findAllByPacientiId(Long pacientiId);
}
