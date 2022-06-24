package paulo.antonio.task04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import paulo.antonio.task04.adapter.CestaAdapter
import paulo.antonio.task04.data.cesta.MainViewModel
import paulo.antonio.task04.databinding.FragmentCestaDeComprasBinding

class CestaDeComprasFragment : Fragment() {

    private lateinit var binding: FragmentCestaDeComprasBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCestaDeComprasBinding.inflate(layoutInflater, container, false)

        binding.btnVoltarCesta.setOnClickListener {
            findNavController().navigate(R.id.action_cestaDeComprasFragment_to_produtoFragment)
        }

        binding.voltaComprar.setOnClickListener {
            findNavController().navigate(R.id.action_cestaDeComprasFragment_to_listagemProdutosFragment)
        }

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //instanciando o recyclerView
        val adapter = CestaAdapter()
        binding.recyclerProdCesta.layoutManager = LinearLayoutManager(context)
        binding.recyclerProdCesta.adapter = adapter
        binding.recyclerProdCesta.setHasFixedSize(true)

        mainViewModel.selectCestas.observe(viewLifecycleOwner){ response ->
            adapter.setList(response)

        }



        return binding.root
    }


}