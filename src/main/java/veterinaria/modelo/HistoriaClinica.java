package veterinaria.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "fecha_creacion", nullable = false)

    private LocalDate fechaCreacion;
    
    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<DetalleHistoriaClinica> detalleHistoriaClinica = new LinkedHashSet<>();
    
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @OneToOne
    @JoinColumn(name = "mascota_id", referencedColumnName = "id", nullable = true)
    private Mascota mascota;
    
    public HistoriaClinica(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Set<DetalleHistoriaClinica> getDetalleHistoriaClinica() {
        return detalleHistoriaClinica;
    }

    public void setDetalleHistoriaClinica(Set<DetalleHistoriaClinica> detalleHistoriaClinica) {
        this.detalleHistoriaClinica = detalleHistoriaClinica;
    }

    @Override
    public String toString() {
        return "HistoriaClinica{" + "id=" + id + ", fechaCreacion=" + fechaCreacion + ", detalleHistoriaClinica=" + detalleHistoriaClinica + '}';
    }
    
    
}
