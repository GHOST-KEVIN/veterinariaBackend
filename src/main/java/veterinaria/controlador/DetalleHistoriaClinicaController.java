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
import veterinaria.modelo.DetalleHistoriaClinica;
import veterinaria.services.DetalleHistoriaClinicaService;

@RestController
@RequestMapping("/api/detalle_historia_clinica")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleHistoriaClinicaController {
    @Autowired
    private DetalleHistoriaClinicaService detalleService;
    
    @GetMapping
    public ResponseEntity<?> listartodosLosDetalles(){
        return ResponseEntity.ok(detalleService.todosLosDetalles());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DetalleHistoriaClinica> obtenerDetallePorId(@PathVariable Integer id){
        return ResponseEntity.ok(detalleService.detalleById(id));
    }
    
    @PostMapping()
    public ResponseEntity<DetalleHistoriaClinica> guardarDetalle(@RequestBody DetalleHistoriaClinica detalle){
        return ResponseEntity.ok(detalleService.registrar(detalle));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DetalleHistoriaClinica> actualizar(@PathVariable Integer id, @RequestBody DetalleHistoriaClinica detalle){
        return ResponseEntity.ok(detalleService.actualizar(id, detalle));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDetalles(@PathVariable Integer id){
        detalleService.eliminar(id);
        
        return ResponseEntity.noContent().build();
    }
}