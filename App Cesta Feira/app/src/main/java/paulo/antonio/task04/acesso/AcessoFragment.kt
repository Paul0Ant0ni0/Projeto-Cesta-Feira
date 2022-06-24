package paulo.antonio.task04.acesso


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import paulo.antonio.task04.R
import paulo.antonio.task04.cep.CEP
import paulo.antonio.task04.cep.RetrofitInitializer
import paulo.antonio.task04.databinding.FragmentAcessoBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AcessoFragment : Fragment() {
    private lateinit var binding: FragmentAcessoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAcessoBinding.inflate(LayoutInflater.from(context), container, false)



        binding.inputCep.setOnClickListener {
            val cep = binding.inputCep.text.toString()
            val call = RetrofitInitializer().apiRetrofitService().getEnderecoByCEP(cep)
            getCep(call)
            validarCep(cep)

        }


        binding.linkAcessarConta.setOnClickListener{
            findNavController().navigate(R.id.action_acessoFragment_to_loginFragment)
        }
        binding.cadUsuario.setOnClickListener {
            findNavController().navigate(R.id.action_acessoFragment_to_cadastroUsuarioFragment)
        }

        return binding.root
    }

    private fun getCep(call: Call<CEP>){
        call.enqueue(object : Callback<CEP> {

            override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                response?.let {

                    val CEPs: CEP? = it.body()
                    Log.d("CEP", CEPs.toString())
                    Toast.makeText(context,"CEP: "+CEPs.toString(), Toast.LENGTH_SHORT)
                        .show()
                }

            }

            override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                t?.message?.let { it1 -> Log.e("Erro", it1) }
            }

        })
    }



    private fun validarCep(cep: String){
        if(cep.length != 9){
            Toast.makeText(context,"CEP precisa ter 9 caracteres", Toast.LENGTH_SHORT).show()
        }
        else{
            findNavController().navigate(R.id.action_acessoFragment_to_listagemProdutosFragment)
        }
    }





}