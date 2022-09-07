package ru.mrz.profnotes.data.repository.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import ru.mrz.profnotes.data.model.util.ResponseWrapper

open class BaseRepository {
    suspend inline fun <T> getResponseInResponseWrapper(response: Response<T>)
            : ResponseWrapper<T> {
        return try {
            withContext(Dispatchers.IO) {
                if (response.isSuccessful) {
                    ResponseWrapper.Success(
                        body = response.body()!!
                    )
                } else {
                    ResponseWrapper.Error(
                        code = response.code()
                    )
                }
            }
        }catch (e: Exception) {
            ResponseWrapper.Error(code = 0)
        }
    }
}