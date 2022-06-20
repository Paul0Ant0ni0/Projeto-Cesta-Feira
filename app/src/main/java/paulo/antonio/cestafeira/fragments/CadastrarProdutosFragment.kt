package paulo.antonio.cestafeira.fragments

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import paulo.antonio.cestafeira.MainViewModel
import paulo.antonio.cestafeira.R
import paulo.antonio.cestafeira.databinding.FragmentCadastrarProdutosBinding

class CadastrarProdutosFragment : Fragment() {
    private lateinit var binding: FragmentCadastrarProdutosBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var urlImg = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastrarProdutosBinding.inflate(layoutInflater, container, false)


        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
            Log.d("Requisicao", it.body().toString())
        }

        binding.btnVoltar.setOnClickListener {
            findNavController().navigate(R.id.action_cadastrarProdutosFragment_to_listagemProdutosFragment)
        }

        binding.inputImg.setOnClickListener {
            addImg()
        }

        binding.btnAdicionarProduto.setOnClickListener {
            inserirDados()
        }




        return binding.root
    }


    private fun inserirDados(){
        val imgProd = urlImg
        val nomeProd = binding.inputProduto.text.toString()
        val pesoProd = binding.inputPeso.text.toString()
        val valorProd = binding.inputValor.text.toString()
        val descProd = binding.inputDescricao.text.toString()

        if(validCam_Prod(imgProd, nomeProd, pesoProd, valorProd, descProd)){
            Toast.makeText(context, "Produto adicionado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_cadastrarProdutosFragment_to_listagemProdutosFragment)
        }else{
            Toast.makeText(context, "Verifique os campos", Toast.LENGTH_SHORT).show()
        }

    }

    private fun validCam_Prod(img: String, nome: String,
                              peso: String, valor:String,
                              desc: String): Boolean {

        return !((img =="" || nome =="" || nome.length < 2 || nome.length >30)
                || (peso=="" || peso.length < 2 || peso.length > 6)
                || (valor=="" || valor.length < 3 || valor.length > 5)
                || (desc=="" || desc.length < 2 || desc.length > 300))
    }

    private fun addImg(){
        val popUpImg: AlertDialog.Builder = AlertDialog.Builder(context)
        popUpImg.setTitle("URL de imagem")
        popUpImg.setIcon(R.drawable.ic_baseline_add_link_24)

        val inputImg = EditText(context)
        inputImg.hint = "  Link da imagem do produto  "
        inputImg.setBackgroundColor(Color.argb(94, 223, 240, 240))
        inputImg.inputType = InputType.TYPE_CLASS_TEXT
        popUpImg.setView(inputImg)

        popUpImg.setPositiveButton("OK") { _, _ ->
            urlImg = inputImg.text.toString()
            Glide.with(this)
                .load(urlImg)
                .placeholder(R.drawable.input_img)
                .into(binding.inputImg)

        }
        popUpImg.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }
        popUpImg.show()


    }







}