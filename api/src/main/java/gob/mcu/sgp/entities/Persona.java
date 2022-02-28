package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona", schema = "sgp")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Character sexo;

    @Column(nullable = false)
    private Long documento;

    @Column(nullable = false)
    private String numeroTramite;

    @Column(nullable = false)
    private Long cuil;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "documento_tipo_id")
    private DocumentoTipo documentoTipo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "persona_tipo_id")
    private PersonaTipo personaTipo;

    @OneToMany(mappedBy = "persona")
    private List<FormaComunicacion> formaComunicacionList;

    @OneToMany(mappedBy = "persona")
    private List<RolPersona> rolPersonas;

    @ManyToMany
    @JoinTable(
            name = "persona_direccion",
            joinColumns = @JoinColumn(name = "personaId"),
            inverseJoinColumns = @JoinColumn(name = "direccionId")
    )
    private List<Direccion> direcciones;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, Character sexo, Long documento, String numeroTramite, Long cuil, Pais pais, DocumentoTipo documentoTipo, PersonaTipo personaTipo, List<FormaComunicacion> formaComunicacionList, List<RolPersona> rolPersonas, List<Direccion> direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.documento = documento;
        this.numeroTramite = numeroTramite;
        this.cuil = cuil;
        this.pais = pais;
        this.documentoTipo = documentoTipo;
        this.personaTipo = personaTipo;
        this.formaComunicacionList = formaComunicacionList;
        this.rolPersonas = rolPersonas;
        this.direcciones = direcciones;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(String numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

    public Long getCuil() {
        return cuil;
    }

    public void setCuil(Long cuil) {
        this.cuil = cuil;
    }

    public gob.mcu.sgp.entities.Pais getPais() {
        return pais;
    }

    public void setPais(gob.mcu.sgp.entities.Pais pais) {
        this.pais = pais;
    }

    public gob.mcu.sgp.entities.DocumentoTipo getDocumentoTipo() {
        return documentoTipo;
    }

    public void setDocumentoTipo(gob.mcu.sgp.entities.DocumentoTipo documentoTipo) {
        this.documentoTipo = documentoTipo;
    }

    public PersonaTipo getPersonaTipo() {
        return personaTipo;
    }

    public void setPersonaTipo(PersonaTipo personaTipo) {
        this.personaTipo = personaTipo;
    }

    public List<FormaComunicacion> getFormaComunicacionList() {
        return formaComunicacionList;
    }

    public void setFormaComunicacionList(List<FormaComunicacion> formaComunicacionList) {
        this.formaComunicacionList = formaComunicacionList;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<RolPersona> getRolPersonas() {
        return rolPersonas;
    }

    public void setRolPersonas(List<RolPersona> rolPersonas) {
        this.rolPersonas = rolPersonas;
    }

}
