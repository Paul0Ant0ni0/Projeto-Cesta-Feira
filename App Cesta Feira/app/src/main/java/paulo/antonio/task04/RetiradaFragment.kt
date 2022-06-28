package paulo.antonio.task04

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import paulo.antonio.task04.databinding.FragmentEntregaBinding
import paulo.antonio.task04.databinding.FragmentRetiradaBinding

class RetiradaFragment : Fragment() {


        private lateinit var binding: FragmentRetiradaBinding
        val uri = "geo:0,0?q=sãopaulo"
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding = FragmentRetiradaBinding.inflate(layoutInflater, container, false)

            binding.btnMap.setOnClickListener {
                val uriMap = Uri.parse(uri)
                val fragment = Intent(Intent.ACTION_VIEW, uriMap)
                fragment.setPackage("com.google.android.apps.maps")
                startActivity(fragment)

            }

            return binding.root
        }
    }


