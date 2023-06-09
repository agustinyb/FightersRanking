package com.sherdog.FightersRanking.repository;

import com.sherdog.FightersRanking.domain.fighters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fightersRepository extends JpaRepository <fighters, Long> {
}
