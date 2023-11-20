package veterinaria.dto;

import lombok.Data;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Usuario;

@Data
public class MascotaDTO {
   
    private int id;
    private String nombre;
    private String raza;
    private String sexo;
    private Usuario usuario;
    private HistoriaClinica historiaClinica;
}
