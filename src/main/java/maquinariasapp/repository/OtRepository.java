package maquinariasapp.repository;

import maquinariasapp.entity.Ot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtRepository extends JpaRepository<Ot, Long> {
}
