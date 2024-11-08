package com.pasantiago.agenda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Listado : AppCompatActivity() {
    private lateinit var  personas:ArrayList<Persona>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(findViewById(R.id.toolbarlistado))
        personas=intent.getParcelableArrayListExtra<Persona>("personas")!!
        var adapter = PersonaAdaptador(personas)
        var recyclerView = findViewById<RecyclerView>(R.id.listado)
        var grid= GridLayoutManager(this,2)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager=layoutManager
        //se enlaza con el adaptador
        recyclerView.adapter = adapter


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemVolver -> {


                finish()
                true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }
}