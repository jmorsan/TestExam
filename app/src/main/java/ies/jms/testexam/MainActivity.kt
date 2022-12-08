package ies.jms.testexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import ies.jms.testexam.adapter.ItemAdapter
import ies.jms.testexam.data.Datasource
import ies.jms.testexam.model.Pregunta


class MainActivity : AppCompatActivity()  {
    companion object  {
        var preguntas = mutableMapOf<Pregunta,Boolean>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadPreguntas().shuffled().take(5)
        val recyclerView : RecyclerView =findViewById<RecyclerView>(R.id.lista_preguntas)
        recyclerView.adapter = ItemAdapter(this,myDataset)

        val botonResultado : Button = findViewById(R.id.boton_resultado)


        botonResultado.setOnClickListener {

            val intent = Intent(this, ResultScreen::class.java)
            this.startActivity(intent)


        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        preguntas.clear()
        val myDataset = Datasource().loadPreguntas().shuffled().take(5)
        val recyclerView : RecyclerView =findViewById<RecyclerView>(R.id.lista_preguntas)
        recyclerView.adapter = ItemAdapter(this,myDataset)
        return super.onOptionsItemSelected(item)
    }
}