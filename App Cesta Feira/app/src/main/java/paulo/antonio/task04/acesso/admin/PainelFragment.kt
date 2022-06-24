package paulo.antonio.task04.acesso.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import paulo.antonio.task04.R
import paulo.antonio.task04.databinding.FragmentPainelBinding

class PainelFragment : Fragment() {

    private lateinit var binding: FragmentPainelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPainelBinding.inflate(layoutInflater, container, false)

        binding.btnAddProduto.setOnClickListener {

            findNavController().navigate(R.id.action_adminFragment_to_listProdFragment)
        }


        return binding.root
    }


}