package com.example.employeeprovidentfundepf

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dobYear: Int = 0

        txtDOB.setOnClickListener {
            val c: Calendar = Calendar.getInstance()
            val currentDay = c.get(Calendar.DAY_OF_MONTH)
            val currentMonth = c.get(Calendar.MONTH)
            val currentYear = c.get(Calendar.YEAR)

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener {
                        view, year, month, day ->
                    txtDOB.setText(day.toString() + "/" + (month + 1).toString() + "/" + year.toString())
                    dobYear = year
                    display(currentYear, dobYear)
                    txtDOB.setTextColor(Color.BLACK)
                }, currentYear, currentMonth, currentDay)

            dpd.show()
        }


    }

    private fun display(cYear: Int, year: Int) {
        var age: Int = cYear - year
        var basicSaving: Int = 0
        var allowableInvestment: Double

        when (age) {
            16, 17, 18, 19, 20 -> basicSaving = 5000
            21, 22, 23, 24, 25 -> basicSaving = 14000
            26, 27, 28, 29, 30 -> basicSaving = 29000
            31, 32, 33, 34, 35 -> basicSaving = 50000
            36, 37, 38, 39, 40 -> basicSaving = 78000
            41, 42, 43, 44, 45 -> basicSaving = 116000
            46, 47, 48, 49, 50 -> basicSaving = 165000
            51, 52, 53, 54, 55 -> basicSaving = 228000
            else -> 0
        }

        allowableInvestment = basicSaving * 0.3

        txtAge.setText(age.toString())
        txtMinBS.setText(basicSaving.toString())
        txtAllowInv.setText(allowableInvestment.toInt().toString())
    }
}
