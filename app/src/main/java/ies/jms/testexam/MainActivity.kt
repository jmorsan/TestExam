package ies.jms.testexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ies.jms.testexam.adapter.ItemAdapter
import ies.jms.testexam.data.Datasource


class MainActivity : AppCompatActivity()  {
    companion object  {
        var puntos = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadPreguntas()
        val recyclerView : RecyclerView =findViewById<RecyclerView>(R.id.lista_preguntas)
        recyclerView.adapter = ItemAdapter(this,myDataset)

        val botonResultado : Button = findViewById(R.id.boton_resultado)

        botonResultado.setOnClickListener {
            if(puntos>=5){
                val intent = Intent(this, ResultScreen::class.java)
                intent.putExtra("puntos", "APROBADO -> NOTA: "+ puntos)
                intent.putExtra("nota",true)
                this.startActivity(intent)

            }
            else
            {

                val intent = Intent(this, ResultScreen::class.java)
                intent.putExtra("puntos", "SUPENSO -> NOTA: "+ puntos)
                intent.putExtra("nota",false)
                this.startActivity(intent)
            }
        }

    }
}