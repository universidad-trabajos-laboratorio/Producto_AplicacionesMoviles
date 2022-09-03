package com.example.producto_aplicacionesmoviles.presentation.views.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentAboutBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AboutFragment : Fragment(),OnMapReadyCallback {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    private lateinit var map:GoogleMap;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.aboutMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0
        map.isMyLocationEnabled()
        val zoom = 16f
        val centerMap = LatLng(-9.4737461, -78.3070496)
        val marker:MarkerOptions = MarkerOptions().position(centerMap).title("UNS")
        map.addMarker(marker)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap, zoom),
            4000,
            null
        )
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}