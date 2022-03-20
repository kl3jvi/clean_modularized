package com.kl3jvi.feature_home.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl3jvi.domain.model.TmdbApiResponseDomain
import com.kl3jvi.domain.usecase.GetMoviesList
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

sealed class State<T> {
    class Loading<T> : State<T>()
    data class Success<T>(val data: T) : State<T>()
    data class Error<T>(val message: String) : State<T>()

    fun isLoading(): Boolean = this is Loading
    fun isSuccessful(): Boolean = this is Success
    fun isFailed(): Boolean = this is Error
}


class HomeViewModel(
    private val getMoviesList: GetMoviesList,
    private val list: String
) : ViewModel() {
    private val errorHandler = CoroutineExceptionHandler { context, exception ->
        Log.e("Context: $context", exception.message.orEmpty())
    }

    private var _moviesListStateFlow: MutableStateFlow<State<TmdbApiResponseDomain>> =
        MutableStateFlow(State.Loading())
    val moviesListStateFlow: StateFlow<State<TmdbApiResponseDomain>>
        get() = _moviesListStateFlow

    init {
        getMovies()
    }


    private fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            getMoviesList.execute(
                list = list,
                page = 1
            ).catch {
                _moviesListStateFlow.value = State.Error(message = it.message.orEmpty())
            }.onEach {
                _moviesListStateFlow.value = State.Success(data = it)
            }.stateIn(viewModelScope)
        }
    }
}


