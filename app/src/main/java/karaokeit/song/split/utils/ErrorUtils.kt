package karaokeit.song.split.utils

import karaokeit.song.split.presentation.AuthenticationException
import karaokeit.song.split.presentation.NetworkErrorException
import karaokeit.song.split.presentation.State
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorUtils {
    companion object{
        const val DEFAULT_NETWORK_ERROR = "Network Error"
        fun resolveError(e: Exception): State.Error {
            var error = e

            when (e) {
                is SocketTimeoutException -> {
                    error = NetworkErrorException(errorMessage = "connection error!")
                }
                is ConnectException -> {
                    error = NetworkErrorException(errorMessage = "no internet access!")
                }
                is UnknownHostException -> {
                    error = NetworkErrorException(errorMessage = "no internet access!")
                }
            }

            if(e is HttpException){
                when(e.code()){
                    502 -> {
                        error = NetworkErrorException(e.code(),  "internal error!")
                    }
                    401 -> {
                        throw AuthenticationException("authentication error!")
                    }
                    400 -> {
                        error = NetworkErrorException.parseException(e)
                    }
                }
            }


            return State.Error(error)
        }
    }

}