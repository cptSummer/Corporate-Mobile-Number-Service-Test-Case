package com.corporate_mobile_number_service.dao.users;

import com.corporate_mobile_number_service.dao.users.jpa.UserEntity;
import com.corporate_mobile_number_service.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.Managed;

@RequiredArgsConstructor
public class UserMapper implements Mapper<UserDto, UserEntity> {
    @Override
    public UserDto toDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getFirst_name(),
                userEntity.getLast_name(),
                userEntity.getPhone_number(),
                userEntity.getPassword(),
                userEntity.getPhone_balance());
    }

    @Override
    public UserEntity toEntity(UserDto userDto) {
        UserEntity entity = new UserEntity();
        entity.setId(userDto.getId());
        entity.setFirst_name(userDto.getFirst_name());
        entity.setLast_name(userDto.getLast_name());
        entity.setPhone_number(userDto.getPhone_number());
        entity.setPassword(userDto.getPassword());
        entity.setPhone_balance(userDto.getPhone_balance());
        return entity;
    }
}
