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

}