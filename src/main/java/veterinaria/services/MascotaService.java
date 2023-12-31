package veterinaria.services;

import java.util.List;
import veterinaria.dto.MascotaDTO;
import veterinaria.models.Mascota;

public interface MascotaService {
    List<MascotaDTO> obtenerTodo();
    
    MascotaDTO obtenerPorId(Integer id);
    
    Mascota registrar(Mascota mascota);
    
    Mascota actualizar(Integer id,Mascota mascota);
    
    void eliminar(Integer id);
}
