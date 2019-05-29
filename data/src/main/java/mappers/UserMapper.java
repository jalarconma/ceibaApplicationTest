package mappers;

import com.example.business.models.UserS;

import net.services.dto.UserDTO;

import org.mapstruct.Mapper;

import java.util.List;

import db.user.UserEntity;

@Mapper
public interface UserMapper {

    UserEntity dto2Entity(UserDTO dto);
    List<UserEntity> dto2Entity(List<UserDTO> dtos);

    UserS entity2Model(UserEntity entity);
    List<UserS> entity2Model(List<UserEntity> entities);

    UserEntity model2Entity(UserS model);
    List<UserEntity> model2Entity(List<UserS> models);
}
