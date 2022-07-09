package com.example.tarot.data.remote

import com.example.tarot.data.remote.dto.TarotDTO
import retrofit2.Response
import retrofit2.http.GET

interface TarotAPI {

        @GET("/anything/tarot/")
        suspend fun getTarot() : Response<TarotDTO>

}