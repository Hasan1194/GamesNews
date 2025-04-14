package com.h1194.core.data

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : com.h1194.core.data.Resource<T>(data)
    class Loading<T>(data: T? = null) : com.h1194.core.data.Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : com.h1194.core.data.Resource<T>(data, message)
}
