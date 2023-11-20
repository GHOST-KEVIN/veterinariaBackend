package veterinaria.services.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.models.Usuario;
import veterinaria.repositorys.UsuarioRepository;
import veterinaria.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Set<Usuario> todosLosUsuarios() {
        return new LinkedHashSet<>(usuarioRepository.findAll());
    }

    @Override
    public Usuario usuarioById(Integer id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        
        if(!usuarioOptional.isPresent()) return null;
        
        return usuarioOptional.get();
    }
    
    @Override
    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        
        if(!usuarioOptional.isPresent()) return null;
        
        usuario.setId(usuarioOptional.get().getId());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        usuarioRepository.delete(usuarioOptional.get());
    }

    
    
}
