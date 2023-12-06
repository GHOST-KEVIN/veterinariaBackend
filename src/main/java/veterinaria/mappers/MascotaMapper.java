package veterinaria.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import veterinaria.dto.MascotaDTO;
import veterinaria.models.Mascota;

@Mapper(componentModel = "spring")
public interface MascotaMapper {
    
    List<MascotaDTO> listMascotaToListMascotaDTO(List<Mascota> mascota);
    
    MascotaDTO mascotaToMascotaDTO(Mascota mascota);
}