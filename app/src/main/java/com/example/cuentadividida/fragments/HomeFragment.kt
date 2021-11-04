package com.example.cuentadividida.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.core.view.get
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.cuentadividida.R
import com.example.cuentadividida.application.ConsumoApplication
import com.example.cuentadividida.databinding.FragmentHomeBinding
import com.example.cuentadividida.model.Consumo
import com.example.cuentadividida.viewmodel.ConsumoViewModel
import com.example.cuentadividida.viewmodel.ConsumoViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


//    private lateinit var application: ConsumoApplication
//    private lateinit var viewModel: ConsumoViewModel


    private lateinit var tilNombre: TextInputLayout
    private lateinit var tilPrecio: TextInputLayout
    private lateinit var tilCantidad: TextInputLayout

    private lateinit var boton: Button

    private lateinit var fab: FloatingActionButton
    private lateinit var spinner : AutoCompleteTextView


    private var nombreEvento = ""


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
            fab = floatingActionButton
            spinner = (tilNombreEvento.editText as? AutoCompleteTextView)!!
        }


        // val items = listOf("Option 1", "Option 2", "Option 3", "Option 4")

        //var items = listOf("No hay Eventos Cargados")
        viewModel.listadoEventos.observe(viewLifecycleOwner, {


            if (viewModel.listadoEventos.value?.isNullOrEmpty() == false) {
                var items = viewModel.listadoEventos.value!!
                val adapter = ArrayAdapter(requireContext(), R.layout.eventos_list_item, items)


                spinner.setAdapter(adapter)

                spinner.setOnItemClickListener { adapterView, view, i, l ->
                    nombreEvento = items[i]

                }

            }else{
                var items = listOf("No hay Eventos Cargados")
                val adapter = ArrayAdapter(requireContext(), R.layout.eventos_list_item, items)
                (binding.tilNombreEvento.editText as? AutoCompleteTextView)!!.setAdapter(adapter)
            }
        })



        boton.setOnClickListener {
            val nombre = tilNombre.editText?.text.toString()
            val precio = tilPrecio.editText?.text.toString().toInt() ?:0
            val cantidad = tilCantidad.editText?.text.toString().toInt() ?:0






            val consumo = Consumo(nombreEvento, nombre, precio, cantidad)

            viewModel.agregarConsumo(consumo)
        }

        fab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_eventoAddFragment)
        }




        return binding.root
    }


}


