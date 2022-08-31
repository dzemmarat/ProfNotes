package ru.mrz.profnotes.data.network.api

import retrofit2.http.Body
import retrofit2.http.POST
import ru.mrz.profnotes.data.model.AuthBody
import ru.mrz.profnotes.data.model.RegisterResponse

interface RegisterApi {
    @POST("register")
    fun postRegister(
        @Body authInfo: AuthBody
    ): RegisterResponse
}