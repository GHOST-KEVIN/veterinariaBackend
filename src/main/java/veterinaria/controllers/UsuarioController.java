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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import veterinaria.dto.UsuarioDTO;
import veterinaria.exepciones.ResourceNotFoundException;
import veterinaria.models.Usuario;
import veterinaria.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity<?> listarTodosLosUsuarios(){
        
        return ResponseEntity.ok(usuarioService.obtenerTodo());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Integer id){
        
        UsuarioDTO usuarioDTO = usuarioService.obtenerPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }
    
    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario){
        try{
            
            return ResponseEntity.ok(usuarioService.registrar(usuario));
            
        }catch(ResourceNotFoundException e){
            
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarBiblioteca(@PathVariable Integer id, @RequestBody Usuario usuario){
        try{
            
        return ResponseEntity.ok(usuarioService.actualizar(id, usuario));
        }catch(ResourceNotFoundException e){
            
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarBiblioteca(@PathVariable Integer id){
        
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}