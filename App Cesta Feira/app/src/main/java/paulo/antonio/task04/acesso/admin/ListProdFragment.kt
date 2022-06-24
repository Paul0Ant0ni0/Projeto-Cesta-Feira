package paulo.antonio.task04.acesso.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import paulo.antonio.task04.MainViewModel
import paulo.antonio.task04.R
import paulo.antonio.task04.adapter.AListProduAdpter
import paulo.antonio.task04.adapter.TeskClickListener
import paulo.antonio.task04.databinding.FragmentListProdBinding
import paulo.antonio.task04.model.Produtos


class ListProdFragment : Fragment(), TeskClickListener {

    private lateinit var binding: FragmentListProdBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListProdBinding.inflate(layoutInflater, container, false)



        mainViewModel.listProduto()

        val adapter = AListProduAdpter(this, mainViewModel)

        binding.recyclerAdminListPro.adapter = adapter
        binding.recyclerAdminListPro.layoutManager = LinearLayoutManager(context)
        binding.recyclerAdminListPro.setHasFixedSize(true)

        mainViewModel.myProdutosResponse.observe(viewLifecycleOwner){
                response -> if (response.body() != null){
            adapter.setListe(response.body()!!)
        }
        }


        return binding.root

    }

    override fun onTaskClickListener(produtos: Produtos) {
        mainViewModel.produtoSelecionado = produtos
        findNavController().navigate(R.id.action_listProdFragment_to_cadastrarProdutosFragment)
    }


}