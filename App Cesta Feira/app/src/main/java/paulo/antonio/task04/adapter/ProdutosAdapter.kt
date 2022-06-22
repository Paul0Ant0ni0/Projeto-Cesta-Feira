package paulo.antonio.task04.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import paulo.antonio.task04.databinding.CardProdutosBinding
import paulo.antonio.task04.model.Produtos
import paulo.antonio.task04.R

class ProdutosAdapter : RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>() {

    var listProduto = emptyList<Produtos>()

    class ProdutosViewHolder (val binding: CardProdutosBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        return ProdutosViewHolder(CardProdutosBinding.inflate
            (LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produto = listProduto[position]

        holder.binding.imageProduct.setImageResource(R.drawable.laranja)
        holder.binding.textNome.text = produto.nomeMarca
        holder.binding.textValor.text = "R$ ${listProduto[position].valor}"
    }

    override fun getItemCount(): Int {
        return listProduto.size
    }

    fun setList(list: List<Produtos>){
        listProduto = list
        notifyDataSetChanged()

    }

}