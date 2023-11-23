package veterinaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    
    private int id;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private int documentoIdentificacion;
    private String sexo;
    
}
