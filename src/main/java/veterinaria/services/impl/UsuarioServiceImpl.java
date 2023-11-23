package veterinaria.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.dto.UsuarioDTO;
import veterinaria.mappers.UsuarioMapper;
import veterinaria.models.Mascota;
import veterinaria.models.Usuario;
import veterinaria.repositorys.MascotaRepository;
import veterinaria.repositorys.UsuarioRepository;
import veterinaria.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Override
    public List<UsuarioDTO> obtenerTodo() {
        
        return usuarioMapper.listUsuarioToListUsuarioDTO(usuarioRepository.findAll());
        
    }

    @Override
    public UsuarioDTO obtenerPorId(Integer id) {
        
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(!usuario.isPresent()) return null;
        UsuarioDTO getUsuarioDTO = usuarioMapper.usuarioToUsuarioDTO(usuario.get());
        
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(getUsuarioDTO.getId());
        usuarioDTO.setNombre(getUsuarioDTO.getNombre());
        usuarioDTO.setApellido(getUsuarioDTO.getApellido());
        usuarioDTO.setTipoDocumento(getUsuarioDTO.getTipoDocumento());
        usuarioDTO.setDocumentoIdentificacion(getUsuarioDTO.getDocumentoIdentificacion());
        usuarioDTO.setSexo(getUsuarioDTO.getSexo());
        
        return usuarioDTO;
        
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
        mascotaRepository.deleteByMascotaId(id);
        
    }

}
