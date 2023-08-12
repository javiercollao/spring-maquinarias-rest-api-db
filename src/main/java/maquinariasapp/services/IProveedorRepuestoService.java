package maquinariasapp.services;

import maquinariasapp.entity.ProveedorRepuesto;

import java.awt.print.Pageable;
import java.util.List;

public interface IProveedorRepuestoService {
    public ProveedorRepuesto crearRelacionProveedorRepuesto(ProveedorRepuesto proveedorRepuesto);
    public String eliminarRelacionProveedorRepuesto(Long proveedorRepuestoId);
    public List<ProveedorRepuesto> obtenerRepuestosQueVendeProveedorPorId(Long proveedorId);
    public List<ProveedorRepuesto> obtenerProveedoresQueVendenUnRepuestoPorId(Long repuestoId);
    public ProveedorRepuesto actualizarDatosRelacionProveedorRepuesto(Long proveedorProductoId, ProveedorRepuesto proveedorRepuesto);
}
