package com.chendingya.noactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.chendingya.noactivity.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val btnWelcome = findViewById<Button>(R.id.button1)

        btnWelcome.setOnClickListener {
            Toast.makeText(this, "click the botton", Toast.LENGTH_LONG).show()

            // 创建意图（Intent），将当前页面（MainActivity）跳转到欢迎页面（com.chendingya.noactivity.WelcomeActivity）
            val intent = Intent(this@MainActivity, WelcomeActivity::class.java)
            startActivity(intent)
        }

    }

    /**
     * 点击显示提示框
     */
    fun showToast(view: View) {
        // 必须要带show()才会有显示
        Toast.makeText(this, "Hello world, let's jump", Toast.LENGTH_LONG).show()
    }
}