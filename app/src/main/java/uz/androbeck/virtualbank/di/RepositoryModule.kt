package uz.androbeck.virtualbank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.androbeck.virtualbank.data.repository.authenticationRepository.AuthenticationRepository
import uz.androbeck.virtualbank.data.repository.authenticationRepository.AuthenticationRepositoryImpl
import uz.androbeck.virtualbank.data.repository.mainRepository.HomeRepository
import uz.androbeck.virtualbank.data.repository.mainRepository.HomeRepositoryImpl
import uz.androbeck.virtualbank.data.source.remote.AuthenticationRemoteDataSource
import uz.androbeck.virtualbank.data.source.remote.HomeRemoteDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthenticationRepository(
        authenticationRemoteDataSource: AuthenticationRemoteDataSource
    ): AuthenticationRepository {
        return AuthenticationRepositoryImpl(authenticationRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideMainRepository(
        homeRemoteDataSource: HomeRemoteDataSource
    ):HomeRepository{
        return HomeRepositoryImpl(homeRemoteDataSource)
    }

}