package veterinaria.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import veterinaria.dto.MascotaDTO;
import veterinaria.mappers.MascotaMapper;
import veterinaria.models.Mascota;
import veterinaria.services.MascotaService;

@RestController
@RequestMapping("/api/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    
    @Autowired
    private MascotaService mascotaService;
    
    @Autowired
    private MascotaMapper mascotaMapper;
    
    @GetMapping
    public ResponseEntity<?> obtenerMascotas(){
        return ResponseEntity.ok(mascotaService.obtener());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> obtenerMascotaPorId(@PathVariable Integer id){
//        return ResponseEntity.ok(mascotaService.obtenerPorId(id));
//        return ResponseEntity.ok(mascotaMapper.mascotaToMascotaDTO(mascotaService.obtenerPorId(id)));

        MascotaDTO mascotaDTO = mascotaMapper.mascotaToMascotaDTO(mascotaService.obtenerPorId(id));
        return ResponseEntity.ok(mascotaDTO);
    
       
    }
    
    @PostMapping()
    public ResponseEntity<Mascota> guardarMascota(@RequestBody Mascota mascota){
        return ResponseEntity.ok(mascotaService.registrar(mascota));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable Integer id, @RequestBody Mascota mascota){
        Mascota mascotaActualizado = mascotaService.actualizar(id, mascota);
        return ResponseEntity.ok(mascotaActualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMascota(@PathVariable Integer id){
        
        mascotaService.eliminar(id);
        
        return ResponseEntity.noContent().build();
    }
}