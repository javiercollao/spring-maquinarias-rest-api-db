package maquinariasapp.service;

import maquinariasapp.dtos.ProveedorDTO;
import maquinariasapp.entity.Proveedor;
import maquinariasapp.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor crearNuevoProveedor(ProveedorDTO proveedor){
        Proveedor nuevoProveedor = new Proveedor();
        nuevoProveedor.setNombre_proveedor(proveedor.getNombre_proveedor());
        return proveedorRepository.save(nuevoProveedor);
    }

    public List<Proveedor> obtenerTodosLosProveedores(){
        return proveedorRepository.findAll().stream().toList();
    }


    public Proveedor obtenerProveedorPorId(Long proveedorId){
        return proveedorRepository.findById(proveedorId).get();
    }
}
