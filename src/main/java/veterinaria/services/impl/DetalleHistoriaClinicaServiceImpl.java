package veterinaria.services.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.dto.DetalleHistoriaClinicaDTO;
import veterinaria.mappers.DetalleHistoriaClinicaMapper;
import veterinaria.models.Colaborador;
import veterinaria.models.DetalleHistoriaClinica;
import veterinaria.models.HistoriaClinica;
import veterinaria.repositorys.ColaboradorRepository;
import veterinaria.repositorys.DetalleHistoriaClinicaRepository;
import veterinaria.repositorys.HistoriaClinicaRepository;
import veterinaria.services.DetalleHistoriaClinicaService;

@Service
public class DetalleHistoriaClinicaServiceImpl implements DetalleHistoriaClinicaService{
    @Autowired
    private DetalleHistoriaClinicaRepository detalleHistoriaClinicaRepository;
    
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    
    @Autowired
    private DetalleHistoriaClinicaMapper detalleMapper;
    
    @Override
    public List<DetalleHistoriaClinicaDTO> obtenerTodo() {
        
        List<DetalleHistoriaClinica> detalles = detalleHistoriaClinicaRepository.findAll();
        List<DetalleHistoriaClinicaDTO> detallesDTO = detalleMapper.listDetalleHistoriaClinicaToListDetalleHistoriaClinicaDTO(detalles);
        
        for(DetalleHistoriaClinicaDTO detalleDTO : detallesDTO){
            
            HistoriaClinica historiaClinica = historiaClinicaRepository.findByHistoriaClinicaId(detalleDTO.getHistoriaClinicaId());
            detalleDTO.setHistoriaClinica(historiaClinica);
            
            Colaborador colaborador = colaboradorRepository.findByColaboradorId(detalleDTO.getColaboradorId());
            detalleDTO.setColaborador(colaborador);
        }
        
        return detallesDTO;
        
    }

    @Override
    public DetalleHistoriaClinicaDTO obtenerPorId(Integer id) {
        
       Optional<DetalleHistoriaClinica> detalle = detalleHistoriaClinicaRepository.findById(id);
       if(!detalle.isPresent()) return null;
       DetalleHistoriaClinicaDTO getDetalleDTO = detalleMapper.detalleHistoriaClinicaToDetalleHistoriaClinicaDTO(detalle.get());
       
       DetalleHistoriaClinicaDTO detalleDTO = new DetalleHistoriaClinicaDTO();
       detalleDTO.setId(getDetalleDTO.getId());
       detalleDTO.setTemperatura(getDetalleDTO.getTemperatura());
       detalleDTO.setPeso(getDetalleDTO.getPeso());
       detalleDTO.setFrecuenciaCardiaca(getDetalleDTO.getFrecuenciaCardiaca());
       detalleDTO.setFrecuenciaRespiratoria(getDetalleDTO.getFrecuenciaRespiratoria());
       detalleDTO.setFechaHora(getDetalleDTO.getFechaHora());
       detalleDTO.setAlimentacion(getDetalleDTO.getAlimentacion());
       detalleDTO.setHabitad(getDetalleDTO.getHabitad());
       detalleDTO.setObservacion(getDetalleDTO.getObservacion());
       detalleDTO.setHistoriaClinicaId(getDetalleDTO.getHistoriaClinicaId());
       
       HistoriaClinica historia = historiaClinicaRepository.findByHistoriaClinicaId(getDetalleDTO.getHistoriaClinicaId());
       detalleDTO.setHistoriaClinica(historia);
       
       Colaborador colaborador = colaboradorRepository.findByColaboradorId(getDetalleDTO.getColaboradorId());
       detalleDTO.setColaborador(colaborador);
       
       return detalleDTO;
    }

    @Override
    public DetalleHistoriaClinica registrar(DetalleHistoriaClinica detalleHistoriaClinica) {
        
        return detalleHistoriaClinicaRepository.save(detalleHistoriaClinica);
        
    }

    @Override
    public DetalleHistoriaClinica actualizar(Integer id, DetalleHistoriaClinica detalleHistoriaClinica) {
        
        return detalleHistoriaClinicaRepository.save(detalleHistoriaClinica);
        
    }

    @Override
    public void eliminar(Integer id) {
        DetalleHistoriaClinica detalles = new DetalleHistoriaClinica();
        detalles.setId(id);
        
        detalleHistoriaClinicaRepository.delete(detalles);
    }
}