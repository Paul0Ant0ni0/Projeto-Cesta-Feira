package paulo.antonio.task04.data.cesta

import androidx.room.Entity
import androidx.room.PrimaryKey

//Referenciado a tabela e o nome dela
@Entity(tableName = "cesta_table")
class Cesta (

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var imagen: String,
    var nomeProduto: String,
    var quantidade: String,
    var valor: String
        ) {

}