package veterinaria.services.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.modelo.DetalleHistoriaClinica;
import veterinaria.modelo.HistoriaClinica;
import veterinaria.repositorio.DetalleHistoriaClinicaRepository;
import veterinaria.repositorio.HistoriaClinicaRepository;
import veterinaria.services.DetalleHistoriaClinicaService;

@Service
public class DetalleHistoriaClinicaServiceImpl implements DetalleHistoriaClinicaService{
    @Autowired
    private DetalleHistoriaClinicaRepository detalleHistoriaClinicaRepository;
    
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;
    
    @Override
    public Set<DetalleHistoriaClinica> todosLosDetalles() {
        return new LinkedHashSet<>(detalleHistoriaClinicaRepository.findAll());
    }

    @Override
    public DetalleHistoriaClinica detalleById(Integer id) {
       Optional<DetalleHistoriaClinica> detalleOptional = detalleHistoriaClinicaRepository.findById(id);
       
       if(!detalleOptional.isPresent()) return null;
       
       return detalleOptional.get();
    }

    @Override
    public DetalleHistoriaClinica registrar(DetalleHistoriaClinica detalleHistoriaClinica) {
        System.out.println("detalleHistoriaClinica  " + detalleHistoriaClinica.toString());
        
        return detalleHistoriaClinicaRepository.save(detalleHistoriaClinica);
    }

    @Override
    public DetalleHistoriaClinica actualizar(Integer id, DetalleHistoriaClinica detalleHistoriaClinica) {
        Optional<HistoriaClinica> historiaClinicaOptional = historiaClinicaRepository.findById(detalleHistoriaClinica.getHistoriaClinica().getId());
        if(!historiaClinicaOptional.isPresent()) return null;
        
        Optional<DetalleHistoriaClinica> detalleOptional = detalleHistoriaClinicaRepository.findById(id);
        if(!detalleOptional.isPresent()) return null;
        
        detalleHistoriaClinica.setHistoriaClinica(historiaClinicaOptional.get());
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