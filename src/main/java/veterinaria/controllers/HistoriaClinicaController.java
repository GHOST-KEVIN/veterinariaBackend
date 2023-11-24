package veterinaria.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import veterinaria.dto.HistoriaClinicaDTO;
import veterinaria.exepciones.ResourceNotFoundException;
import veterinaria.models.HistoriaClinica;
import veterinaria.services.HistoriaClinicaService;

@RestController
@RequestMapping("/api/historia_clinica")
@CrossOrigin(origins = "*")
public class HistoriaClinicaController {
    @Autowired
    private HistoriaClinicaService historiaClinicaService;
    
    @GetMapping
    public ResponseEntity<?> listarTodasLasHistoriasClinicas(){
        
        return ResponseEntity.ok(historiaClinicaService.obtenerTodo());
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinicaDTO> obtenerHistoriaClinicaPorId(@PathVariable Integer id){
        
        HistoriaClinicaDTO historiaDTO = historiaClinicaService.obtenerPorId(id);
        return ResponseEntity.ok(historiaDTO);
        
    }
    
    @PostMapping
    public ResponseEntity<?> guardarHistoriaClinica(@RequestBody HistoriaClinica historiaClinica){
        
        try {
            
            HistoriaClinica nuevaHistoriaClinica = historiaClinicaService.registrar(historiaClinica);
            return ResponseEntity.ok(nuevaHistoriaClinica);
            
        } catch (ResourceNotFoundException e) {
            
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarHistoriaClinica(@PathVariable Integer id, @RequestBody HistoriaClinica historiaClinica){
        
        try {
            
            HistoriaClinica editarHistoriaClinica = historiaClinicaService.actualizar(id, historiaClinica);
            return ResponseEntity.ok(editarHistoriaClinica);
            
        } catch (ResourceNotFoundException e) {
            
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        }
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarHistoriaClinica(@PathVariable Integer id){
        
        historiaClinicaService.eliminar(id);
        return ResponseEntity.noContent().build();
        
    }
    
}