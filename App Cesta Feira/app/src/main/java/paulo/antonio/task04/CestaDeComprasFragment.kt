package paulo.antonio.task04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import paulo.antonio.task04.adapter.CestaAdapter
import paulo.antonio.task04.data.cesta.MainViewModelCesta
import paulo.antonio.task04.databinding.FragmentCestaDeComprasBinding
import paulo.antonio.task04.model.Produtos

class CestaDeComprasFragment : Fragment() {

    private lateinit var binding: FragmentCestaDeComprasBinding
    private val viewModel: MainViewModelCesta by activityViewModels()
    private var produtoSelecionado: Produtos? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCestaDeComprasBinding.inflate(layoutInflater, container, false)

        //recuperarDados()


        binding.btnVoltarCesta.setOnClickListener {
            findNavController().navigate(R.id.action_cestaDeComprasFragment_to_produtoFragment)
        }

        binding.btnTerminarCompra.setOnClickListener {
            findNavController().navigate(R.id.action_cestaDeComprasFragment_to_confirmarPagementoFragment)
        }

        binding.voltaComprar.setOnClickListener {
            findNavController().navigate(R.id.action_cestaDeComprasFragment_to_listagemProdutosFragment)
        }



        //instanciando o recyclerView
        val adapter = context?.let { CestaAdapter(it) }
        binding.recyclerProdCesta.layoutManager = LinearLayoutManager(context)
        binding.recyclerProdCesta.adapter = adapter
        binding.recyclerProdCesta.setHasFixedSize(true)






        return binding.root
    }
/*
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

*/
}