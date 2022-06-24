package paulo.antonio.task04.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import paulo.antonio.task04.MainViewModel
import paulo.antonio.task04.databinding.CardProdutosBinding
import paulo.antonio.task04.model.Produtos
import paulo.antonio.task04.R


class ProdutosAdapter(
    private val taskClickListener: TeskClickListener,
    val mainViewModel: MainViewModel
) : RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>() {

    var listProduto = emptyList<Produtos>()

    class ProdutosViewHolder (val bindingFour: CardProdutosBinding)
        : RecyclerView.ViewHolder(bindingFour.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        return ProdutosViewHolder(
            CardProdutosBinding.inflate
            (LayoutInflater.from(parent.context), parent, false
        ))

    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produto = listProduto[position]

        Picasso.get().load(R.drawable.input_img)
        holder.bindingFour.textNomeProduto.text = produto.nomeMarca
        holder.bindingFour.textValor.text = "R$ ${listProduto[position].valor}"

        holder.bindingFour.buttonComprar.setOnClickListener {
            taskClickListener.onTaskClickListener(produto)

        }

    }

    override fun getItemCount(): Int {
        return listProduto.size
    }

    fun setList(list: List<Produtos>){
        listProduto = list.sortedByDescending{ it.id }
        notifyDataSetChanged()


    }


}