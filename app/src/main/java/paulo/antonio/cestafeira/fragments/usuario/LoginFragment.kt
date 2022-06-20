package paulo.antonio.cestafeira.fragments.usuario

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import paulo.antonio.cestafeira.R
import paulo.antonio.cestafeira.databinding.FragmentLoginBinding
import java.util.*

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentLoginBinding.inflate(LayoutInflater.from(context),
           container, false)

        binding.btnAcessar.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val senha = binding.inputSenha.text.toString()

            logar(email, senha, it)
        }


        return binding.root
    }


    private fun logar(email: String, senha: String, view: View){
        if (email.isEmpty() || senha.isEmpty()){
            val snackbar = Snackbar.make(view, "Preencha todos os campos!",
                Snackbar.LENGTH_SHORT)
                snackbar.setTextColor(Color.WHITE)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
        }else{
            auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { autentificacao ->
                if (autentificacao.isSuccessful){
                    findNavController().navigate(R.id.action_loginFragment_to_listagemProdutosFragment)
                }
            }.addOnFailureListener {
                val snackbar = Snackbar.make(view, "Erro ao fazer login!", Snackbar.LENGTH_SHORT)
                snackbar.setTextColor(Color.WHITE)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }
        }
    }

}