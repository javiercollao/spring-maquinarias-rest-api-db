package maquinariasapp.repository;

import maquinariasapp.entity.Maquinaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinariaRepository extends JpaRepository<Maquinaria, Long> {
}
