package veterinaria.controlador;

import java.util.Set;
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
import veterinaria.modelo.Usuario;
import veterinaria.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity<?> listarTodosLosUsuarios(){
        return ResponseEntity.ok(usuarioService.todosLosUsuarios());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.usuarioById(id));
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