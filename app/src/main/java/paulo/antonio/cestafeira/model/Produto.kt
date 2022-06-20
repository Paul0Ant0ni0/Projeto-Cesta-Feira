package paulo.antonio.cestafeira.model

data class Produto(
    val id: Long,
    val nomeMarca: String,
    var descricao: String,
    var imagem: String,
    var quantidade: Int,
    var valor: Double,
    var categoria: Categoria)

