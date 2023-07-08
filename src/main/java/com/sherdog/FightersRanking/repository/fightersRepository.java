package com.sherdog.FightersRanking.repository;

import com.sherdog.FightersRanking.domain.fighters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface fightersRepository extends JpaRepository<fighters, Long> {
    @Query(value = "SELECT * FROM fighters WHERE lower (name) LIKE lower(:name)", nativeQuery = true)
    List<fighters> findByName(String name);

}
