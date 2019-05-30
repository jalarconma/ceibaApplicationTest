package co.com.ceiba.mobile.pruebadeingreso.di.module;

import org.mapstruct.factory.Mappers;

import dagger.Module;
import dagger.Provides;
import mappers.UserMapper;

@Module
public class MapperModule {

    public MapperModule() {
    }

    @Provides
    UserMapper provideUserMapper() {
        return Mappers.getMapper(UserMapper.class);
    }
}
