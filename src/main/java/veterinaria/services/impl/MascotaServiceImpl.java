package veterinaria.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.dto.MascotaDTO;
import veterinaria.mappers.MascotaMapper;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Mascota;
import veterinaria.models.Usuario;
import veterinaria.repositorys.HistoriaClinicaRepository;
import veterinaria.repositorys.MascotaRepository;
import veterinaria.repositorys.UsuarioRepository;
import veterinaria.services.HistoriaClinicaService;
import veterinaria.services.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService{
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private HistoriaClinicaRepository historiaRepository;
    
    @Autowired
    private HistoriaClinicaService historiaService;
    
    @Autowired
    private MascotaMapper mascotaMapper;
    
    @Override
    public List<MascotaDTO> obtenerTodo() {
        
        List<MascotaDTO> mascotasDTO = mascotaMapper.listMascotaToListMascotaDTO(mascotaRepository.findAll());
        
        for(MascotaDTO mascotaDTO : mascotasDTO){
            
            Usuario usuario = usuarioRepository.findByUsuarioId(mascotaDTO.getUsuarioId());
            mascotaDTO.setUsuario(usuario);
            
        }
        
        return mascotasDTO;
        
    }

    @Override
    public MascotaDTO obtenerPorId(Integer id) {
        Optional<Mascota> mascota = mascotaRepository.findById(id);
        if(!mascota.isPresent()) return null;
        
        MascotaDTO getMascotaDTO = mascotaMapper.mascotaToMascotaDTO(mascota.get());
        
        MascotaDTO mascotaDTO = new MascotaDTO();
        mascotaDTO.setId(getMascotaDTO.getId());
        mascotaDTO.setNombre(getMascotaDTO.getNombre());
        mascotaDTO.setRaza(getMascotaDTO.getRaza());
        mascotaDTO.setSexo(getMascotaDTO.getSexo());
        mascotaDTO.setUsuarioId(getMascotaDTO.getUsuarioId());
        Usuario usuario = usuarioRepository.findByUsuarioId(getMascotaDTO.getUsuarioId());
        mascotaDTO.setUsuario(usuario);
        
        return mascotaDTO;
    }

    @Override
    public Mascota registrar(Mascota mascota) {
        
        return mascotaRepository.save(mascota);
        
    }

    @Override
    public Mascota actualizar(Integer id, Mascota mascota) {
        
        return mascotaRepository.save(mascota);
        
    }
    
    @Override
    public void eliminar(Integer id) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        if(!mascotaOptional.isPresent()) return;
        
        List<HistoriaClinica> historiasClinicas = historiaRepository.findAll();
           
           for(HistoriaClinica historia : historiasClinicas){
               
               historiaService.eliminar(historia.getId());
               
           }
           
        mascotaRepository.delete(mascotaOptional.get());
        
    }
    
}
