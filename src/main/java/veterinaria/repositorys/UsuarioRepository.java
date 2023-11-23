package veterinaria.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import veterinaria.models.Usuario;

@Transactional
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    @Query(nativeQuery = true, value = "SELECT * FROM usuario WHERE id = ?1")
    public Usuario findByUsuarioId(Integer id);
    
}
