package gob.mcu.sgp.entities;

import javax.persistence.*;

@Entity
@Table(name = "documento_tipo", schema = "sgp")
public class DocumentoTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 120, nullable = false)
    private String nombre;

    public DocumentoTipo() {
    }

    public DocumentoTipo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}