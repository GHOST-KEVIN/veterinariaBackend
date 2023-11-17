package veterinaria.services;

import java.util.Set;
import veterinaria.modelo.DetalleHistoriaClinica;

public interface DetalleHistoriaClinicaService {
    Set<DetalleHistoriaClinica> todosLosDetalles();
    
    DetalleHistoriaClinica detalleById(Integer id);
    
    DetalleHistoriaClinica registrar(DetalleHistoriaClinica detalleHistoriaClinica);
    
    DetalleHistoriaClinica actualizar(Integer id, DetalleHistoriaClinica detalleHistoriaClinica);
    
    void eliminar(Integer id);
}
