package com.example.moneyhist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Pie

class MainActivity : AppCompatActivity() {

    private var chart: AnyChartView? = null

    private val salary = listOf(200,300,400,600)
    private val month = listOf("January", "February", "March", "April")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chart = findViewById(R.id.pieChart)

        configChartView()
    }

    private fun configChartView() {
        val pie: Pie = AnyChart.pie()

        val dataPieChart: MutableList<DataEntry> = mutableListOf()

        for (index in salary.indices){
            dataPieChart.add(ValueDataEntry(month.elementAt(index),salary.elementAt(index)))
        }

        pie.data(dataPieChart)
        pie.title("Salary Overview")
        chart!!.setChart(pie)
    }
}