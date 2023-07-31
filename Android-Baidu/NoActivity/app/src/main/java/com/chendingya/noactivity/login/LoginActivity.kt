package com.chendingya.noactivity.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chendingya.noactivity.EmptyActivity
import com.chendingya.noactivity.MainActivity
import com.chendingya.noactivity.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) //即activity_login.xml
        findViews()
    }

    private var username: EditText? = null
    private var password: EditText? = null
    private var login: Button? = null
    private var register: Button? = null
    companion object {
        lateinit var name: String
    }

    private fun findViews() {
        username = findViewById<View>(R.id.username) as EditText
        password = findViewById<View>(R.id.password) as EditText
        login = findViewById<View>(R.id.login) as Button
        register = findViewById<View>(R.id.register) as Button
        login!!.setOnClickListener {
            name = username!!.text.toString()
            println(name)
            val pass = password!!.text.toString()
            println(pass)
            Log.i("TAG", name + "_" + pass)
            val uService = UserService(this@LoginActivity)
            val flag: Boolean = uService.login(name, pass)
            if (flag) {
                Log.i("TAG", "登录成功")
                Toast.makeText(this@LoginActivity, "登录成功", Toast.LENGTH_LONG).show()
                EmptyActivity.username = name
                val intent = Intent(this@LoginActivity, EmptyActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("flag", 3)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Log.i("TAG", "登录失败")
                Toast.makeText(this@LoginActivity, "登录失败", Toast.LENGTH_LONG).show()
            }
        }
        register!!.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }




}
