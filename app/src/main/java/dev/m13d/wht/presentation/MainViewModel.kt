package dev.m13d.wht.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.business.domain.state.DataState
import dev.m13d.wht.business.interactor.GetHolydays
import kotlinx.coroutines.launch
import dev.m13d.wht.presentation.MainStateEvent.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel
@ViewModelInject
constructor(
    private val getHolydays: GetHolydays,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Holyday>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Holyday>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is GetHolydaysEvent -> {
                    getHolydays.execute()
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is None -> {
                    //
                }
            }
        }
    }
}

sealed class MainStateEvent{

    object GetHolydaysEvent: MainStateEvent()

    object None: MainStateEvent()
}
