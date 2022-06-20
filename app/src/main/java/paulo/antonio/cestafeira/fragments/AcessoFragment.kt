package paulo.antonio.cestafeira.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import paulo.antonio.cestafeira.R
import paulo.antonio.cestafeira.databinding.FragmentAcessoBinding

class AcessoFragment : Fragment() {

    private lateinit var binding: FragmentAcessoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentAcessoBinding.inflate(LayoutInflater.from(context), container, false)

        binding.linkAcessarConta.setOnClickListener{
            findNavController().navigate(R.id.action_acessoFragment_to_loginFragment)
        }
        binding.cadUsuario.setOnClickListener {
            findNavController().navigate(R.id.action_acessoFragment_to_cadastroFragment)
        }
        return binding.root
    }






}