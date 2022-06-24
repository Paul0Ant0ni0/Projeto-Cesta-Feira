package paulo.antonio.task04.data.cesta

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi


@Database(entities = [Cesta::class], version = 1, exportSchema = false)
abstract class CestaDataBase : RoomDatabase() {

    abstract fun cestaDao(): CestaDao

    companion object{
        @Volatile
        private var INSTANCE: CestaDataBase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDataBase(context: Context): CestaDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }//Metodo que será realizado dentro de uma corrotina de forma assincrona
            kotlinx.coroutines.internal.synchronized(this) {
                //Instanciando o banco de dados pela primeira vez, caso a condição seja false
                val instance = Room.databaseBuilder(
                    //Contexto de onde vai ser criado o bd
                    context.applicationContext,
                    //Com base na classe UserDataBase convertendo
                    //em uma class java e inserindo um nome
                    CestaDataBase::class.java,
                    "cesta_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}