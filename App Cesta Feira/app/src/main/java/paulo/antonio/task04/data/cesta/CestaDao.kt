package paulo.antonio.task04.data.cesta

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface CestaDao {

    //Inserindo produtos na cesta
    //Metodo replace substitui a infromação alocada no banco de dados
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduto(produto: Produtos)

    //listando os produto da tabela cesta
    @Query("SELECT * FROM cesta_table ORDER BY id ASC")
    fun selectCesta(): LiveData<List<Produtos>>

    //Listando o total de produtos na cesta
    @Query("SELECT COUNT(id) FROM cesta_table")
    fun getTotalProdutos(): Long

    //Listando o total de valores de itens na cesta
    @Query("SELECT SUM(valor) FROM cesta_table")
    fun getTotalValor(): Int

    //Deletando produtos da cesta
    @Delete
    fun deleteProduto(produto: Produtos)

}