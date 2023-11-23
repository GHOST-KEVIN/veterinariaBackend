package veterinaria.services;

import java.util.List;
import veterinaria.dto.HistoriaClinicaDTO;
import veterinaria.models.HistoriaClinica;
public interface HistoriaClinicaService {
    
    public List<HistoriaClinicaDTO> obtenerTodo();
    
    public HistoriaClinicaDTO obtenerPorId(Integer id);
    
    public HistoriaClinica registrar(HistoriaClinica historiaClinica);
    
    public HistoriaClinica actualizar(Integer id,HistoriaClinica historiaClinica);
    
    public void eliminar(Integer id);
    
}
