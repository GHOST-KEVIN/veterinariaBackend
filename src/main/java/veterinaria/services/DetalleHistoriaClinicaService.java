package veterinaria.services;

import java.util.List;
import veterinaria.dto.DetalleHistoriaClinicaDTO;
import veterinaria.models.DetalleHistoriaClinica;

public interface DetalleHistoriaClinicaService {
    
    List<DetalleHistoriaClinicaDTO> obtenerTodo();
    
    DetalleHistoriaClinicaDTO obtenerPorId(Integer id);
    
    DetalleHistoriaClinica registrar(DetalleHistoriaClinica detalleHistoriaClinica);
    
    DetalleHistoriaClinica actualizar(Integer id, DetalleHistoriaClinica detalleHistoriaClinica);
    
    void eliminar(Integer id);
    
}