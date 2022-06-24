package paulo.antonio.task04

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import paulo.antonio.task04.databinding.FragmentProdutoBinding
import paulo.antonio.task04.model.Produtos

class ProdutoFragment : Fragment() {

    private lateinit var binding: FragmentProdutoBinding
    private val viewModel: MainViewModel by activityViewModels()
    private var produtoSelecionado: Produtos? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProdutoBinding.inflate(layoutInflater, container, false)

        recuperarDados()
        viewModel.listCategoria()

        binding.totalValorPreview.setOnClickListener {
            findNavController().navigate(R.id.action_produtoFragment_to_cestaDeComprasFragment)

        }


        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun recuperarDados() {
        produtoSelecionado = viewModel.produtoSelecionado
        if (produtoSelecionado != null) {
            binding.nomePreview.text = produtoSelecionado?.nomeMarca
            binding.textDecriPreview.text = produtoSelecionado?.descricao
            Glide.with(this).load(produtoSelecionado?.imagem).placeholder(R.drawable.bg_produto).into(binding.imgPreview)
            binding.totalQtdPreview.text = "R$  ${(produtoSelecionado?.quantidade.toString())}"
            binding.totalValorPreview.text =  "Adicionar   R$ ${(produtoSelecionado?.valor)}"
        } else {
            binding.nomePreview.text = null
            binding.textDecriPreview.text = null
            Glide.with(this).load(produtoSelecionado?.imagem).placeholder(R.drawable.bg_produto).into(binding.imgPreview)
            binding.totalQtdPreview.text = null
            binding.totalValorPreview.text = null
        }
    }

}