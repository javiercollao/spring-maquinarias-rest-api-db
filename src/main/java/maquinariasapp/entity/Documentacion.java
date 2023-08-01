package maquinariasapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="documentacion")
public class Documentacion {
    @Id
    @Column(name="id_documentacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentacion;

    @Column(name="tipo_documentacion", length = 30, nullable = false)
    private String tipo_documentacion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "maquina_documentacion", joinColumns = @JoinColumn(name = "id_documentacion", referencedColumnName = "id_documentacion"), inverseJoinColumns = @JoinColumn(name = "id_maquinaria", referencedColumnName = "id_maquinaria"))
    @JsonIgnore
    private List<Maquinaria> maquinarias = new ArrayList<>();
}
