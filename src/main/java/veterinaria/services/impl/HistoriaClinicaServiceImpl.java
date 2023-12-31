package veterinaria.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.dto.DetalleHistoriaClinicaDTO;
import veterinaria.dto.HistoriaClinicaDTO;
import veterinaria.exepciones.ResourceNotFoundException;
import veterinaria.mappers.DetalleHistoriaClinicaMapper;
import veterinaria.mappers.HistoriaClinicaMapper;
import veterinaria.models.DetalleHistoriaClinica;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Mascota;
import veterinaria.models.Usuario;
import veterinaria.repositorys.DetalleHistoriaClinicaRepository;
import veterinaria.repositorys.HistoriaClinicaRepository;
import veterinaria.repositorys.MascotaRepository;
import veterinaria.repositorys.UsuarioRepository;
import veterinaria.services.HistoriaClinicaService;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService{
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private DetalleHistoriaClinicaRepository detalleRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private HistoriaClinicaMapper historiaMapper;
    
    @Autowired
    private DetalleHistoriaClinicaMapper detalleMapper;
    
    @Override
    public List<HistoriaClinicaDTO> obtenerTodo() {

        List<HistoriaClinica> historias = historiaClinicaRepository.findAll();
        List<HistoriaClinicaDTO> historiasDTO = historiaMapper.listHistoriaClinicaToListHistoriaClinicaDTO(historias);
        List<HistoriaClinicaDTO> historiasActivasDTO = new ArrayList<>();

        for (HistoriaClinicaDTO historiaDTO : historiasDTO) {

            Mascota mascota = mascotaRepository.findByMascotaId(historiaDTO.getMascotaId());
            historiaDTO.setMascota(mascota);

            Usuario usuario = usuarioRepository.findByUsuarioId(mascota.getUsuarioId());
            boolean estado = usuario.isEstado();

            if (estado) {
                historiasActivasDTO.add(historiaDTO);
            }
        }

        return historiasActivasDTO;
    }

    @Override
    public HistoriaClinicaDTO obtenerPorId(Integer id) {
        
        Optional<HistoriaClinica> historiaClinica = historiaClinicaRepository.findById(id);
        if(!historiaClinica.isPresent()) return null;
        
        HistoriaClinicaDTO historiaDTO = historiaMapper.historiaClinicaToHistoriaClinicaDTO(historiaClinica.get());
        Mascota mascota = mascotaRepository.findByMascotaId(historiaDTO.getMascotaId());
        historiaDTO.setMascota(mascota);
        
        List<DetalleHistoriaClinica> detalles = detalleRepository.findBydetalleId(historiaDTO.getId());
        List<DetalleHistoriaClinicaDTO> detallesDTO = detalleMapper.listDetalleHistoriaClinicaToListDetalleHistoriaClinicaDTO(detalles);
        historiaDTO.setDetallesClinicos(detallesDTO);
        
        return historiaDTO;
    }

    @Override
    public HistoriaClinica registrar(HistoriaClinica historiaClinica){
        
        Optional<HistoriaClinica> historiaClinicaOptional = historiaClinicaRepository.findByMascotaId(historiaClinica.getMascotaId());
        Integer mascotaId = historiaClinica.getMascotaId();
        Mascota mascota = mascotaRepository.findByMascotaId(mascotaId);
        
        if (historiaClinicaOptional.isPresent()) {
            throw new ResourceNotFoundException("La mascota " + mascota.getNombre() + " ya tiene una historia clínica asociada.");
        }
        
        return historiaClinicaRepository.save(historiaClinica);
    }
        
    @Override
    public HistoriaClinica actualizar(Integer id, HistoriaClinica historiaClinica) {

        Optional<HistoriaClinica> historiaClinicaOptional = historiaClinicaRepository.findById(id);
        if (!historiaClinicaOptional.isPresent()) {
            throw new ResourceNotFoundException("No se encontró la historia clínica con el id " + id);
        }

        Integer mascotaId = historiaClinica.getMascotaId();
        Mascota mascota = mascotaRepository.findByMascotaId(mascotaId);
        Optional<HistoriaClinica> historiaClinicaPorMascota = historiaClinicaRepository.findByMascotaId(mascotaId);
        if (historiaClinicaPorMascota.isPresent() && historiaClinicaPorMascota.get().getId() != id && !mascota.getNombre().isEmpty()) {
            
            throw new ResourceNotFoundException("Ya existe una historia clínica para la mascota con el nombre " + mascota.getNombre());
        }

        historiaClinica.setId(id);
        
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public void eliminar(Integer id) {
        
        Optional<HistoriaClinica> historiaClinicaOptional = historiaClinicaRepository.findById(id);
        if(!historiaClinicaOptional.isPresent()) return;
        
        historiaClinicaRepository.delete(historiaClinicaOptional.get());
        detalleRepository.deleteByHistoriaClinicaId(id);
    }
}