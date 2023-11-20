package veterinaria.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import veterinaria.models.HistoriaClinica;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer>{
    
//    @Query("DELETE FROM historia_clinica WHERE mascota_id = ?1")
//    public void deleteByMascotaId(Integer id);
    
}
