package com.sherdog.FightersRanking.repository;

import com.sherdog.FightersRanking.domain.fighters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface fightersRepository extends JpaRepository<fighters, Long> {
@Query(value = "SELECT * FROM fighters WHERE name = :name", nativeQuery = true)
    Optional<fighters> findByName(@PathVariable("name") String name);
}
