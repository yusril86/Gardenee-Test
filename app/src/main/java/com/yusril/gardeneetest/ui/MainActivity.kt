package com.yusril.gardeneetest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.yusril.gardeneetest.MainViewModel
import com.yusril.gardeneetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    private val cities = arrayOf("Kuala Lumpur","Singapore")
    private var query  = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        selectCities()

        binding.btnSubmit.setOnClickListener {
            val apiKey = binding.edtApiKey.text.toString()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("query",query)
            intent.putExtra("apiKey",apiKey)
            startActivity(intent)
        }
    }

    private fun selectCities(){
        binding.spinCities.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cities)
        binding.spinCities.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                query = cities[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }



}