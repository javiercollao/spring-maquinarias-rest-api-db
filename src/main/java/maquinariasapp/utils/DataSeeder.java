package maquinariasapp.utils;

import maquinariasapp.entity.Documentacion;
import maquinariasapp.entity.Maquinaria;
import maquinariasapp.entity.Operario;
import maquinariasapp.entity.Proveedor;
import maquinariasapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class DataSeeder implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private final OperarioRepository operarioRepository;

    @Autowired
    private final MaquinariaRepository maquinariaRepository;

    @Autowired
    private final DocumentacionRepository documentacionRepository;

    @Autowired
    private final OtRepository otRepository;

    @Autowired
    private final ProveedorRepository proveedorRepository;

    @Autowired
    private final ProveedorRepuestoRepository proveedorRepuestoRepository;

    @Autowired
    private final RepuestoRepository repuestoRepository;

    public DataSeeder(OperarioRepository operarioRepository, MaquinariaRepository maquinariaRepository, DocumentacionRepository documentacionRepository, OtRepository otRepository, ProveedorRepository proveedorRepository, ProveedorRepuestoRepository proveedorRepuestoRepository, RepuestoRepository repuestoRepository ) {
        this.operarioRepository = operarioRepository;
        this.documentacionRepository = documentacionRepository;
        this.maquinariaRepository = maquinariaRepository;
        this.otRepository = otRepository;
        this.proveedorRepository = proveedorRepository;
        this.proveedorRepuestoRepository = proveedorRepuestoRepository;
        this.repuestoRepository = repuestoRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // Operarios

        Operario operario_1 = new Operario();
        operario_1.setCorreo_operario("j@maquina.cl");
        operario_1.setNombre_operario("Javier");
        operario_1.setApellido_operario("Collao");
        operario_1.setCargo_operario("Jefe de mantenimiento");
        operarioRepository.save(operario_1);

        Operario operario_2 = new Operario();
        operario_2.setCorreo_operario("a@maquina.cl");
        operario_2.setNombre_operario("Antonio");
        operario_2.setApellido_operario("Rivera");
        operario_2.setCargo_operario("Jefe de mantenimiento");
        operarioRepository.save(operario_2);

        Operario operario_3 = new Operario();
        operario_3.setCorreo_operario("l@maquina.cl");
        operario_3.setNombre_operario("Luis");
        operario_3.setApellido_operario("Perez");
        operario_3.setCargo_operario("Mecanico");
        operarioRepository.save(operario_3);

        Operario operario_4 = new Operario();
        operario_4.setCorreo_operario("ac@maquina.cl");
        operario_4.setNombre_operario("Angelo");
        operario_4.setApellido_operario("Castro");
        operario_4.setCargo_operario("Mecanico");
        operarioRepository.save(operario_4);


        // Maquinarias

        Maquinaria maquinaria_1 = new Maquinaria();
        maquinaria_1.setCod_maquinaria("RRKK92");
        maquinaria_1.setNombre_maquinaria("Escabadora PM");
        maquinaria_1.setTipo_maquinaria("Escabadora");
        maquinaria_1.setFecha_ingreso_maquinaria(LocalDateTime.now());
        maquinaria_1.setPrecio_compra_maquinaria("35.000.000");
        maquinaria_1.setFrecuencia_mantenimiento_maquinaria("semanal");
        maquinaria_1.setHorometro_maquinaria("0");
        maquinariaRepository.save(maquinaria_1);

        Maquinaria maquinaria_2 = new Maquinaria();
        maquinaria_2.setCod_maquinaria("JVFR11");
        maquinaria_2.setNombre_maquinaria("Otra maquina PM");
        maquinaria_2.setTipo_maquinaria("Maquina");
        maquinaria_2.setFecha_ingreso_maquinaria(LocalDateTime.now());
        maquinaria_2.setPrecio_compra_maquinaria("15.000.000");
        maquinaria_2.setFrecuencia_mantenimiento_maquinaria("semanal");
        maquinaria_2.setHorometro_maquinaria("10");
        maquinariaRepository.save(maquinaria_2);


        // Proveedores

        Proveedor proveedor_1 = new Proveedor();
        proveedor_1.setNombre_proveedor("MaqHeavy Solutions");
        proveedorRepository.save(proveedor_1);

        Proveedor proveedor_2 = new Proveedor();
        proveedor_2.setNombre_proveedor("MegaEquip Maquinaria");
        proveedorRepository.save(proveedor_2);

        Proveedor proveedor_3 = new Proveedor();
        proveedor_3.setNombre_proveedor("PowerTech Machinery");
        proveedorRepository.save(proveedor_3);

        Proveedor proveedor_4 = new Proveedor();
        proveedor_4.setNombre_proveedor("ProMaq Industries");
        proveedorRepository.save(proveedor_4);

        Proveedor proveedor_5 = new Proveedor();
        proveedor_5.setNombre_proveedor("HeavyMax Supplies");
        proveedorRepository.save(proveedor_5);




    }

}
