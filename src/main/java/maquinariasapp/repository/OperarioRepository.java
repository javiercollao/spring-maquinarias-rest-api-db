package maquinariasapp.repository;

import maquinariasapp.entity.Operario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperarioRepository extends JpaRepository<Operario, Long> {
    public Operario findByUsername(String username);
}
