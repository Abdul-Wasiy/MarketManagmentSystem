package hu.cs.se.repository;

import hu.cs.se.model.MyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<MyCategory,Long> {
}
