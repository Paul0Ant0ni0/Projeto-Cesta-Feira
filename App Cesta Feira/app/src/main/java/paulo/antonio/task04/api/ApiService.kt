package paulo.antonio.task04.api

import paulo.antonio.task04.model.Categoria
import paulo.antonio.task04.model.Produtos
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("produtos")
    suspend fun addProduto(
        @Body produtos: Produtos
    ): Response<Produtos>

    @GET("produtos")
    suspend fun listProdutos() : Response<List<Produtos>>

    @PUT("produtos")
    suspend fun updadeProduto(
        @Body produtos: Produtos
    ): Response<Produtos>

    @DELETE("produtos/{id}")
    suspend fun deleteProduto(
        @Path("id") id: Long
    ): Response<Produtos>


}