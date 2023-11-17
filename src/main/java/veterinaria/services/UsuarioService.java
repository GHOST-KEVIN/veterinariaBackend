package veterinaria.services;

import java.util.Set;
import veterinaria.modelo.Usuario;

public interface UsuarioService {
    Set<Usuario> todosLosUsuarios();
    
    Usuario usuarioById(Integer id);
    
    Usuario registrar(Usuario usuario);
    
    Usuario actualizar(Integer id,Usuario usuario);
    
    void eliminar(Integer id);
}
