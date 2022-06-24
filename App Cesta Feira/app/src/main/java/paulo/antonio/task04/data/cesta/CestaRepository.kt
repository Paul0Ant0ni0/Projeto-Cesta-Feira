package paulo.antonio.task04.data.cesta

class CestaRepository (private val cestaDao: CestaDao) {
    //Irá retornar uma lista de usuários do tipo LiveData
    val selectCesta = cestaDao.selectCesta()

    fun addCesta(cesta: Cesta){
        cestaDao.addProduto(cesta )
    }
}