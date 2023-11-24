package veterinaria.repositorys;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import veterinaria.models.Mascota;

@Transactional
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{
    
    @Query(nativeQuery = true, value = "SELECT * FROM mascota WHERE id = ?1")
    public Mascota findByMascotaId(Integer id);
    
    @Query(nativeQuery = true, value = "SELECT * FROM mascota WHERE usuario_id = ?1")
    public List<Mascota> findByUsuarioId(Integer id);
    
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM mascota WHERE usuario_id = ?1")
    public void deleteByMascotaId(Integer id);
     
}
