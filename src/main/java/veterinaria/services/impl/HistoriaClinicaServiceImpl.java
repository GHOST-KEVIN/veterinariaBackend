package veterinaria.services.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Mascota;
import veterinaria.repositorys.HistoriaClinicaRepository;
import veterinaria.services.HistoriaClinicaService;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService{
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;
    
    @Override
    public Set<HistoriaClinica> todasLasHistoriasClinicas() {
        return new LinkedHashSet<>(historiaClinicaRepository.findAll());
    }

    @Override
    public HistoriaClinica historiaClinicaById(Integer id) {
        Optional<HistoriaClinica> historiaClinicaOptional = historiaClinicaRepository.findById(id);
        
        if(!historiaClinicaOptional.isPresent()) return null;
        
        return historiaClinicaOptional.get();
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