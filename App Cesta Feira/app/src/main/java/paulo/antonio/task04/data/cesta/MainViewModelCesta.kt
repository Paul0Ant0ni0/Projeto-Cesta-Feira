package paulo.antonio.task04.data.cesta

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModelCesta (application: Application) : AndroidViewModel(application) {

    val selectCestas: LiveData<List<Produtos>>
    val repository: CestaRepository

    init {
        val cestaDao = CestaDataBase.getDataBase(application).cestaDao()
        repository = CestaRepository(cestaDao)
        selectCestas = repository.selectCesta
    }

    fun addProduto(produtos: Produtos){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCesta(produtos)
        }
    }


}