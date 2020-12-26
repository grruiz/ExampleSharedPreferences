package com.rafaelgalvezruiz.examplesharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.rafaelgalvezruiz.examplesharedpreferences.UserVipApplication.Companion.prefs

class MainActivity : AppCompatActivity() {
    lateinit var etName:EditText
    lateinit var button:Button
    lateinit var cbVIP:CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etNombre)
        cbVIP = findViewById(R.id.cbVIP)
        button = findViewById(R.id.btnContinue)
        initUI()
        checkUserValues()
    }

    private fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }

    private fun initUI(){

        button.setOnClickListener{ accesToDetail()  }
    }

    private fun accesToDetail(){
        if(etName.text.toString().isNotEmpty()){
            prefs.saveName(etName.text.toString())
            prefs.saveVIP(cbVIP.isChecked)
            goToDetail()
        }else{
            Toast.makeText(this,"No eres vip",Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToDetail(){
        startActivity(Intent(this,ResultActivity::class.java))
    }
}