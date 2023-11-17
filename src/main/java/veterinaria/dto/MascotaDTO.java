package veterinaria.dto;

import lombok.Data;
import veterinaria.modelo.HistoriaClinica;
import veterinaria.modelo.Usuario;

@Data
public class MascotaDTO {
   
    private int id;
    private String nombre;
    private String raza;
    private String sexo;
    private Usuario usuario;
    private HistoriaClinica historiaClinica;
    
}
