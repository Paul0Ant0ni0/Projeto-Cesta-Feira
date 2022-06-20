package paulo.antonio.cestafeira.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import paulo.antonio.cestafeira.R
import paulo.antonio.cestafeira.adapter.ProdutosAdapter
import paulo.antonio.cestafeira.databinding.FragmentCestaBinding
import paulo.antonio.cestafeira.databinding.FragmentCuponsBinding
import paulo.antonio.cestafeira.databinding.FragmentListagemProdutosBinding
import paulo.antonio.cestafeira.databinding.FragmentPerfilBinding
import paulo.antonio.cestafeira.model.Categoria
import paulo.antonio.cestafeira.model.Produto


class ListagemProdutosFragment : Fragment() {

    private lateinit var binding: FragmentListagemProdutosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListagemProdutosBinding.inflate(layoutInflater, container, false)



        val adapter = ProdutosAdapter()

        binding.recyclerProdutos.adapter = adapter
        binding.recyclerProdutos.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerProdutos.setHasFixedSize(true)



        // Navegar para o próximo fragment
        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listagemProdutosFragment_to_cadastrarProdutosFragment)
        }







        return binding.root
    }





}




