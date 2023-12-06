package veterinaria.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import veterinaria.dto.UsuarioDTO;
import veterinaria.models.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    
    public List<UsuarioDTO> listUsuarioToListUsuarioDTO(List<Usuario> usuario);
    
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
    
}