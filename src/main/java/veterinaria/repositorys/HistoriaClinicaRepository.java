package veterinaria.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import veterinaria.models.HistoriaClinica;

@Transactional
@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer>{
    
    @Query(nativeQuery = true, value = "SELECT * FROM historia_clinica WHERE id = ?1")
    public HistoriaClinica findByHistoriaClinicaId(Integer id);
    
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM historia_clinica WHERE mascota_id = ?1")
    public void deleteByHistoriaClinicaId(Integer id);
    
//    @Query("DELETE FROM historia_clinica WHERE mascota_id = ?1")
//    public void deleteByMascotaId(Integer id);
    
}
