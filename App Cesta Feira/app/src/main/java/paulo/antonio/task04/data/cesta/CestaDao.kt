package paulo.antonio.task04.data.cesta

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query



@Dao
interface CestaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addProduto(cesta: Cesta)

    //listando os usuário da tabela
    @Query("SELECT * FROM cesta_table ORDER BY id ASC")
    fun selectCesta(): LiveData<List<Cesta>>
}