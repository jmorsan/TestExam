package ies.jms.testexam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import ies.jms.testexam.MainActivity.Companion.puntos
import ies.jms.testexam.R
import ies.jms.testexam.model.Pregunta

class ItemAdapter(val context : Context, val dataset:List<Pregunta>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //Elementos que tiene la vista (layout/item_list)
    class ItemViewHolder(val view : View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_pregunta)
        val radioGroup : RadioGroup = view.findViewById(R.id.item_opciones)
        val radioButtonTrue : RadioButton = view.findViewById(R.id.respuesta_verdadero)
        val radioButtonFalse : RadioButton = view.findViewById(R.id.respuesta_falso)

    }

    //Crea la base/plantilla de la vista (layout/item_list)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    //Logica con los elementos de la vista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val pregunta = dataset[position]
        holder.textView.text = context.resources.getString(pregunta.pregunta)
        holder.radioButtonTrue.setOnClickListener {
            if(pregunta.respuesta){
                puntos+=1
                Toast.makeText(context,"Puntos Actuales: "+ puntos,Toast.LENGTH_SHORT).show()

            }
            else
            {
                puntos-=1
                Toast.makeText(context,"Puntos Actuales: "+ puntos,Toast.LENGTH_SHORT).show()
            }
        }

        holder.radioButtonFalse.setOnClickListener {
            if(!pregunta.respuesta){
                puntos+=1
                Toast.makeText(context,"Puntos Actuales: "+ puntos,Toast.LENGTH_SHORT).show()
            }
            else
            {
                puntos-=1
                Toast.makeText(context,"Puntos Actuales: "+ puntos,Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}