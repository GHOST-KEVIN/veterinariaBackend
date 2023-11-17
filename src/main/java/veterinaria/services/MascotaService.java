package veterinaria.services;

import java.util.List;
import java.util.Set;
import veterinaria.modelo.Mascota;

public interface MascotaService {
    List<Mascota> todasLasMascotas();
    
    Mascota mascotaById(Integer id);
    
    Mascota registrar(Mascota mascota);
    
    Mascota actualizar(Integer id,Mascota mascota);
    
    void eliminar(Integer id);
}
