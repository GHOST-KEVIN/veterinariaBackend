package veterinaria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorDTO {

    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String especialidad;
    private String tipoDocumento;
    private int documentoIdentificacion;
    
}