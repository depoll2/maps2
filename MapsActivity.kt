package com.example.googlee

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_maps.*
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val latitude  = -7.747033
        val longitude =110.355398
        val zoomlevel =15f
        val overlaySize =100f

        val uty = LatLng(latitude,longitude )
        mMap.addMarker(MarkerOptions()
            .position(uty)
            .title("Universitas Teknologi Yogyakarta").snippet("-7.7472626,110.3552708")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uty,zoomlevel))
        val googleOverlay=GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.ic_subway_black_24dp))
            .position(uty,overlaySize)
        mMap.addGroundOverlay(googleOverlay)
    }
}

