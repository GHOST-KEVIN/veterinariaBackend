package veterinaria.services.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.dto.MascotaDTO;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Mascota;
import veterinaria.models.Usuario;
import veterinaria.repositorys.HistoriaClinicaRepository;
import veterinaria.repositorys.MascotaRepository;
import veterinaria.repositorys.UsuarioRepository;
import veterinaria.services.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService{
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public List<Mascota> obtener() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota obtenerPorId(Integer id) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        
        if(!mascotaOptional.isPresent()) return null;
        return mascotaOptional.get();
        
//        MascotaDTO mascota = new MascotaDTO();
//        mascota.setId(mascotaOptional.get().getId());
//        mascota.setNombre(mascotaOptional.get().getNombre());
//        mascota.setRaza(mascotaOptional.get().getRaza());
//        mascota.setSexo(mascotaOptional.get().getSexo());
        
        
        
//        return mascota;
    }

    @Override
    public Mascota registrar(Mascota mascota) {
//        Optional<Usuario> usuarioOptional = usuarioRepository.findById(mascota.getUsuario().getId());
//        
//        if(!usuarioOptional.isPresent()) return null;
//        
//        mascota.setUsuario(usuarioOptional.get());
        
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota actualizar(Integer id, Mascota mascota) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(mascota.getUsuario().getId());
        if(!usuarioOptional.isPresent()) return null;
        
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        if(!mascotaOptional.isPresent()) return null;
        
        mascota.setUsuario(usuarioOptional.get());
        mascota.setId(mascotaOptional.get().getId());
        return mascotaRepository.save(mascota);
    }
    
    @Override
    public void eliminar(Integer id) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        mascotaRepository.delete(mascotaOptional.get());
        
//        Optional<HistoriaClinica> findById = historiaClinicaRepository.findById(mascotaOptional.get().getHistoriaClinica().getId());
//        historiaClinicaRepository.deleteById(mascotaOptional.get().getHistoriaClinica().getId());
//        findById
        
//        Mascota mascota = new Mascota();
//        mascota.setId(id);
//        mascotaRepository.delete(mascota);
    }
}
