package com.yusril.gardeneetest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.yusril.gardeneetest.MainViewModel
import com.yusril.gardeneetest.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCurrent()
        
        viewModel.onError().observe(this){
            binding.pbDetail.visibility = View.GONE

            binding.apply {


                tvErrrorMessage.visibility = View.VISIBLE
                tvErrrorMessage.text = it
            }

            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getCurrent(){
        val query = intent.getStringExtra("query")
        val apiKey = intent.getStringExtra("apiKey")
        viewModel.fetchCurrent(apiKey!!,query!!)
        viewModel.getCurrent().observe(this){
            it.also {
                binding.pbDetail.visibility = View.GONE

                binding.apply {
                    tvCelsius.visibility = View.VISIBLE
                    tvFahrenheit.visibility = View.VISIBLE
                    tvTitleCelsius.visibility = View.VISIBLE
                    tvTitleFahrenheit.visibility = View.VISIBLE
                }

                binding.tvCelsius.text = it!!.current.temp_c.toString()
                binding.tvFahrenheit.text = it.current.temp_f.toString()
            }
        }
    }


}