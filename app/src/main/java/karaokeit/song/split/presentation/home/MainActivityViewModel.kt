package karaokeit.song.split.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import karaokeit.song.split.data.FactsDataModel
import karaokeit.song.split.domain.FactsUseCase
import karaokeit.song.split.presentation.State
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor( var someValue: String, private val factsUseCase: FactsUseCase): ViewModel() {

    val facts = MutableLiveData<State<FactsDataModel>>()

    fun getFacts() {
        viewModelScope.launch {
            factsUseCase.getFacts().collectLatest {
                facts.value = it
            }
        }
    }

}