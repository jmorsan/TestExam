package ies.jms.testexam

import android.graphics.Color.green
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class ResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        val nota : Boolean = intent?.extras?.getBoolean("nota").toString().toBoolean()
        val puntos : String = intent?.extras?.getString("puntos").toString()
        val textResult : TextView = findViewById(R.id.textResult)
        val layout : LinearLayout = findViewById(R.id.layout)
        if(nota)
        {
            layout.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAprobado))
            textResult.setTextColor(ContextCompat.getColor(this,R.color.black))

        }
        else
        {
            layout.setBackgroundColor(ContextCompat.getColor(this,R.color.colorSuspenso))
            textResult.setTextColor(ContextCompat.getColor(this,R.color.white))
        }

        textResult.text = puntos

        val btBack : Button = findViewById(R.id.boton_cerrar_sesion)
        btBack.setOnClickListener {
            onBackPressed()

        }

    }





}