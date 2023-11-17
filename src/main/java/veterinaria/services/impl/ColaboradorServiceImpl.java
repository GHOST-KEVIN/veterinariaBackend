package veterinaria.services.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.modelo.Colaborador;
import veterinaria.repositorio.ColaboradorRepository;
import veterinaria.services.ColaboradorService;

@Service
public class ColaboradorServiceImpl implements ColaboradorService{
    @Autowired
    private ColaboradorRepository colaboradorRepository;
            
    @Override
    public Set<Colaborador> obtener() {
        return new LinkedHashSet<>(colaboradorRepository.findAll());
    }

    @Override
    public Colaborador obtenerPorId(Integer id) {
        Optional<Colaborador> colaboradorOptional = colaboradorRepository.findById(id);
        
        if(!colaboradorOptional.isPresent()) return null;
        
        return colaboradorOptional.get();
    }

    @Override
    public Colaborador guardar(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public Colaborador actualizar(Integer id, Colaborador colaborador) {
        Optional<Colaborador> colaboradorOptional = colaboradorRepository.findById(id);
        
        if(!colaboradorOptional.isPresent()) return null;
        
        colaborador.setId(colaboradorOptional.get().getId());
        
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public void eliminar(Integer id) {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(id);
        colaboradorRepository.delete(colaborador); 
        
        
//        Optional<Colaborador> colaboradorOptional = colaboradorRepository.findById(id);
//        colaboradorRepository.delete(colaboradorOptional.get());   
        
    }
    
}
