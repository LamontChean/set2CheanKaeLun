package com.lamont.set2cheankaelun

import android.app.Notification
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.lamont.set2cheankaelun.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.link.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://pdn.gov.my")
            startActivity(intent)
        }
        binding.submit.setOnClickListener {
            var intent2 = Intent(this, Result::class.java)
            var eligibility: Boolean = true
            val age = binding.age.text.toString().toIntOrNull()

            if(age == null){
                Toast.makeText(this,"Enter age",Toast.LENGTH_SHORT).show()
            }else if(age < 18 || age >60){
                eligibility = false
            }

            if(!binding.sleep.isChecked)
                eligibility = false

            if(!binding.health.isChecked)
                eligibility = false


            if(binding.weight.checkedRadioButtonId == R.id.lessThan45){
                    eligibility = false
            }else if(binding.weight.checkedRadioButtonId == R.id.between45and50){
                intent2.putExtra("blood", "350ml")
            }else{
                intent2.putExtra("blood", "450ml")
            }


            //binding.result.text = "${getString(R.string.result)} $eligibility"
            intent2.putExtra("eligibility", eligibility)
            startActivity(intent2)
        }

    }


}