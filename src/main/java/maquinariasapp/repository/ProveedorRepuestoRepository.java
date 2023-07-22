package maquinariasapp.repository;

import maquinariasapp.entity.ProveedorRepuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepuestoRepository extends JpaRepository<ProveedorRepuesto, Long> {
}
