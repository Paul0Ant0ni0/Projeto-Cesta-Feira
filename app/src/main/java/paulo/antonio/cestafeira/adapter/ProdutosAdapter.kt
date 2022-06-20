package paulo.antonio.cestafeira.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import paulo.antonio.cestafeira.databinding.CardProdutosBinding
import paulo.antonio.cestafeira.R
import paulo.antonio.cestafeira.model.Produto

class ProdutosAdapter : RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>() {

    var listProduto = emptyList<Produto>()

    class ProdutosViewHolder (val binding: CardProdutosBinding) :
        RecyclerView.ViewHolder(binding.root){


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        return ProdutosViewHolder(CardProdutosBinding.inflate
            (LayoutInflater.from(parent.context), parent, false))

    }



    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produto = listProduto[position]

        holder.binding.imageProdcut.setImageResource(R.drawable.brocolis)
        holder.binding.textNome.text = produto.nomeMarca
        holder.binding.textValor.text = produto.valor.toString()


    }

    override fun getItemCount(): Int {
        return listProduto.size
    }

    fun setList(list: List<Produto>){
        listProduto = list
        notifyDataSetChanged()

    }




}