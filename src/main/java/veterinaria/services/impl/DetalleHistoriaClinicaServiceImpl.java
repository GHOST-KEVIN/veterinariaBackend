package veterinaria.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.dto.DetalleHistoriaClinicaDTO;
import veterinaria.mappers.DetalleHistoriaClinicaMapper;
import veterinaria.models.Colaborador;
import veterinaria.models.DetalleHistoriaClinica;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Mascota;
import veterinaria.models.Usuario;
import veterinaria.repositorys.ColaboradorRepository;
import veterinaria.repositorys.DetalleHistoriaClinicaRepository;
import veterinaria.repositorys.HistoriaClinicaRepository;
import veterinaria.repositorys.MascotaRepository;
import veterinaria.repositorys.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private DetalleHistoriaClinicaMapper detalleMapper;
    
    @Override
    public List<DetalleHistoriaClinicaDTO> obtenerTodo() {
        
        List<DetalleHistoriaClinica> detalles = detalleHistoriaClinicaRepository.findAll();
        List<DetalleHistoriaClinicaDTO> detallesDTO = detalleMapper.listDetalleHistoriaClinicaToListDetalleHistoriaClinicaDTO(detalles);
        List<DetalleHistoriaClinicaDTO> detallesActivosDTO = new ArrayList<>();

        for (DetalleHistoriaClinicaDTO detalleDTO : detallesDTO) {
            HistoriaClinica historiaClinica = historiaClinicaRepository.findByHistoriaClinicaId(detalleDTO.getHistoriaClinicaId());
            detalleDTO.setHistoriaClinica(historiaClinica);
            Colaborador colaborador = colaboradorRepository.findByColaboradorId(detalleDTO.getColaboradorId());
            detalleDTO.setColaborador(colaborador);

            Mascota mascota = mascotaRepository.findByMascotaId(historiaClinica.getMascotaId());
            Usuario usuario = usuarioRepository.findByUsuarioId(mascota.getUsuarioId());
            boolean estado = usuario.isEstado();


            if (estado) {
                detallesActivosDTO.add(detalleDTO);
            }
        }

        return detallesActivosDTO;
    }

    @Override
    public DetalleHistoriaClinicaDTO obtenerPorId(Integer id) {
        
       Optional<DetalleHistoriaClinica> detalle = detalleHistoriaClinicaRepository.findById(id);
       if(!detalle.isPresent()) return null;
       
       DetalleHistoriaClinicaDTO detalleDTO = detalleMapper.detalleHistoriaClinicaToDetalleHistoriaClinicaDTO(detalle.get());
       HistoriaClinica historia = historiaClinicaRepository.findByHistoriaClinicaId(detalleDTO.getHistoriaClinicaId());
       
       detalleDTO.setHistoriaClinica(historia);
       Colaborador colaborador = colaboradorRepository.findByColaboradorId(detalleDTO.getColaboradorId());
       detalleDTO.setColaborador(colaborador);
       
       return detalleDTO;
    }

    @Override
    public DetalleHistoriaClinica registrar(DetalleHistoriaClinica detalleHistoriaClinica) {
        
        return detalleHistoriaClinicaRepository.save(detalleHistoriaClinica);
    }

    @Override
    public DetalleHistoriaClinica actualizar(Integer id, DetalleHistoriaClinica detalleHistoriaClinica) {
        
        Optional<DetalleHistoriaClinica> detalleOptional = detalleHistoriaClinicaRepository.findById(id);
        if(!detalleOptional.isPresent()) return null;
        detalleHistoriaClinica.setId(detalleOptional.get().getId());
        return detalleHistoriaClinicaRepository.save(detalleHistoriaClinica);
    }

    @Override
    public void eliminar(Integer id) {
        
        DetalleHistoriaClinica detalles = new DetalleHistoriaClinica();
        detalles.setId(id);
        detalleHistoriaClinicaRepository.delete(detalles);
    }
}