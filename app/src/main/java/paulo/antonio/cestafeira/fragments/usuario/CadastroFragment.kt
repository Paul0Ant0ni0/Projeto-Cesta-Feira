package paulo.antonio.cestafeira.fragments.usuario

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import paulo.antonio.cestafeira.R
import paulo.antonio.cestafeira.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {

    private lateinit var binding: FragmentCadastroBinding
    private var auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCadastroBinding.inflate(LayoutInflater.from(context),
            container, false)




        binding.btnCadastrar.setOnClickListener {
            val email = binding.cadEmail.text.toString()
            var senha = binding.cadSenha.text.toString()
            val cepUsua = binding.cadCep.text.toString()


            cadUsuario(email, senha, cepUsua, it)
        }

        return binding.root
    }

    private fun cadUsuario(email: String, senha: String, cep: String, it: View){
        if (email.isEmpty() || senha.isEmpty()){
            val snackbar = Snackbar.make(it, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
            snackbar.setBackgroundTint(Color.RED)
            snackbar.show()
        }else{
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener { cadastro ->
                    if (cadastro.isSuccessful){
                        val snackbar = Snackbar.make(it, "Cadastrado com sucesso", Snackbar.LENGTH_LONG)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.show()
                        binding.cadEmail.setText("")
                        binding.cadSenha.setText("")
                        binding.cadCep.setText("")
                        findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
                    }
                }.addOnFailureListener { exception ->
                    val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha de" +
                                " no mínimo 6 caracteres!"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido!"
                        is FirebaseAuthUserCollisionException -> "Conta já existente!"
                        is FirebaseNetworkException -> "Sem conexão com a internet!"
                        else -> "Erro ao cadastrar o usuário"
                    }
                    val snackbar = Snackbar.make(it, mensagemErro, Snackbar.LENGTH_SHORT)
                    snackbar.setTextColor(Color.WHITE)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()

                }

        }

    }


}