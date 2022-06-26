package paulo.antonio.task04.acesso.cliente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import paulo.antonio.task04.R
import paulo.antonio.task04.databinding.FragmentPerfilUsuarioBinding


class PerfilUsuarioFragment : Fragment() {

    private lateinit var binding: FragmentPerfilUsuarioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentPerfilUsuarioBinding.inflate(layoutInflater, container, false)


        binding.btnSairApp.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            findNavController().navigate(R.id.action_perfilUsuarioFragment_to_loginFragment)
        }


        return binding.root
    }


}