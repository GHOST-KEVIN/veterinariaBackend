package veterinaria.services;

import java.util.Set;
import veterinaria.modelo.HistoriaClinica;
import veterinaria.modelo.Mascota;
public interface HistoriaClinicaService {
    public Set<HistoriaClinica> todasLasHistoriasClinicas();
    
    public HistoriaClinica historiaClinicaById(Integer id);
    
    public HistoriaClinica registrar(HistoriaClinica historiaClinica);
    
    public HistoriaClinica actualizar(Integer id,HistoriaClinica historiaClinica);
    
    public void eliminar(Integer id);
}
