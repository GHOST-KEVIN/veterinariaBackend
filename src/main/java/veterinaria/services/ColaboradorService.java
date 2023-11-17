package veterinaria.services;

import java.util.Set;
import veterinaria.modelo.Colaborador;

public interface ColaboradorService {
    Set<Colaborador> obtener();
    
    Colaborador obtenerPorId(Integer id);
    
    Colaborador guardar(Colaborador colaborador);
    
    Colaborador actualizar(Integer id, Colaborador colaborador);
    
    void eliminar(Integer id);
}
