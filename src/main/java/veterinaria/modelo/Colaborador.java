package veterinaria.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "colaborador")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombres", length = 30, nullable = false)
    private String nombre;
    
    @Column(name = "apellidos", length = 30, nullable = false)
    private String apellido;
    
    @Column(name = "cargo", length = 25, nullable = false)
    private String cargo;
    
    @Column(name = "especialidad", length = 30, nullable = false)
    private String especialidad;
    
    @Column(name = "tipo_documento", length = 2, nullable = false)
    private String tipoDocumento;
    
    @Column(name = "documento_identificacion", nullable = false)
    private int documentoIdentificacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(int documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }
}
