package veterinaria.dto;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import veterinaria.models.Colaborador;
import veterinaria.models.HistoriaClinica;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleHistoriaClinicaDTO {
    
    private int id;
    private String temperatura;
    private double peso;
    private double frecuenciaCardiaca;
    private double frecuenciaRespiratoria;
    private ZonedDateTime fechaHora;
    private String alimentacion;
    private String habitad;
    private String observacion;
    private Integer historiaClinicaId;
    private HistoriaClinica historiaClinica;
    private Integer colaboradorId;
    private Colaborador colaborador;
}