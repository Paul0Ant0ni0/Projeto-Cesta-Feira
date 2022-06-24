package paulo.antonio.task04.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import paulo.antonio.task04.data.cesta.Cesta
import paulo.antonio.task04.databinding.CardCestaBinding
import paulo.antonio.task04.model.Produtos

class CestaAdapter: RecyclerView.Adapter<CestaAdapter.CestaViewHolder>(){
    private lateinit var adapter: ProdutosAdapter

    private  var adminlistProduto = emptyList<Cesta>()

    class CestaViewHolder (val binding: CardCestaBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CestaViewHolder {
        return CestaViewHolder(CardCestaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: CestaViewHolder, position: Int) {
        val produto = adminlistProduto[position]

        holder.binding.textNomeCesta.text = produto.nomeProduto
        holder.binding.imgCesta.setImageResource(produto.imagen.toInt())
        holder.binding.textQdtCesta.text = produto.quantidade
        holder.binding.textValorCesta.text = produto.valor
        holder.binding.textInfoCesta.text = "Compra a cada 100g"

    }

    override fun getItemCount(): Int {
        return adminlistProduto.size
    }

    fun setList(Cesta: List<Cesta>){
        adminlistProduto = Cesta
        //notifyDataSetChanged serve para mudar a lista quando atualizae
        notifyDataSetChanged()
    }
}