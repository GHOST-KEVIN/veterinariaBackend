package veterinaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import veterinaria.models.Usuario;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDTO {
   
    private int id;
    private String nombre;
    private String raza;
    private String sexo;
    private Integer usuarioId;
    private Usuario usuario;
}