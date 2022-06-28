package paulo.antonio.task04


import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
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

        binding.btnAgendar.setOnClickListener {
           addLocal(requireView())

        }
        binding.btnHoje.setOnClickListener {
            addLocal(requireView())
        }




        return binding.root

    }

    private fun addLocal(view: View){
        val popUpImg: AlertDialog.Builder = AlertDialog.Builder(context)
        popUpImg.setTitle("Endereço")
        popUpImg.setIcon(R.drawable.ic_baseline_add_location_24)

        val inputEnd = EditText(context)
        inputEnd.hint = "  Endereço para a entrega?  "
        inputEnd.setBackgroundColor(Color.argb(94, 223, 240, 240))
        inputEnd.inputType = InputType.TYPE_CLASS_TEXT
        popUpImg.setView(inputEnd)

        popUpImg.setPositiveButton("OK") { _, _ ->
            binding.dadosEntrega.text = inputEnd.text.toString()
            val snackbar = Snackbar.make(view, "Solicitação confirmada com sucesso", Snackbar.LENGTH_LONG)
            snackbar.setBackgroundTint(Color.GREEN)
            snackbar.setTextColor(Color.WHITE)
            snackbar.show()

        }
        popUpImg.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }
        popUpImg.show()


    }

}




