package com.example.cuentadividida.fragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.cuentadividida.R
import com.example.cuentadividida.application.ConsumoApplication
import com.example.cuentadividida.databinding.FragmentEventoAddBinding
import com.example.cuentadividida.model.Evento
import com.example.cuentadividida.viewmodel.ConsumoViewModel
import com.example.cuentadividida.viewmodel.ConsumoViewModelFactory


class EventoAddFragment : Fragment() {
    private lateinit var binding: FragmentEventoAddBinding
    private lateinit var etEvNombre: EditText
    private lateinit var boton: Button
    private lateinit var application: Application
    val viewModel: ConsumoViewModel by activityViewModels {
        ConsumoViewModelFactory((application as ConsumoApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        application = requireActivity().application


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventoAddBinding.inflate(layoutInflater, container, false)

        hacerBinding()

        boton.setOnClickListener{
            val nombre = etEvNombre.text.toString()

            viewModel.agregarEvento(Evento(nombre))
        }




        return binding.root

    }

    fun hacerBinding() {
        with(binding) {
            etEvNombre = editTextNombreEvento
            boton = button
        }
    }
}


/*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EventoAddFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EventoAddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
 */