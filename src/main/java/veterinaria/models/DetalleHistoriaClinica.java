package veterinaria.models;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name = "detalle_historia_clinica")
public class DetalleHistoriaClinica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "temperatura", nullable = false, length = 255)
    private String temperatura;
    
    @Column(name = "peso", nullable = false)
    private double peso;
    
    @Column(name = "frecuencia_cardiaca", nullable = false)
    private double frecuenciaCardiaca;
    
    @Column(name = "frecuencia_respiratoria", nullable = false)
    private double frecuenciaRespiratoria;
    
    @Column(name = "fecha_hora", nullable = false)
    private ZonedDateTime fechaHora;
    
    @Column(name = "alimentacion", nullable = false, length = 255)
    private String alimentacion;
    
    @Column(name = "habitad", nullable = false, length = 255)
    private String habitad;
    
    @Column(name = "observacion", nullable = false, length = 255)
    private String observacion;
    
    @Column(name = "historia_clinica_id", nullable = false)
    private Integer historiaClinicaId;
    
    @Column(name = "colaborador_id", nullable = false)
    private Integer colaboradorId;
    
}