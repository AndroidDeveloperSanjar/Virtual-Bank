package uz.androbeck.virtualbank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.androbeck.virtualbank.data.repository.authenticationRepository.AuthenticationRepository
import uz.androbeck.virtualbank.data.repository.mainRepository.FullInfoRepository
import uz.androbeck.virtualbank.domain.mapper.auth.SignUpMapper
import uz.androbeck.virtualbank.domain.mapper.auth.TokenMapper
import uz.androbeck.virtualbank.domain.mapper.main.FullInfoMapper
import uz.androbeck.virtualbank.domain.useCases.authentication.SignUpUseCase
import uz.androbeck.virtualbank.domain.useCases.main.GetFullInfoUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideSignUpUseCase(
        authenticationRepository: AuthenticationRepository,
        tokenMapper: TokenMapper,
        signUpMapper: SignUpMapper
    ) = SignUpUseCase(authenticationRepository, tokenMapper, signUpMapper)

    @Provides
    fun provideMainUseCase(
        fullInfoRepository: FullInfoRepository,
        fullInfoMapper: FullInfoMapper
    ): GetFullInfoUseCase = GetFullInfoUseCase(fullInfoRepository,fullInfoMapper)
}