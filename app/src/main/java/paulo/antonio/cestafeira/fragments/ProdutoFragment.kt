package paulo.antonio.cestafeira.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import paulo.antonio.cestafeira.R
import paulo.antonio.cestafeira.databinding.FragmentProdutoBinding


class ProdutoFragment : Fragment() {
    private lateinit var binding: FragmentProdutoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProdutoBinding.inflate(LayoutInflater.from(context), container, false)

        binding.teste.setOnClickListener {
            findNavController().navigate(R.id.action_produtoFragment_to_listagemProdutosFragment)
        }

        return binding.root

    }

    /*
    fun popUp(view: View){
        context?.let {
            MaterialAlertDialogBuilder(context!!)
                .setTitle(resources.getString(R.string.title_dialog))
                .setMessage(resources.getString(R.string.dialog))
                .setNeutralButton(resources.getString(R.drawable.ic_baseline_close_24)) { dialog, which ->
                    // Respond to neutral button press
                }
                .show()
        }

    }
    private fun popUp(){
        val msgOrganico = AlertDialog.Builder(context)
        msgOrganico.setTitle("Produto Orgânico")
        msgOrganico.setIcon(R.drawable.img_organico)
        msgOrganico.setMessage("Este produto é totalmente orgânico e livre de agrotóxicos")
        msgOrganico.setCancelable(false)
        msgOrganico.setPositiveButton("X"){_,_->
            msgOrganico.show()
        }
    }*/


}