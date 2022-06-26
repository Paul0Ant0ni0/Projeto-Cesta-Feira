package paulo.antonio.task04

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import paulo.antonio.task04.data.cesta.MainViewModelCesta
import paulo.antonio.task04.databinding.FragmentProdutoBinding
import paulo.antonio.task04.model.Produtos

class ProdutoFragment : Fragment() {

    private lateinit var binding: FragmentProdutoBinding
    private lateinit var mainViewModelCesta: MainViewModelCesta
    private val viewModel: MainViewModel by activityViewModels()
    private var produtoSelecionado: Produtos? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProdutoBinding.inflate(layoutInflater, container, false)

        mainViewModelCesta = ViewModelProvider(this).get(MainViewModelCesta::class.java)

        recuperarDados()
        viewModel.listCategoria()

        binding.totalValorPreview.setOnClickListener {
            val produto = recuperarDados()
            if (produto != null) {
                inserirBanco(produto)
                Toast.makeText(context, "Produto adiconado na cesta", Toast.LENGTH_SHORT)
            }else{
                Toast.makeText(context, "Falha ao inserir o produto na cesta", Toast.LENGTH_SHORT)
            }
            findNavController().navigate(R.id.action_produtoFragment_to_cestaDeComprasFragment)

        }


        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun recuperarDados() : paulo.antonio.task04.data.cesta.Produtos? {
        var produto: paulo.antonio.task04.data.cesta.Produtos? = null
        produtoSelecionado = viewModel.produtoSelecionado
        if (produtoSelecionado != null) {
            binding.nomePreview.text = produtoSelecionado?.nomeMarca
            binding.textDecriPreview.text = produtoSelecionado?.descricao
            Glide.with(this).load(produtoSelecionado?.imagem).placeholder(R.drawable.bg_produto).into(binding.imgPreview)
            binding.totalQtdPreview.text = "R$  ${(produtoSelecionado?.quantidade.toString())}"
            binding.totalValorPreview.text =  "Adicionar   R$ ${(produtoSelecionado?.valor)}"
            val nome= produtoSelecionado?.nomeMarca
            val qtd = produtoSelecionado?.quantidade
            val valor = produtoSelecionado?.valor 

            produto = paulo.antonio.task04.data.cesta.Produtos(0, produtoSelecionado?.imagem.toString(),
            nome.toString(), qtd.toString(),valor.toString())
        } else {
            binding.nomePreview.text = null
            binding.textDecriPreview.text = null
            Glide.with(this).load(produtoSelecionado?.imagem).placeholder(R.drawable.bg_produto).into(binding.imgPreview)
            binding.totalQtdPreview.text = null
            binding.totalValorPreview.text = null
        }

        return produto
    }



    private fun inserirBanco(produtos: paulo.antonio.task04.data.cesta.Produtos){
        mainViewModelCesta.addProduto(produtos)
    }

}