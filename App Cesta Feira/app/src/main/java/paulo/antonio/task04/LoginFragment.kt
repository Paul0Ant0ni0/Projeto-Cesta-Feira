package paulo.antonio.task04

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import paulo.antonio.task04.databinding.FragmentLoginBinding


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

    /*Precisa fazer a validação do switch, para verficar se o usuário esta logado
    override fun onStart() {
        super.onStart()
        val check = binding.statusLogins.isChecked

        view?.let { vadidarStatus(check, it) }


    }

    private fun vadidarStatus(check : Boolean, view: View){
        if (check){
            val usuarioAtual = FirebaseAuth.getInstance().currentUser
            if (usuarioAtual != null){

                findNavController().navigate(R.id.action_loginFragment_to_listagemProdutosFragment)
            }else{
                val snackbar = Snackbar.make(view, "Você não está logado!",
                    Snackbar.LENGTH_SHORT)
                snackbar.setTextColor(Color.WHITE)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }
        }
    }*/
    private fun loginAdmin(email: String): Boolean {
        val admin = Firebase.auth.currentUser
        val adminApp = "appcestafeira@gmail.com"
        val valide = true
        admin?.let {
            val emailAdmin = admin.email
            if (emailAdmin == adminApp) {
                if (findNavController().currentDestination?.id == R.id.loginFragment) {
                    findNavController().navigate(R.id.action_loginFragment_to_adminFragment3)
                }

            }else{
                if (findNavController().currentDestination?.id == R.id.loginFragment) {
                    findNavController().navigate(R.id.action_loginFragment_to_listagemProdutosFragment)
                }
            }
            // Check if user's email is verified
            //val emailVerified = admin.isEmailVerified
        }
        return valide

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
                if (loginAdmin(email)){
                    loginAdmin(email)
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