package paulo.antonio.cestafeira.api

import paulo.antonio.cestafeira.model.Categoria
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }
}