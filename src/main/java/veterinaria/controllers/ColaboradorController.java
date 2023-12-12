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
import veterinaria.exepciones.ResourceNotFoundException;
import veterinaria.models.Colaborador;
import veterinaria.services.ColaboradorService;

@RestController
@RequestMapping("/api/colaborador")
@CrossOrigin(origins = "*")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService colaboradorService;
    
    @GetMapping
    public ResponseEntity<?> obtenerColaboradores(){
        return ResponseEntity.ok(colaboradorService.obtener());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> obtenerColaboradorPorId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(colaboradorService.obtenerPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<?> guardarColaborador(@RequestBody Colaborador colaborador){
        try{
            
        return ResponseEntity.ok(colaboradorService.guardar(colaborador));
        
        }catch(ResourceNotFoundException e){
            
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarColaborador(@PathVariable("id") Integer id, @RequestBody Colaborador colaborador){
        try{
            
            return ResponseEntity.ok(colaboradorService.actualizar(id, colaborador));
        
        }catch(ResourceNotFoundException e){
            
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarColaborador(@PathVariable("id") Integer id){
        colaboradorService.eliminar(id);
        
        return ResponseEntity.noContent().build();
    }
}