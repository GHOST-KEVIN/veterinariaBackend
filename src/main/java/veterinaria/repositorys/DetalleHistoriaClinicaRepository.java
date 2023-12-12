package veterinaria.repositorys;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import veterinaria.models.DetalleHistoriaClinica;

@Transactional
@Repository
public interface DetalleHistoriaClinicaRepository extends JpaRepository<DetalleHistoriaClinica, Integer>{
    
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM detalle_historia_clinica WHERE historia_clinica_id = ?1")
    public void deleteByHistoriaClinicaId(Integer id);
    
    @Query(nativeQuery = true, value = "SELECT * FROM detalle_historia_clinica WHERE historia_clinica_id = ?1")
    public List<DetalleHistoriaClinica> findBydetalleId(Integer id);
    
}
