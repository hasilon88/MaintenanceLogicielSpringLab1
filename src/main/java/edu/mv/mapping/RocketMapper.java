package edu.mv.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import edu.mv.db.models.Rocket;
import edu.mv.models.RocketDTO;

@Mapper
public interface RocketMapper {

    RocketMapper INSTANCE = Mappers.getMapper(RocketMapper.class);

    @Mapping(source = "type", target = "type")
    RocketDTO RocketToRocketDTO(Rocket Rocket);

    @Mapping(source = "type", target = "type")
    Rocket RocketDTOToRocket(RocketDTO RocketDTO);

}
