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
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.data.model.WorkDay
import com.example.producto_aplicacionesmoviles.databinding.FragmentConsultaCreateBinding
import com.example.producto_aplicacionesmoviles.presentation.adapters.*
import com.example.producto_aplicacionesmoviles.presentation.components.DatePicketFragment
import com.example.producto_aplicacionesmoviles.presentation.utils.ItemHorario
import com.example.producto_aplicacionesmoviles.viewmodels.SpecialtyDoctorsViewModel
import com.example.producto_aplicacionesmoviles.viewmodels.SpecialtyViewModel
import com.example.producto_aplicacionesmoviles.viewmodels.WorkDaysViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint()
class ConsultaCreateFragment : Fragment() {
    private var _binding: FragmentConsultaCreateBinding? = null
    private val binding get() = _binding!!
    private val specialtyViewModel: SpecialtyViewModel by viewModels()
    private val specialtyDoctorsViewModel: SpecialtyDoctorsViewModel by viewModels()
    private val workDaysViewModel: WorkDaysViewModel by viewModels()
    private var workDaysList = mutableListOf<WorkDay>()

    private fun showDatePicketDialog() {
        val datePicker = DatePicketFragment { day, month, year ->
            onDateSelected(day, month, year)
        }
        this.activity?.supportFragmentManager?.let { datePicker.show(it, "datePicket") }
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        val message = "${day.toString()}/${month.toString()}/${year.toString()}"
        binding.eDate.setText(message)
        updateIntervalos(workDaysList, nameDay(year, month, day))

    }

    private fun updateIntervalos(workDaysList: List<WorkDay>, numberDay: Int) {
        val auxList = ArrayList<ItemHorario>()

        for (workday in workDaysList) {
            if (workday.day == numberDay) {
                auxList.add(ItemHorario(workday.day, workday.morning_start, workday.morning_end))
            }
        }
        binding.autocomleteHorario.setText("")
        binding.autocomleteHorario.setAdapter(
            WorkDaySpinnerAdapter(
                this.requireContext(),
                auxList
            )
        )

    }

    private fun nameDay(year: Int, month: Int, day: Int): Int {
        var calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val daySelect = calendar.get(Calendar.DAY_OF_WEEK)
        var numberDay = when (daySelect) {
            Calendar.SUNDAY -> 7
            Calendar.MONDAY -> 1
            Calendar.TUESDAY -> 2
            Calendar.WEDNESDAY -> 3
            Calendar.THURSDAY -> 4
            Calendar.FRIDAY -> 5
            Calendar.SATURDAY -> 6
            else -> 7
        }
        return numberDay

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConsultaCreateBinding.inflate(inflater, container, false)
        binding.eDate.setOnClickListener { showDatePicketDialog()}
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
                binding.autocomleteDoctores.setAdapter(
                    SpecialtyDoctorSpinnerAdapter(
                        this.requireContext(),
                        specialtyDoctorList
                    )
                )
            })

        specialtyDoctorsViewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
//            binding.progress.isVisible = isLoading
        })
        workDaysViewModel.workDaysByUserIdResponse.observe(
            viewLifecycleOwner,
            Observer { listWorkDays ->
                workDaysList.clear()
                workDaysList.addAll(listWorkDays)
            })


        return binding.root
    }

    private fun setucCustomSpinner() {

        binding.autocomleteEspecialidad.onItemClickListener =
            AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
                var specialty: Specialty = p0!!.getItemAtPosition(p2) as Specialty
                val idSpecialty = specialty.id.toString()
                Toast.makeText(view?.context, specialty.id, Toast.LENGTH_SHORT).show()
                binding.autocomleteDoctores.setAdapter(
                    SpecialtyDoctorSpinnerAdapter(
                        this.requireContext(),
                        emptyList()
                    )
                )
                binding.autocomleteDoctores.setText("")
                specialtyDoctorsViewModel.getDoctorsBySpecialtyId(idSpecialty)

            }
        binding.autocomleteDoctores.onItemClickListener =
            AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
                var doctor: SpecialtyDoctor = p0!!.getItemAtPosition(p2) as SpecialtyDoctor
                val idDoctor = doctor.user_id.toString()
                Toast.makeText(view?.context, doctor.id, Toast.LENGTH_SHORT).show()
                binding.autocomleteHorario.setAdapter(
                    WorkDaySpinnerAdapter(
                        this.requireContext(),
                        emptyList()
                    )
                )
                binding.autocomleteHorario.setText("")
                workDaysViewModel.getWorkDaysByUserId(idDoctor)

            }




        binding.autocomleteEspecialidad.setAdapter(
            SpecialtySpinnerAdapter(
                this.requireContext(),
                emptyList()
            )
        )
        binding.autocomleteDoctores.setAdapter(
            SpecialtyDoctorSpinnerAdapter(
                this.requireContext(),
                emptyList()
            )
        )
        binding.autocomleteHorario.setAdapter(
            WorkDaySpinnerAdapter(
                this.requireContext(),
                emptyList()
            )
        )

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