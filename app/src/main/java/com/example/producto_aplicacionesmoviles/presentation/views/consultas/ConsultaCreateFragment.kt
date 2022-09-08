package com.example.producto_aplicacionesmoviles.presentation.views.consultas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.data.model.Specialty
import com.example.producto_aplicacionesmoviles.databinding.FragmentConsultaCreateBinding
import com.example.producto_aplicacionesmoviles.presentation.adapters.SpecialtyAdapter
import com.example.producto_aplicacionesmoviles.presentation.adapters.SpecialtyDoctorAdapter
import com.example.producto_aplicacionesmoviles.presentation.adapters.SpecialtyDoctorSpinnerAdapter
import com.example.producto_aplicacionesmoviles.presentation.adapters.SpecialtySpinnerAdapter
import com.example.producto_aplicacionesmoviles.viewmodels.SpecialtyDoctorsViewModel
import com.example.producto_aplicacionesmoviles.viewmodels.SpecialtyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint()
class ConsultaCreateFragment : Fragment() {
    private var _binding: FragmentConsultaCreateBinding? = null
    private val binding get() = _binding!!
    private val specialtyViewModel: SpecialtyViewModel by viewModels()
    private val specialtyDoctorsViewModel: SpecialtyDoctorsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConsultaCreateBinding.inflate(inflater, container, false)
//LISTA DE SPECIALIDADES
        specialtyViewModel.specialtiesResponse.observe(
            viewLifecycleOwner,
            Observer { currentSpeciatlyList ->
                binding.autocomleteEspecialidad.setAdapter(
                    SpecialtySpinnerAdapter(
                        this.requireContext(),
                        currentSpeciatlyList
                    )
                )

            })

        specialtyViewModel.isLoading.observe(viewLifecycleOwner, Observer { stateLoading ->
//            binding.spinnerEspecialidad.isVisible = stateLoading
        })
// LISTA DE DOCTORES
        specialtyDoctorsViewModel.doctorsBySpecialtyResponse.observe(
            viewLifecycleOwner,
            Observer { specialtyDoctorList ->
                binding.autocomleteDoctores.setAdapter(SpecialtyDoctorSpinnerAdapter(this.requireContext(),specialtyDoctorList))
            })

        specialtyDoctorsViewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
//            binding.progress.isVisible = isLoading
        })



        return binding.root
    }

    private fun setucCustomSpinner() {

        binding.autocomleteEspecialidad.onItemClickListener =
            AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
                var specialty: Specialty = p0!!.getItemAtPosition(p2) as Specialty
                val idSpecialty = specialty.id.toString()
                Toast.makeText(view?.context, specialty.id, Toast.LENGTH_SHORT).show()
                binding.autocomleteDoctores.setAdapter(SpecialtyDoctorSpinnerAdapter(this.requireContext(),
                    emptyList()))
                binding.autocomleteDoctores.setText("")
                specialtyDoctorsViewModel.getDoctorsBySpecialtyId(idSpecialty)

            }
        binding.autocomleteEspecialidad.setAdapter(
            SpecialtySpinnerAdapter(
                this.requireContext(),
                emptyList()
            )
        )
        binding.autocomleteDoctores.setAdapter(SpecialtyDoctorSpinnerAdapter(this.requireContext(),
            emptyList()))

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setucCustomSpinner()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


//        binding.spinnerEspecialidad.adapter = SpecialtySpinnerAdapter(this.requireContext(), emptyList())


//        binding.spinnerEspecialidad.onItemSelectedListener = object :
//            AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                val itemSelect = p0!!.getItemAtPosition(p2)
//                Toast.makeText(view?.context,itemSelect.toString(),Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//        }