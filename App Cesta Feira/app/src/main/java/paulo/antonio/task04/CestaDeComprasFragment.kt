package paulo.antonio.task04

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import paulo.antonio.task04.adapter.CestaAdapter
import paulo.antonio.task04.data.cesta.CestaDao
import paulo.antonio.task04.data.cesta.CestaDataBase
import paulo.antonio.task04.data.cesta.MainViewModelCesta
import paulo.antonio.task04.databinding.FragmentCestaDeComprasBinding
import java.util.*

class CestaDeComprasFragment : Fragment() {

    private lateinit var binding: FragmentCestaDeComprasBinding
    private lateinit var mainViewModelCesta: MainViewModelCesta
    private lateinit var cestaDao: CestaDao
    private lateinit var cestaDataBase: CestaDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCestaDeComprasBinding.inflate(layoutInflater, container, false)

        //recuperarDados()
        this.cestaDataBase = CestaDataBase.getDataBase(requireContext())
        this.cestaDao = this.cestaDataBase.cestaDao()


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
        val adapter = CestaAdapter(mainViewModelCesta, requireContext())
        binding.recyclerProdCesta.layoutManager = LinearLayoutManager(context)
        binding.recyclerProdCesta.adapter = adapter
        binding.recyclerProdCesta.setHasFixedSize(true)

        mainViewModelCesta.selectCestas.observe(viewLifecycleOwner){ response ->
            adapter.setList(response)

        }





        return binding.root
    }

    override fun onStart() {
        super.onStart()
        totalProdCesta()
    }

    private fun totalProdCesta(){
        this.binding.textItensCesta.text = "Carregando"
        this.binding.previewTotal.text = "Carregando"


        CoroutineScope(Dispatchers.IO).launch {
            val totalItens = cestaDao.getTotalProdutos()
            val totalvalor = cestaDao.getTotalValor()

            withContext(Dispatchers.IO){
                binding.textItensCesta.text = "Você tem $totalItens de Item(ns) na cesta"
                binding.previewTotal.text = "R$ ${"%.2f".format(totalvalor.toFloat())}"

            }
        }
    }

    /*
    private fun addCupom(){
        val popUpImg: AlertDialog.Builder = AlertDialog.Builder(context)
        popUpImg.setTitle("Cupom de desconto")
        popUpImg.setIcon(R.drawable.btn_cupon)

        val inputDesc = EditText(context)
        inputDesc.hint = "  Degite o valor do desconto?  "
        inputDesc.setBackgroundColor(Color.argb(94, 223, 240, 240))
        inputDesc.inputType = InputType.TYPE_CLASS_TEXT
        popUpImg.setView(inputDesc)

        popUpImg.setPositiveButton("OK") { _, _ ->


        }
        popUpImg.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }
        popUpImg.show()


    }*/

}