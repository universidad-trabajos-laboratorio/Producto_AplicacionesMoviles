package com.example.producto_aplicacionesmoviles.ui.specialty

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.core.Utils
import com.example.producto_aplicacionesmoviles.domain.models.Response
import com.example.producto_aplicacionesmoviles.domain.models.Specialty
import com.example.producto_aplicacionesmoviles.presentation.specialty.SpecialtyViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A fragment representing a list of Items.
 */


@AndroidEntryPoint
class ItemFragment : Fragment() {
    private val viewModel: SpecialtyViewModel by activityViewModels()
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        // Make Dagger instantiate @Inject fields in SpecialtiesActivity
        //(applicationContext as FirestoreCleanArchitectureApp).appComponent.inject(this)
        // Now specialtyViewModel is available

        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.specialty_fragment_item_list, container, false)
        var data : List<Specialty> = ArrayList<Specialty>()

        when(val specialtiesResponse = viewModel.specialtiesResponse) {
            is Response.Loading -> Utils.printMessage("CARGANDO")
            is Response.Success -> {
                data = specialtiesResponse.data
            }
            is Response.Error -> Utils.printMessage(specialtiesResponse.message)
        }

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyItemRecyclerViewAdapter(data)
            }
        }
        viewModel.getSpecialties()
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) = ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}