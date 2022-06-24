package paulo.antonio.task04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import paulo.antonio.task04.adapter.ProdutosAdapter
import paulo.antonio.task04.adapter.TeskClickListener
import paulo.antonio.task04.databinding.FragmentListagemProdutosBinding
import paulo.antonio.task04.model.Produtos


class ListagemProdutosFragment: Fragment(), TeskClickListener {

    private lateinit var binding: FragmentListagemProdutosBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout {
        // Inflate the layout for this fragment

        binding = FragmentListagemProdutosBinding.inflate(layoutInflater, container, false)


        mainViewModel.listProduto()

        val adapter = ProdutosAdapter(this, mainViewModel)

        binding.recyclerProdutos.adapter = adapter
        binding.recyclerProdutos.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerProdutos.setHasFixedSize(true)


        mainViewModel.myProdutosResponse.observe(viewLifecycleOwner){
                response -> if (response.body() != null){
            adapter.setList(response.body()!!)
        }
        }

        return binding.root
    }

    override fun onTaskClickListener(produtos: Produtos) {
        mainViewModel.produtoSelecionado = produtos
        findNavController().navigate(R.id.action_listagemProdutosFragment_to_produtoFragment)
    }


}

