package veterinaria.repositorio;

// Para usar la interfaz JpaRepository de Spring Data JPA.
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// Para marcar la interfaz como un repositorio de Spring.
import veterinaria.modelo.Usuario;
// La clase modelo que representa a un empleado.

// Anotación para indicar que esta interfaz es un repositorio de Spring. Esto permite que Spring cree automáticamente una implementación de esta interfaz.
//@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
