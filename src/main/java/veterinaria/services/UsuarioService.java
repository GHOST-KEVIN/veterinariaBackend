package veterinaria.services;

import java.util.List;
import veterinaria.dto.UsuarioDTO;
import veterinaria.models.Usuario;

public interface UsuarioService {
    List<UsuarioDTO> obtenerTodo();
    
    UsuarioDTO obtenerPorId(Integer id);
    
    Usuario registrar(Usuario usuario);
    
    Usuario actualizar(Integer id,Usuario usuario);
    
    void eliminar(Integer id);
}
