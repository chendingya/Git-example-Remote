package com.chendingya.noactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chendingya.noactivity.bean.Weather_bean
import com.chendingya.noactivity.adaptor.WeatherAdapter

class WeatherActivity : AppCompatActivity() {
    private val weatherList: MutableList<Weather_bean> = ArrayList<Weather_bean>() //存储实例化的数据


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        addWeather() //添加weather信息
        val recyclerView = findViewById<RecyclerView>(R.id.hour_wea)
        val layoutManager = LinearLayoutManager(this) //添加布局管理器
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL //设置为横向水平滚动
        recyclerView.layoutManager = layoutManager //设置布局管理器
        val adapter = WeatherAdapter(weatherList)
        recyclerView.adapter = adapter
    }

    private fun addWeather() {
        val now = Weather_bean("现在", R.drawable.clear)
        weatherList.add(now)
        val wea =
            intArrayOf(R.drawable.rainy, R.drawable.clear, R.drawable.rainy, R.drawable.cloudy)
        for (i in 1..11) {
            val last = Weather_bean(i.toString() + "时", wea[i % 4])
            weatherList.add(last)
        }
    }
}