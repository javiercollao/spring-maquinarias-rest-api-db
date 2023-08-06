package maquinariasapp.utils;

import jakarta.transaction.Transactional;
import maquinariasapp.entity.*;
import maquinariasapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

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

    @Autowired
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
    @Transactional
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


        // Documentacion

        Documentacion doc_1 = new Documentacion();
        doc_1.setDesc_documentacion("Documento 1");
        doc_1.setNombre_documentacion("Manual de radio");
        doc_1.setArchivo_documentacion("manual_2023_08_04_radio.pdf");
        List<Maquinaria> maqs = doc_1.getMaquinarias();
        maqs.add(maquinaria_1);
        maqs.add(maquinaria_2);
        documentacionRepository.save(doc_1);

        Documentacion doc_2 = new Documentacion();
        doc_2.setDesc_documentacion("Documento 2");
        doc_2.setNombre_documentacion("Manual de motor");
        doc_2.setArchivo_documentacion("manual_2023_08_04_motor.pdf");
        List<Maquinaria> maqs_2 = doc_2.getMaquinarias();
        maqs_2.add(maquinaria_1);
        documentacionRepository.save(doc_2);

        Documentacion doc_3 = new Documentacion();
        doc_3.setDesc_documentacion("Documento 3");
        doc_3.setNombre_documentacion("Manual X");
        doc_3.setArchivo_documentacion("manual_r.pdf");
        List<Maquinaria> maqs_3 = doc_3.getMaquinarias();
        maqs_3.add(maquinaria_1);
        documentacionRepository.save(doc_3);

        Documentacion doc_4 = new Documentacion();
        doc_4.setDesc_documentacion("Documento 4");
        doc_4.setNombre_documentacion("Manual X");
        doc_4.setArchivo_documentacion("manual_r.pdf");
        documentacionRepository.save(doc_4);

        Documentacion doc_5 = new Documentacion();
        doc_5.setDesc_documentacion("Documento 5");
        doc_5.setNombre_documentacion("Manual X");
        doc_5.setArchivo_documentacion("manual_r.pdf");
        documentacionRepository.save(doc_5);

        Documentacion doc_6 = new Documentacion();
        doc_6.setDesc_documentacion("Documento 6");
        doc_6.setNombre_documentacion("Manual X");
        doc_6.setArchivo_documentacion("manual_r.pdf");
        documentacionRepository.save(doc_6);

        Documentacion doc_7 = new Documentacion();
        doc_7.setDesc_documentacion("Documento 7");
        doc_7.setNombre_documentacion("Manual X");
        doc_7.setArchivo_documentacion("manual_r.pdf");
        documentacionRepository.save(doc_7);


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


        // Repuestos

        Repuesto repuesto_1 = new Repuesto();
        repuesto_1.setNombre_repuesto("Repuesto 1");
        repuesto_1.setDesc_repuesto("Descripcion repuesto 1");
        repuestoRepository.save(repuesto_1);

        Repuesto repuesto_2 = new Repuesto();
        repuesto_2.setNombre_repuesto("Repuesto 2");
        repuesto_2.setDesc_repuesto("Descripcion repuesto 2");
        repuestoRepository.save(repuesto_2);

        Repuesto repuesto_3 = new Repuesto();
        repuesto_3.setNombre_repuesto("Repuesto 3");
        repuesto_3.setDesc_repuesto("Descripcion repuesto 3");
        repuestoRepository.save(repuesto_3);


        //Ots

        Ot ot_1 = new Ot();
        ot_1.setDesc_ot("Esta es una descripcion para la ot");
        ot_1.setFecha_ot(LocalDateTime.now());
        ot_1.setProxima_fecha_ot(LocalDateTime.now().plusWeeks(1));
        ot_1.setObservacion_ot("Necesita mantenimiento urgente en un dispostivo");
        ot_1.setClase_mantenimiento_ot("Correspondiente");
        ot_1.setOperario(operario_1);
        ot_1.setMaquinaria(maquinaria_1);
        otRepository.save(ot_1);

        Ot ot_2 = new Ot();
        ot_2.setDesc_ot("Esta es una descripcion para la ot");
        ot_2.setFecha_ot(LocalDateTime.now());
        ot_2.setProxima_fecha_ot(LocalDateTime.now().plusWeeks(1));
        ot_2.setObservacion_ot("Necesita mantenimiento urgente en un dispostivo");
        ot_2.setClase_mantenimiento_ot("Correspondiente");
        ot_2.setOperario(operario_1);
        ot_2.setMaquinaria(maquinaria_2);
        otRepository.save(ot_2);


        // Repuesto Proveedor

        ProveedorRepuesto pR_1 = new ProveedorRepuesto();
        pR_1.setCantidad_repuesto(5);
        pR_1.setRepuesto(repuesto_1);
        pR_1.setProveedor(proveedor_1);
        List<Ot> misRepuestos_1 = pR_1.getOts();
        misRepuestos_1.add(ot_1);
        pR_1.setOts(misRepuestos_1);
        proveedorRepuestoRepository.save(pR_1);

        ProveedorRepuesto pR_2 = new ProveedorRepuesto();
        pR_2.setCantidad_repuesto(5);
        pR_2.setRepuesto(repuesto_2);
        pR_2.setProveedor(proveedor_3);
        List<Ot> misRepuestos_2 = pR_2.getOts();
        misRepuestos_2.add(ot_1);
        pR_2.setOts(misRepuestos_2);
        proveedorRepuestoRepository.save(pR_2);

        ProveedorRepuesto pR_3 = new ProveedorRepuesto();
        pR_3.setCantidad_repuesto(2);
        pR_3.setRepuesto(repuesto_3);
        pR_3.setProveedor(proveedor_4);
        List<Ot> misRepuestos_3 = pR_3.getOts();
        misRepuestos_3.add(ot_2);
        pR_3.setOts(misRepuestos_3);
        proveedorRepuestoRepository.save(pR_3);

    }

}
