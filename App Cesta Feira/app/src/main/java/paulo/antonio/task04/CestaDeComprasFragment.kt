package paulo.antonio.task04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import paulo.antonio.task04.adapter.CestaAdapter
import paulo.antonio.task04.data.cesta.MainViewModelCesta
import paulo.antonio.task04.databinding.FragmentCestaDeComprasBinding
import paulo.antonio.task04.model.Produtos

class CestaDeComprasFragment : Fragment() {

    private lateinit var binding: FragmentCestaDeComprasBinding
    private lateinit var mainViewModelCesta: MainViewModelCesta


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

        mainViewModelCesta = ViewModelProvider(this).get(MainViewModelCesta::class.java)



        //instanciando o recyclerView
        val adapter = CestaAdapter(requireContext())
        binding.recyclerProdCesta.layoutManager = LinearLayoutManager(context)
        binding.recyclerProdCesta.adapter = adapter
        binding.recyclerProdCesta.setHasFixedSize(true)

        mainViewModelCesta.selectCestas.observe(viewLifecycleOwner){ response ->
            adapter.setList(response)

        }





        return binding.root
    }

}