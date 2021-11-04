package com.example.cuentadividida.fragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cuentadividida.R
import com.example.cuentadividida.adapters.EventoListAdapter
import com.example.cuentadividida.application.ConsumoApplication
import com.example.cuentadividida.databinding.FragmentListBinding
import com.example.cuentadividida.viewmodel.ConsumoViewModel
import com.example.cuentadividida.viewmodel.ConsumoViewModelFactory

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EventoListAdapter

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
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = EventoListAdapter()
        recyclerView.adapter = adapter

        viewModel.agrupadoPorEvento.observe(viewLifecycleOwner,{
            adapter.submitList(it)
        })


//        viewModel.listado.observe(viewLifecycleOwner, {
//            adapter.submitList(it)
//        })




        return binding.root


    }


}