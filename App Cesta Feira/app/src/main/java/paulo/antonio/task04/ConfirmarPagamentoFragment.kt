package paulo.antonio.task04


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import paulo.antonio.task04.databinding.FragmentConfirmarPagementoBinding


class ConfirmarPagementoFragment : Fragment() {

    private lateinit var binding: FragmentConfirmarPagementoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{
        // Inflate the layout for this fragment
        binding = FragmentConfirmarPagementoBinding.inflate(layoutInflater, container, false)

        binding.nextRetirada.setOnClickListener {
            findNavController().navigate(R.id.action_confirmarPagementoFragment_to_retiradaFragment)
        }

        return binding.root

    }

}




