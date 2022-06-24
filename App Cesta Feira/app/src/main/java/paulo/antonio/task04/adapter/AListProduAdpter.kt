package paulo.antonio.task04.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import paulo.antonio.task04.MainViewModel
import paulo.antonio.task04.R
import paulo.antonio.task04.databinding.CardListprodutoadminBinding
import paulo.antonio.task04.model.Produtos

class AListProduAdpter(
    private val taskClickListener: TeskClickListener, mainViewModel: MainViewModel
) : RecyclerView.Adapter<AListProduAdpter.ProdutViewHolder>() {
    var listProduto = emptyList<Produtos>()


    class ProdutViewHolder (val binding: CardListprodutoadminBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): ProdutViewHolder {
        return ProdutViewHolder(CardListprodutoadminBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: ProdutViewHolder, position: Int) {
        val produto = listProduto[position]

        holder.binding.textId.text = produto.id.toString()
        Picasso.get().load(R.drawable.input_img)
        holder.binding.textCategoria.text = produto.categoria.toString()
        holder.binding.textNomeProduto.text = produto.nomeMarca
        holder.binding.textValoradmin.text = produto.valor

        holder.binding.addPost.setOnClickListener {
            taskClickListener.onTaskClickListener(produto)
        }
    }


    override fun getItemCount(): Int {
        return listProduto.size
    }

    fun setListe(list: List<Produtos>){
        listProduto = list
        notifyDataSetChanged()

    }



}