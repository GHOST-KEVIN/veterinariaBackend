package veterinaria.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import veterinaria.dto.MascotaDTO;
import veterinaria.models.Mascota;

@Mapper
public interface MascotaMapper {
//    MascotaMapper INSTANCIA= Mappers.getMapper(MascotaMapper.class);
    MascotaDTO mascotaToMascotaDTO(Mascota mascota);
    Mascota mascotaDTOTomascota(MascotaDTO mascotaDTO);
}
