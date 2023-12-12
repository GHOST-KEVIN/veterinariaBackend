package veterinaria.services.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.exepciones.ResourceNotFoundException;
import veterinaria.models.Colaborador;
import veterinaria.repositorys.ColaboradorRepository;
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
        
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        for(Colaborador colab : colaboradores){
            int numeroDocumentoDB = colab.getDocumentoIdentificacion();
            if(colaborador.getDocumentoIdentificacion() == numeroDocumentoDB){
                throw new ResourceNotFoundException("Ya existe el numero de identificacion: "+ numeroDocumentoDB);
            }
        }
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public Colaborador actualizar(Integer id, Colaborador colaborador) {
        
        Optional<Colaborador> colaboradorOptional = colaboradorRepository.findById(id);
        if(!colaboradorOptional.isPresent()) return null;
        colaborador.setId(colaboradorOptional.get().getId());
        
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        for(Colaborador colab : colaboradores){
            
            if(colab.getId() != colaborador.getId()){
                
                int numeroDocumentoDB = colab.getDocumentoIdentificacion();
                if(colaborador.getDocumentoIdentificacion() == numeroDocumentoDB){
                    throw new ResourceNotFoundException("Ya existe el numero de identificacion: "+ numeroDocumentoDB);
                }
            }
        }
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public void eliminar(Integer id) {
        
        Colaborador colaborador = new Colaborador();
        colaborador.setId(id);
        colaboradorRepository.delete(colaborador);   
    }
}