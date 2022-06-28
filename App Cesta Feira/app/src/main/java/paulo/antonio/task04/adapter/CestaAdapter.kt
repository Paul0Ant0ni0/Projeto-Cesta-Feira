package paulo.antonio.task04.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import paulo.antonio.task04.R
import paulo.antonio.task04.data.cesta.CestaDao
import paulo.antonio.task04.data.cesta.Produtos
import paulo.antonio.task04.data.cesta.MainViewModelCesta
import paulo.antonio.task04.databinding.CardCestaBinding

class CestaAdapter(
    val mainViewModelCesta: MainViewModelCesta,
    var context: Context
): RecyclerView.Adapter<CestaAdapter.CestaViewHolder>(){
    private  var adminlistProduto = emptyList<Produtos>()

    class CestaViewHolder (val binding: CardCestaBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CestaViewHolder {
        return CestaViewHolder(CardCestaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: CestaViewHolder, position: Int) {
        val produto = adminlistProduto[position]


        holder.binding.textNomeCesta.text = produto.nomeProduto
        holder.binding.textQdtCesta.text = produto.quantidade
        holder.binding.textValorCesta.text = "R$ ${produto.valor}"
        holder.binding.textInfoCesta.text = "Compra a cada 100g"

        holder.binding.deletProd.setOnClickListener {
            showAlertDialog(produto)
        }

        Glide.with(context)
            .load(adminlistProduto[position].imagen)
            .placeholder(R.drawable.input_img)
            .into(holder.binding.imgCesta)


    }

    //Acessar o tamanho da list
    override fun getItemCount(): Int {
        return adminlistProduto.size
    }

    fun setList(produtos: List<Produtos>){
        adminlistProduto = produtos.sortedByDescending { it.id }
        //notifyDataSetChanged serve para mudar a lista quando atualizada
        notifyDataSetChanged()
    }

    private fun showAlertDialog(produtos: Produtos){
        AlertDialog.Builder(context)
            .setTitle("Excluir Produto")
            .setMessage("Deseja exluir o Produto?")
            .setPositiveButton("Sim"){
                    _,_-> mainViewModelCesta.deleteProduto(produtos)
            }
            .setNegativeButton("Não"){
                    _,_ ->
            }.show()
    }



}