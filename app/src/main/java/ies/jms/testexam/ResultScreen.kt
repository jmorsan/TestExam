package ies.jms.testexam

import android.graphics.Color.green
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ies.jms.testexam.MainActivity.Companion.preguntas
import ies.jms.testexam.adapter.ItemAdapter
import ies.jms.testexam.data.Datasource

class ResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        val textResult : TextView = findViewById(R.id.textResult)
        val layout : LinearLayout = findViewById(R.id.layout)

        var  puntos : Double = 0.0

        preguntas.forEach{
            if(it.key.respuesta==it.value){
                puntos+=2
            }else
            {
                puntos-= 0.5
            }
        }

        if(puntos>=5)
        {
            layout.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAprobado))
            textResult.setTextColor(ContextCompat.getColor(this,R.color.black))

        }
        else
        {
            layout.setBackgroundColor(ContextCompat.getColor(this,R.color.colorSuspenso))
            textResult.setTextColor(ContextCompat.getColor(this,R.color.white))
        }

        textResult.text = puntos.toString()

        val btBack : Button = findViewById(R.id.boton_cerrar_sesion)
        btBack.setOnClickListener {
            preguntas.clear()
            val myDataset = Datasource().loadPreguntas().shuffled().take(5)
            val recyclerView : RecyclerView =findViewById<RecyclerView>(R.id.lista_preguntas)
            recyclerView.adapter = ItemAdapter(this,myDataset)
            onBackPressed()
        }

    }





}