package com.example.cuentadividida.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.example.cuentadividida.R
import com.example.cuentadividida.application.ConsumoApplication
import com.example.cuentadividida.databinding.FragmentHomeBinding
import com.example.cuentadividida.model.Consumo
import com.example.cuentadividida.viewmodel.ConsumoViewModel
import com.example.cuentadividida.viewmodel.ConsumoViewModelFactory
import com.google.android.material.textfield.TextInputLayout


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    private lateinit var application: ConsumoApplication
    private lateinit var viewModel: ConsumoViewModel


    private lateinit var tilNombre: TextInputLayout
    private lateinit var tilPrecio: TextInputLayout
    private lateinit var tilCantidad: TextInputLayout

    private lateinit var boton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        val application = requireActivity().application

        val viewModel: ConsumoViewModel by activityViewModels {
            ConsumoViewModelFactory((application as ConsumoApplication).repository)
        }

        with(binding) {
            tilNombre = tiNombre
            tilPrecio = tiPrecio
            tilCantidad = tiCantidad
            boton = botonAgregar


        }




        boton.setOnClickListener {
            val nombre = tilNombre.editText?.text.toString()
            val precio = tilPrecio.editText?.text.toString().toInt()
            val cantidad = tilCantidad.editText?.text.toString().toInt()


            val consumo = Consumo(nombre, precio, cantidad)

            viewModel.agregar(consumo)
        }




        return binding.root
    }


}