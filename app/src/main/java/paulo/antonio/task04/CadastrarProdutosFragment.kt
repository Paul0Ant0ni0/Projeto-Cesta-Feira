package paulo.antonio.task04

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import paulo.antonio.task04.databinding.FragmentCadastrarProdutosBinding
import paulo.antonio.task04.model.Categoria
import paulo.antonio.task04.model.Produtos

class CadastrarProdutosFragment : Fragment() {
    private lateinit var binding: FragmentCadastrarProdutosBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var urlImg = ""
    private var categoriaSelecionada = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Está inflando o layout para ser visualizado
        binding = FragmentCadastrarProdutosBinding.inflate(layoutInflater, container, false)

        mainViewModel.listCategoria()

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
                response -> Log.d("Requisicao", response.body().toString())
            spinnerCategoria(response.body())
        }

        binding.btnVoltar.setOnClickListener {
            findNavController().navigate(R.id.action_cadastrarProdutosFragment_to_adminProdutoFragment)
        }

        binding.inputImg.setOnClickListener {
            addImg()
        }

        binding.btnAdicionarProduto.setOnClickListener {
            inserirDados()
        }

        return binding.root
    }

    private fun inserirDados() {
        val imgProd = urlImg
        val nomeProd = binding.inputProduto.text.toString()
        val pesoProd = binding.inputPeso.text.toString()
        val valorProd = binding.inputValor.text.toString()
        val descProd = binding.inputDescricao.text.toString()
        val categoria = Categoria(categoriaSelecionada, null, null)

        if (validarCampos(nomeProd, pesoProd, valorProd, descProd)) {
            val produtos = Produtos(0, nomeProd, descProd, imgProd, pesoProd, valorProd, categoria)
            mainViewModel.addProduto(produtos)
            Toast.makeText(context, "Produto adicionado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_cadastrarProdutosFragment_to_adminProdutoFragment)
        } else {
            Toast.makeText(context, "Verifique os campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validarCampos(
        nome: String,
        peso: String,
        valor: String,
        desc: String
    ): Boolean {

        return !((nome == "" || nome.length < 2 || nome.length > 30)
                || (peso == "" || peso.length < 2 || peso.length > 6)
                || (valor == "" || valor.length < 3 || valor.length > 5)
                || (desc == " " || desc.length < 2 || desc.length > 300))
    }

    private fun spinnerCategoria(listCategoria: List<Categoria>?) {
        if (listCategoria != null) {
            binding.inputCategoria.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.transition.R.layout.support_simple_spinner_dropdown_item,
                    listCategoria
                )

            binding.inputCategoria.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selected = binding.inputCategoria.selectedItem as Categoria
                        categoriaSelecionada = selected.id
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }
        }
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