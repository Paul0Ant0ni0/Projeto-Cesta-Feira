package paulo.antonio.task04.data.cesta

class CestaRepository (private val cestaDao: CestaDao) {
    //Irá retornar uma lista de produtos do tipo LiveData
    val selectCesta = cestaDao.selectCesta()

    fun addCesta(produtos: Produtos){
        cestaDao.addProduto(produtos)
    }
}