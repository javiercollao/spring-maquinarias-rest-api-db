package maquinariasapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Builder
@Table(name="documentacion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Documentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_documentacion", unique=true, nullable = false)
    private Long id_documentacion;

    @Column(name="desc_documentacion", length = 200, nullable = false)
    private String desc_documentacion;

    @Column(name="nombre_documentacion", length = 70, nullable = false)
    private String nombre_documentacion;

    @Column(name="archivo_documentacion", nullable = false)
    private String archivo_documentacion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "maquina_documentacion", joinColumns = @JoinColumn(name = "id_documentacion", referencedColumnName = "id_documentacion"), inverseJoinColumns = @JoinColumn(name = "id_maquinaria", referencedColumnName = "id_maquinaria"))
    @JsonIgnore
    private List<Maquinaria> maquinarias = new ArrayList<>();

}
