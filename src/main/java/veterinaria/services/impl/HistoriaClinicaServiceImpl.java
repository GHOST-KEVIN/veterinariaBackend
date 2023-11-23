package veterinaria.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.dto.HistoriaClinicaDTO;
import veterinaria.mappers.HistoriaClinicaMapper;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Mascota;
import veterinaria.repositorys.HistoriaClinicaRepository;
import veterinaria.repositorys.MascotaRepository;
import veterinaria.services.HistoriaClinicaService;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService{
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private HistoriaClinicaMapper historiaMapper;
    
    @Override
    public List<HistoriaClinicaDTO> obtenerTodo() {
        
        List<HistoriaClinica> historias = historiaClinicaRepository.findAll();
        List<HistoriaClinicaDTO> historiasDTO = historiaMapper.listHistoriaClinicaToListHistoriaClinicaDTO(historias);
        
        for(HistoriaClinicaDTO historiaDTO : historiasDTO){
            Mascota mascota = mascotaRepository.findByMascotaId(historiaDTO.getMascotaId());
            historiaDTO.setMascota(mascota);
        }
        
        return historiasDTO;
    }

    @Override
    public HistoriaClinicaDTO obtenerPorId(Integer id) {
        
        Optional<HistoriaClinica> historiaClinica = historiaClinicaRepository.findById(id);
        if(!historiaClinica.isPresent()) return null;
        HistoriaClinicaDTO getHistoriaDTO = historiaMapper.historiaClinicaToHistoriaClinicaDTO(historiaClinica.get());
        
        HistoriaClinicaDTO historiaDTO = new HistoriaClinicaDTO();
        historiaDTO.setId(getHistoriaDTO.getId());
        historiaDTO.setFechaCreacion(getHistoriaDTO.getFechaCreacion());
        historiaDTO.setMascotaId(getHistoriaDTO.getMascotaId());
        Mascota mascota = mascotaRepository.findByMascotaId(getHistoriaDTO.getMascotaId());
        historiaDTO.setMascota(mascota);
        
        return historiaDTO;
        
    }

    @Override
    public HistoriaClinica registrar(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }
        
    @Override
    public HistoriaClinica actualizar(Integer id, HistoriaClinica historiaClinica) {
        Optional<HistoriaClinica> historiaClinicaOptional = historiaClinicaRepository.findById(id);
        
        historiaClinica.setId(historiaClinicaOptional.get().getId());
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public void eliminar(Integer id) {
//        Optional<HistoriaClinica> historiaClinicaOptional = historiaClinicaRepository.findById(id);
        historiaClinicaRepository.deleteById(id);
    }
}