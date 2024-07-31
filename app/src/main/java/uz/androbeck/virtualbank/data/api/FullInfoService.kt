package uz.androbeck.virtualbank.data.api

import retrofit2.http.GET
import uz.androbeck.virtualbank.data.dto.request.FullInfoDto
import uz.androbeck.virtualbank.utils.Constants

interface FullInfoService {

    @GET(Constants.Endpoint.FULL_INFO)
    // Header() impl
    suspend fun getFullInfo( authToken: String?): FullInfoDto
}