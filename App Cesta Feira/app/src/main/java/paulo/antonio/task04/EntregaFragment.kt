package paulo.antonio.task04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import paulo.antonio.task04.databinding.FragmentEntregaBinding
import javax.inject.Singleton

@Singleton
class EntregaFragment : Fragment() {

    private lateinit var binding: FragmentEntregaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentEntregaBinding.inflate(layoutInflater, container, false)

        binding.btnVoltar.setOnClickListener {
            findNavController().navigate(R.id.action_confirmarPagementoFragment_to_cestaDeComprasFragment)
        }



        return binding.root
    }

}