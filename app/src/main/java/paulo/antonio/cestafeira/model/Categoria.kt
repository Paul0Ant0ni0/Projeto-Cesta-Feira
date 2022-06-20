package paulo.antonio.cestafeira.model

data class Categoria(
    var id: Long?,
    var descricao: String?,
    var produto: List<Produto>
) {
    override fun toString(): String {
        return descricao!!
    }

}
