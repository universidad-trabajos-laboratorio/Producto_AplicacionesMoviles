package com.example.producto_aplicacionesmoviles.presentation.views.specialty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.core.TimeUtils
import com.example.producto_aplicacionesmoviles.databinding.FragmentDoctorDetailBinding
import com.example.producto_aplicacionesmoviles.presentation.adapters.WorkDayAdapter
import com.example.producto_aplicacionesmoviles.viewmodels.WorkDaysViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoctorDetailFragment : Fragment() {
    private var _binding: FragmentDoctorDetailBinding?=null
    private val binding get() = _binding!!
    val args:DoctorDetailFragmentArgs by navArgs()
    private val workDaysViewModel:WorkDaysViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDoctorDetailBinding.inflate(inflater,container,false)
       initRecycleView()

        workDaysViewModel.workDaysByUserIdResponse.observe(viewLifecycleOwner, Observer { listWorkDays->
            binding.rvWorkDay.adapter = WorkDayAdapter(listWorkDays)
        })

        return binding.root
    }

    private fun initRecycleView(){
        val layout = LinearLayoutManager(this.context)
        binding.rvWorkDay.layoutManager = layout
        binding.rvWorkDay.adapter = WorkDayAdapter(emptyList())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSpecialtyDoctorTitle.text = convertTitle(args.doctor.name!!)
        binding.tvDoctorDetailSubTitle.text = args.doctor.title
        binding.tvDoctorDetailStudies.text = "UNS"
        binding.tvDoctorDetailGrade.text = args.doctor.title
        binding.tvDoctorDetailFullName.text = args.doctor.name
        binding.tvDoctorDetailDescription.text = args.doctor.biography
        binding.tvDoctorDetailWorkingTime.text = TimeUtils.getElapsedTimeInHumanReadableFormatFromTimestamp(args.doctor.enter_date!!.toLong())
        val active:Boolean = args.doctor.active?:false

        if(active){
            binding.tvDoctorDetailState.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_success,0,0,0)
            binding.tvDoctorDetailState.text = "Disponible"
        }else{
            binding.tvDoctorDetailState.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_danger,0,0,0)
            binding.tvDoctorDetailState.text = "No Disponible"
        }

        workDaysViewModel.getWorkDaysByUserId(args.doctor.user_id!!)
    }

    private fun convertTitle(title:String):String{
        val titleArray = title.split(" ").toTypedArray()
        return "Dr ${titleArray[titleArray.size-1]} ${titleArray[titleArray.size-2]?:""}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}