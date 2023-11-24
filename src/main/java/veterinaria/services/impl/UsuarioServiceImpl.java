package veterinaria.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.dto.UsuarioDTO;
import veterinaria.mappers.UsuarioMapper;
import veterinaria.models.HistoriaClinica;
import veterinaria.models.Mascota;
import veterinaria.models.Usuario;
import veterinaria.repositorys.HistoriaClinicaRepository;
import veterinaria.repositorys.MascotaRepository;
import veterinaria.repositorys.UsuarioRepository;
import veterinaria.services.HistoriaClinicaService;
import veterinaria.services.MascotaService;
import veterinaria.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private HistoriaClinicaRepository historiaRepository;
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Autowired
    private MascotaService mascotaService;
    
    @Autowired
    private HistoriaClinicaService historiaService;
    
    @Override
    public List<UsuarioDTO> obtenerTodo() {
        
        return usuarioMapper.listUsuarioToListUsuarioDTO(usuarioRepository.findAll());
        
    }

    @Override
    public UsuarioDTO obtenerPorId(Integer id) {
        
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(!usuario.isPresent()) return null;
        return usuarioMapper.usuarioToUsuarioDTO(usuario.get());
        
    }
    
    @Override
    public Usuario registrar(Usuario usuario) {
        
        return usuarioRepository.save(usuario);
        
    }
    
    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        
        if(!usuarioOptional.isPresent()) return null;
        
        usuario.setId(usuarioOptional.get().getId());
        return usuarioRepository.save(usuario);
        
    }

    @Override
    public void eliminar(Integer id) {
        long tiempoInicio = System.nanoTime();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(!usuarioOptional.isPresent()) return;
        
        List<Mascota> mascotas = mascotaRepository.findAll();
        for(Mascota mascota : mascotas){
            
           List<HistoriaClinica> historiasClinicas = historiaRepository.findAll();
           for(HistoriaClinica historia : historiasClinicas){
               
               historiaService.eliminar(historia.getId());
            }
           
           mascotaService.eliminar(mascota.getId());
        }
        
        usuarioRepository.delete(usuarioOptional.get());
        
        long tiempoFinal = System.nanoTime();
        long duracion = tiempoFinal - tiempoInicio; // Esto te dará el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + duracion + " en nanoSegundos");
    
    }
    
//    @Override
//    public void eliminar(Integer id) {
//        long tiempoInicio = System.nanoTime();
//        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
//        if (!usuarioOptional.isPresent()) {
//            return;
//        }
//
//        Usuario usuario = usuarioOptional.get();
//        List<Mascota> mascotas = mascotaRepository.findByUsuarioId(usuario.getId());
//        for (Mascota mascota : mascotas) {
//
//            List<HistoriaClinica> historiasClinicas = historiaRepository.findByMascotaId(mascota.getId());
//            for (HistoriaClinica historia : historiasClinicas) {
//                historiaService.eliminar(historia.getId());
//            }
//
//            mascotaService.eliminar(mascota.getId());
//        }
//
//        usuarioRepository.delete(usuario);
//
//        long tiempoFinal = System.nanoTime();
//        long duracion = tiempoFinal - tiempoInicio; // Esto te dará el tiempo en nanosegundos
//        System.out.println("Tiempo de ejecución: " + duracion + " nanoSegundos ");
//    }
    
//    @Override
//    public void eliminar(Integer id) {
//        long tiempoInicio = System.nanoTime();
//        usuarioRepository.findById(id).ifPresent(usuario -> {
//            mascotaRepository.findByUsuarioId(usuario.getId()).stream().forEach(mascota -> {
//                historiaRepository.findByMascotaId(mascota.getId()).stream().forEach(historia -> {
//                    historiaService.eliminar(historia.getId());
//                });
//                mascotaService.eliminar(mascota.getId());
//            });
//            usuarioRepository.delete(usuario);
//        });
//
//        long tiempoFinal = System.nanoTime();
//        long duracion = tiempoFinal - tiempoInicio; // Esto te dará el tiempo en nanosegundos
//        System.out.println("Tiempo de ejecución: " + duracion + " nanoSegundos ");
//    }

}
