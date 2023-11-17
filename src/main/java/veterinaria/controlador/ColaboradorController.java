package veterinaria.controlador;

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
import veterinaria.modelo.Colaborador;
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
    public ResponseEntity<Colaborador> guardarColaborador(@RequestBody Colaborador colaborador){
        return ResponseEntity.ok(colaboradorService.guardar(colaborador));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> actualizarColaborador(@PathVariable("id") Integer id, @RequestBody Colaborador colaborador){
        return ResponseEntity.ok(colaboradorService.actualizar(id, colaborador));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarColaborador(@PathVariable("id") Integer id){
        colaboradorService.eliminar(id);
        
        return ResponseEntity.noContent().build();
    }
}
