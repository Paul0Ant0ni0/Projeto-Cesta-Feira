package paulo.antonio.task04.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import paulo.antonio.task04.MainViewModel
import paulo.antonio.task04.R
import paulo.antonio.task04.databinding.CardListprodutoadminBinding
import paulo.antonio.task04.model.Produtos

class AListProduAdpter(
    val taskClickListener: TeskClickListener,
    val mainViewModel: MainViewModel, var context: Context
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
        holder.binding.textCategoria.text = produto.categoria.toString()
        holder.binding.textValoradmin.text = "R$ ${produto.valor}"

        Glide.with(context)
            .load(listProduto[position].imagem)
            .placeholder(R.drawable.input_img)
            .into(holder.binding.imgProd)


        holder.binding.atuaPost.setOnClickListener {
           // mainViewModel.produtoSelecionado = null
            taskClickListener.onTaskClickListener(produto)
        }

        holder.binding.deletPost.setOnClickListener{
            showAlertDialog(produto.id)
        }

    }


    override fun getItemCount(): Int {
        return listProduto.size
    }

    fun setListe(list: List<Produtos>){
        listProduto = list.sortedByDescending { it.id }
        notifyDataSetChanged()

    }

    private fun showAlertDialog(id: Long){
        AlertDialog.Builder(context)
            .setTitle("Excluir Produto")
            .setMessage("Deseja exluir o Produto?")
            .setPositiveButton("Sim"){
                    _,_-> mainViewModel.deleteProduto(id)
            }
            .setNegativeButton("Não"){
                    _,_ ->
            }.show()
    }



}