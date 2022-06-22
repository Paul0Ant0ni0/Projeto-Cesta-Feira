package paulo.antonio.task04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import paulo.antonio.task04.adapter.ProdutosAdapter
import paulo.antonio.task04.databinding.FragmentAdminProdutoBinding
import paulo.antonio.task04.databinding.FragmentLoginBinding

class AdminProdutoFragment : Fragment() {

    private lateinit var binding: FragmentAdminProdutoBinding
    private lateinit var produtosAdapter: ProdutosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdminProdutoBinding.inflate(LayoutInflater.from(context),
            container, false)

        binding.btnAddProduto.setOnClickListener {
            findNavController().navigate(R.id.action_adminProdutoFragment_to_cadastrarProdutosFragment)
        }



        return binding.root
    }




}