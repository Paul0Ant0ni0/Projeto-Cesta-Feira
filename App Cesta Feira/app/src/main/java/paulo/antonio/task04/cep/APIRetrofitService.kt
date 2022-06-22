package paulo.antonio.task04.cep

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIRetrofitService {

    @GET("{CEP}/json/")
    fun getEnderecoByCEP(@Path("CEP") CEP : String) : Call<CEP>

    @GET("{estado}/{cidade}/{endereco}/json/")
    fun getCEPByCidadeEstadoEndereco(@Path("estado") estado: String,
                                     @Path("cidade") cidade: String,
                                     @Path("endereco") endereco: String): Call<List<CEP>>
}