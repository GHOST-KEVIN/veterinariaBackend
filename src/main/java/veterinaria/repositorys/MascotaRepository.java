package veterinaria.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import veterinaria.models.Mascota;

//@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{
//    @Query("DELETE FROM mascota AND historia_clinica where id=1?")
//    public void eliminarMascota();
}
