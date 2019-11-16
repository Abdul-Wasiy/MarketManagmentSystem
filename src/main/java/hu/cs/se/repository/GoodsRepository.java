package hu.cs.se.repository;

import hu.cs.se.model.Good;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Good,Long> {
}
