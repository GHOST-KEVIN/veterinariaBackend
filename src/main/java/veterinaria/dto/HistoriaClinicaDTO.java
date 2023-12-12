package veterinaria.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import veterinaria.models.Mascota;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoriaClinicaDTO {
    
    private int id;
    private LocalDate fechaCreacion;
    private Integer mascotaId;
    private Mascota mascota;
    private List<DetalleHistoriaClinicaDTO> detallesClinicos;
}