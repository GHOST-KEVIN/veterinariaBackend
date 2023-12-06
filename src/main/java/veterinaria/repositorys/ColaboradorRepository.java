package veterinaria.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import veterinaria.models.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{
    
    @Query(nativeQuery = true, value = "SELECT * FROM colaborador WHERE id = ?1")
    public Colaborador findByColaboradorId(Integer id);
    
}
