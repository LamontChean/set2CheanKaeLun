package com.lamont.set2cheankaelun

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var eligible = intent.getBooleanExtra("eligibility", false)
        var amount: String = "Not eligible"
        if(eligible)
        amount = intent.getStringExtra("blood").toString()

        findViewById<TextView>(R.id.result).text = "${getString(R.string.result)} $eligible"
        findViewById<TextView>(R.id.amountBlood).text = "Blood Amount: $amount"
    }
}