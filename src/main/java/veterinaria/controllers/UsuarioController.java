package veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        
        return ResponseEntity.ok(usuarioService.registrar(usuario));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarBiblioteca(@PathVariable Integer id, @RequestBody Usuario usuario){
        
        return ResponseEntity.ok(usuarioService.actualizar(id, usuario));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarBiblioteca(@PathVariable Integer id){
        
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}