package veterinaria.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import veterinaria.dto.DetalleHistoriaClinicaDTO;
import veterinaria.models.DetalleHistoriaClinica;

@Mapper(componentModel = "spring")
public interface DetalleHistoriaClinicaMapper {
    
    public List<DetalleHistoriaClinicaDTO> listDetalleHistoriaClinicaToListDetalleHistoriaClinicaDTO(List<DetalleHistoriaClinica> detalleHistoriaClinica);
    
    public DetalleHistoriaClinicaDTO detalleHistoriaClinicaToDetalleHistoriaClinicaDTO(DetalleHistoriaClinica detalle);
    
}
