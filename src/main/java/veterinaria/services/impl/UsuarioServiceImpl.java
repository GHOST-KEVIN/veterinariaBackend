package veterinaria.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.dto.MascotaDTO;
import veterinaria.dto.UsuarioDTO;
import veterinaria.exepciones.ResourceNotFoundException;
import veterinaria.mappers.MascotaMapper;
import veterinaria.mappers.UsuarioMapper;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Mascota;
import veterinaria.models.Usuario;
import veterinaria.repositorys.HistoriaClinicaRepository;
import veterinaria.repositorys.MascotaRepository;
import veterinaria.repositorys.UsuarioRepository;
import veterinaria.services.HistoriaClinicaService;
import veterinaria.services.MascotaService;
import veterinaria.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private HistoriaClinicaRepository historiaRepository;
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Autowired
    private MascotaMapper mascotaMapper;
    
    @Autowired
    private MascotaService mascotaService;
    
    @Autowired
    private HistoriaClinicaService historiaService;
    
    @Override
    public List<UsuarioDTO> obtenerTodo() {
        
        return usuarioMapper.listUsuarioToListUsuarioDTO(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO obtenerPorId(Integer id) {
        
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(!usuario.isPresent()) return null;
        
        UsuarioDTO usuarioDTO = usuarioMapper.usuarioToUsuarioDTO(usuario.get());
        List<Mascota> mascotas = mascotaRepository.findByUsuarioId(usuarioDTO.getId());
        List<MascotaDTO> mascotasDTO = mascotaMapper.listMascotaToListMascotaDTO(mascotas);
        usuarioDTO.setMascotas(mascotasDTO);
        
        return usuarioDTO;
    }
    
    @Override
    public Usuario registrar(Usuario usuario) {
        
        List<Usuario> usuariosDB = usuarioRepository.findAll();
        
        for(Usuario usu : usuariosDB){
            
            int numeroIdentificacionDB = usu.getDocumentoIdentificacion();
            if(numeroIdentificacionDB == usuario.getDocumentoIdentificacion()){
                throw new ResourceNotFoundException("Ya existe el numero de identificacion: "+ numeroIdentificacionDB);
            }
        }
        
        return usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(!usuarioOptional.isPresent()) return null;
        usuario.setId(usuarioOptional.get().getId());
        
        List<Usuario> usuariosDB = usuarioRepository.findAll();
        for (Usuario usu : usuariosDB) {
            
            if (usu.getId() != usuario.getId()) {
                
                int numeroIdentificacionDB = usu.getDocumentoIdentificacion();
                if (usuario.getDocumentoIdentificacion() == numeroIdentificacionDB) {

                    throw new ResourceNotFoundException("Ya existe el numero de identificacion: " + numeroIdentificacionDB);
                }
            }
            
        }
        
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Integer id) {
        
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(!usuarioOptional.isPresent()) return;
        
        List<Mascota> mascotas = mascotaRepository.findAll();
        for(Mascota mascota : mascotas){
            
           List<HistoriaClinica> historiasClinicas = historiaRepository.findAll();
           for(HistoriaClinica historia : historiasClinicas){
               
               historiaService.eliminar(historia.getId());
            }
           
           mascotaService.eliminar(mascota.getId());
        }
        
        usuarioRepository.delete(usuarioOptional.get());
    }
}