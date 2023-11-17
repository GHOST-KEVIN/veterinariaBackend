package veterinaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import veterinaria.modelo.HistoriaClinica;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer>{
    
//    @Query("DELETE FROM historia_clinica WHERE mascota_id = ?1")
//    public void deleteByMascotaId(Integer id);
    
}
