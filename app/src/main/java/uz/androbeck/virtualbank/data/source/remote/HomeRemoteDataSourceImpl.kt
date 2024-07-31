package uz.androbeck.virtualbank.data.source.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.androbeck.virtualbank.data.api.FullInfoService
import uz.androbeck.virtualbank.data.dto.request.FullInfoDto
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val fullInfoService: FullInfoService
) : HomeRemoteDataSource {
    override fun getFullInfo(token:String?): Flow<FullInfoDto> = flow {
            emit(fullInfoService.getFullInfo(token))
        }
}