package com.example.signinactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val et_name = findViewById<EditText>(R.id.et_name)
        val et_id = findViewById<EditText>(R.id.et_id)
        val et_password = findViewById<EditText>(R.id.et_Password)
        val btn_sign_up = findViewById<Button>(R.id.btn_sign_up)
        btn_sign_up.setOnClickListener {
            val strId = et_id.text.toString()
            val strPassword = et_password.text.toString()
            val intent = Intent(this, SignInActivity::class.java)

            if (et_name.text.isEmpty() || et_id.text.isEmpty() || et_password.text.isEmpty()) {
                Toast.makeText(this.applicationContext, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("idFromSignUpActivity", strId)
                intent.putExtra("passwordFromSignUpActivity", strPassword)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}