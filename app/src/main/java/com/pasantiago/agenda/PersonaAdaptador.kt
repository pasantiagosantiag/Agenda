package com.pasantiago.agenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonaAdaptador(private val personas: ArrayList<Persona>) : RecyclerView.Adapter<PersonaAdaptador.ViewHolder>(){
    //vista de cada elemento
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagen: ImageView
        var nombre: TextView
        init {
            imagen = view.findViewById(R.id.imagen)
            nombre= view.findViewById(R.id.nombre)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            //se define la plantilla de cada elemento
            ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.personalayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personas.size
    }
    //enlazado
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imagen.setImageResource(R.drawable.baseline_person_3_24)
        holder.nombre.text=(this.personas.get(position).nombre)
    }




}