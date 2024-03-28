package com.example.signinactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val etId = findViewById<EditText>(R.id.etId)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val setId = etId.text.toString()
            val intent = Intent(this, HomeActivity::class.java)

            if (etId.text.isEmpty() || etPassword.text.isEmpty()) {
                Toast.makeText(this.applicationContext, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("idFromSignInActivity", setId)
                startActivity(intent)
                Toast.makeText(this.applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
            }
        }

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)   // SignUpActivity 이동 및 ActivityResult 수신
        }

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val id = result.data?.getStringExtra("idFromSignUpActivity") ?: ""
                    val password = result.data?.getStringExtra("passwordFromSignUpActivity") ?: ""

                    etId.setText(id)
                    etPassword.setText(password)
                }
            }
    }
}