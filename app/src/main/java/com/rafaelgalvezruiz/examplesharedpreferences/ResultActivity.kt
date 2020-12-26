package com.rafaelgalvezruiz.examplesharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.rafaelgalvezruiz.examplesharedpreferences.UserVipApplication.Companion.prefs

class ResultActivity : AppCompatActivity() {
    lateinit var btnBack: Button
    lateinit var tvName:TextView
    lateinit var container:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        btnBack = findViewById(R.id.btnCerrarSesion)
        tvName = findViewById(R.id.tvName)
        container = findViewById(R.id.container)
        initUI()
    }

    fun initUI() {
        btnBack.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }
        val userName = prefs.getName()
        tvName.text = "Bienvenido$userName"
        if(prefs.getVIP()){
            setVIPBackground()
        }
    }

    private fun setVIPBackground(){
        container.setBackgroundColor(ContextCompat.getColor(this,R.color.vip_yellow))
    }
}