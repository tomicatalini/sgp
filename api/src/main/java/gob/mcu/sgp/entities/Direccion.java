package gob.mcu.sgp.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "direccion", schema = "sgp")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numero;
    private String piso;
    private String departamento;
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "calle_id")
    private Calle calle;

    @ManyToOne
    @JoinColumn(name = "entre_calle_primera")
    private Calle entreCallePrimera;

    @ManyToOne
    @JoinColumn(name = "entre_calle_segunda")
    private Calle entreCalleSegunda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion_tipo_id")
    private DireccionTipo direccionTipo;

    public Direccion() {
    }

    public Direccion(Long id, Integer numero, String piso, String departamento, LocalDate fechaInicio, LocalDate fechaFin, Calle calle, Calle entreCallePrimera, Calle entreCalleSegunda, Localidad localidad, DireccionTipo direccionTipo) {
        this.id = id;
        this.numero = numero;
        this.piso = piso;
        this.departamento = departamento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.calle = calle;
        this.entreCallePrimera = entreCallePrimera;
        this.entreCalleSegunda = entreCalleSegunda;
        this.localidad = localidad;
        this.direccionTipo = direccionTipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }

    public Calle getEntreCallePrimera() {
        return entreCallePrimera;
    }

    public void setEntreCallePrimera(Calle entreCallePrimera) {
        this.entreCallePrimera = entreCallePrimera;
    }

    public Calle getEntreCalleSegunda() {
        return entreCalleSegunda;
    }

    public void setEntreCalleSegunda(Calle entreCalleSegunda) {
        this.entreCalleSegunda = entreCalleSegunda;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public DireccionTipo getDireccionTipo() {
        return direccionTipo;
    }

    public void setDireccionTipo(DireccionTipo direccionTipo) {
        this.direccionTipo = direccionTipo;
    }
}
