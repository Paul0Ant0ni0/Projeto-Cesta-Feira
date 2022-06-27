package paulo.antonio.task04.data.cesta

import android.app.Application
import android.util.Log
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

    fun addProduto(produtos: Produtos) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.addCesta(produtos)
            } catch (e: Exception) {
                Log.d("Error Insert Room", e.message.toString())
            }
        }

    }


    fun deleteProduto(produtos: Produtos) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.delete(produtos)

            } catch (e: Exception) {
                Log.d("Error Delete Room", e.message.toString())
            }
        }
    }


}


