package veterinaria.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import veterinaria.models.Mascota;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    
    private int id;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private int documentoIdentificacion;
    private boolean estado;
    private String sexo;
    private List<MascotaDTO> mascotas;
}