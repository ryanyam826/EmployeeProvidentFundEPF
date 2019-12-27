package com.example.employeeprovidentfundepf

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDOB.setOnClickListener() {
            val c: Calendar = Calendar.getInstance()
            val currentDay = c.get(Calendar.DAY_OF_MONTH)
            val currentMonth = c.get(Calendar.MONTH)
            val currentYear = c.get(Calendar.YEAR)

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    txtDOB.setText(day.toString() + "/" + (month + 1).toString() + "/" + year.toString())
                    val age = (currentYear - year)
                    txtAge.text = age.toString()
                    txtMinBS.text = "RM " + getMinBasicsaving(age).toString()
                    txtAllowInv.text = "RM " + (txtMinBS.text.toString().toDouble() * 0.3).toString()
                },currentYear,currentMonth,currentDay)

            dpd.show()
        }

    }

     private fun getMinBasicsaving(age:Int):Double{
        if(age > 15 && age < 21){
           return 5000.00
        }else if(age > 20 && age < 26){
            return 14000.00
        }else if(age > 25 && age < 31){
            return 29000.00
        }else if(age > 30 && age < 36){
            return 50000.00
        }else if(age > 35 && age < 41){
            return 78000.00
        }else if(age > 40 && age < 46){
            return 116000.00
        }else if(age > 45 && age < 51){
            return 165000.00
        }else if(age > 50 && age < 56){
            return 228000.00
        }
        return 0.00;
    }
}
