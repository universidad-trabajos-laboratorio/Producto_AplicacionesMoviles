package com.example.producto_aplicacionesmoviles.presentation.views.specialty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.core.TimeUtils
import com.example.producto_aplicacionesmoviles.databinding.FragmentDoctorDetailBinding


class DoctorDetailFragment : Fragment() {
    private var _binding: FragmentDoctorDetailBinding?=null
    private val binding get() = _binding!!
    val args:DoctorDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDoctorDetailBinding.inflate(inflater,container,false)

        return binding.root
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