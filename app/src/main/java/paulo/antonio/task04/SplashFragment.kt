package paulo.antonio.task04

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import paulo.antonio.task04.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)

        //Temporizador para alterar a tela
        Handler().postDelayed({
            findNavController().navigate(
                R.id.action_splashFragment2_to_acessoFragment,null,
                NavOptions.Builder().setPopUpTo(R.id.listagemProdutosFragment, true)
                    .build())        }, 3200)

        return binding.root
    }

}