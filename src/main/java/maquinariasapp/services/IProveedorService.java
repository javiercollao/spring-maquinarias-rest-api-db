package maquinariasapp.services;

import maquinariasapp.entity.Proveedor;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IProveedorService {
    public Proveedor crearNuevoProveedor(Proveedor proveedor);
    public Proveedor obtenerProveedorPorId(Long id);
    public List<Proveedor> obtenerProveedores(Pageable page);
    public Proveedor actualizarDatosProveedor(Long id, Proveedor proveedor);
}
