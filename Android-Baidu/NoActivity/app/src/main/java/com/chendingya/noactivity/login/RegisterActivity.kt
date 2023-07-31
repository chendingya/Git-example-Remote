package com.chendingya.noactivity.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chendingya.noactivity.R

class RegisterActivity : AppCompatActivity() {
    var username: EditText? = null
    var password: EditText? = null
    var age: EditText? = null
    var phone: EditText? = null
    var sex: RadioGroup? = null
    var register: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        findViews()
        register!!.setOnClickListener {
            val name = username!!.text.toString().trim { it <= ' ' }
            val pass = password!!.text.toString().trim { it <= ' ' }
            val agestr = age!!.text.toString().trim { it <= ' ' }
            val phonenum = phone!!.text.toString().trim { it <= ' ' }
            val sexstr =
                (findViewById<View>(sex!!.checkedRadioButtonId) as RadioButton).text.toString()
            //打印信息
            Log.i("TAG", name + "_" + pass + "_" + agestr + "_" + phonenum + "_" + sexstr)
            //获得userservice
            val uService = UserService(this@RegisterActivity)
            //检查姓名查重
            val flag = uService.check(name)
            if (flag) Toast.makeText(
                this@RegisterActivity,
                "用户名已存在，请更换用户名后再注册！",
                Toast.LENGTH_LONG
            ).show() else {
                val user = User()
                user.username = name
                user.password = pass
                user.age = agestr.toInt()
                user.phone = phonenum
                user.sex = sexstr
                uService.register(user)
                Toast.makeText(this@RegisterActivity, "注册成功", Toast.LENGTH_LONG).show()
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun findViews() {
        username = findViewById<View>(R.id.usernameRegister) as EditText
        password = findViewById<View>(R.id.passwordRegister) as EditText
        age = findViewById<View>(R.id.ageRegister) as EditText
        phone = findViewById<View>(R.id.phoneRegister) as EditText
        sex = findViewById<View>(R.id.sexRegister) as RadioGroup
        register = findViewById<View>(R.id.Register) as Button
    }
}