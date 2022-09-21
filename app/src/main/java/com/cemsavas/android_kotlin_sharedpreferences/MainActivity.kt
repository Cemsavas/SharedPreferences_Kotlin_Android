package com.cemsavas.android_kotlin_sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.cemsavas.android_kotlin_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedPreferences=getSharedPreferences("ProfileInfo", MODE_PRIVATE)
        binding.button.setOnClickListener {
            var name=binding.editTextTextPersonName.text.toString()
            var age=binding.editTextNumber.text.toString()
            if(binding.editTextTextPersonName.text.isNotEmpty()&&binding.editTextNumber.text.isNotEmpty()) {
                binding.textView.visibility=TextView.GONE
                sharedPreferences.edit().putString("name", name).apply()
                sharedPreferences.edit().putString("age", age).apply()
                binding.editTextTextPersonName.text.clear()
                binding.editTextNumber.text.clear()
                Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this,"Please Fill name and age",Toast.LENGTH_SHORT).show()
            }
        }
        binding.button2.setOnClickListener {
            var loadname=sharedPreferences.getString("name",null)
            var loadage=sharedPreferences.getString("age",null)
            binding.textView.text=loadname+"\n"+loadage
            binding.textView.visibility=TextView.VISIBLE
        }
        binding.button3.setOnClickListener {
            sharedPreferences.edit().clear().apply()
        }
    }
}