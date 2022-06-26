package paulo.antonio.task04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import paulo.antonio.task04.databinding.FragmentEntregaBinding

class RetiradaFragment : Fragment() {


        private lateinit var binding: FragmentEntregaBinding

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding = FragmentEntregaBinding.inflate(layoutInflater, container, false)


            return binding.root
        }
    }


