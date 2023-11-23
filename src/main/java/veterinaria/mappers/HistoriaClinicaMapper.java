package veterinaria.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import veterinaria.dto.HistoriaClinicaDTO;
import veterinaria.models.HistoriaClinica;

@Mapper(componentModel = "spring")
public interface HistoriaClinicaMapper {
    
    public List<HistoriaClinicaDTO> listHistoriaClinicaToListHistoriaClinicaDTO(List<HistoriaClinica> historiaClinica);
    
    public HistoriaClinicaDTO historiaClinicaToHistoriaClinicaDTO(HistoriaClinica historiaClinica);
    
}
