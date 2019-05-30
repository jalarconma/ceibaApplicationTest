package co.com.ceiba.mobile.pruebadeingreso.di.module;

import com.example.business.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import di.Cloud;
import di.Local;
import repository.UserRepositoryImpl;
import repository.datasource.UserCloudDataStore;
import repository.datasource.UserDataStore;
import repository.datasource.UserLocalDataStore;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserRepositoryImpl repository) {
        return repository;
    }

    @Provides
    @Singleton
    @Local
    UserDataStore provideUserLocalDataStore(UserLocalDataStore local) {
        return local;
    }

    @Provides
    @Singleton
    @Cloud
    UserDataStore provideUserCloudDataStore(UserCloudDataStore cloud) {
        return cloud;
    }
}
