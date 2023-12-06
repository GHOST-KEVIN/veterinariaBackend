package veterinaria.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import veterinaria.dto.ColaboradorDTO;
import veterinaria.models.Colaborador;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {
    
    public List<ColaboradorDTO> listColaboradorToListColaboradorDTO(List<Colaborador> colaborador);
    
    public ColaboradorDTO colaboradorToColaboradorDTO(Colaborador colaborador);
    
}