package com.pasantiago.agenda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        val intent = it.data
        Log.d("Devolucion resultado", it.resultCode.toString())

        it.data?.getParcelableExtra<Persona>("persona").let {
            if (it != null) {
                personas.add(it)
            }
        }
    }
    private var personas: ArrayList<Persona> = arrayListOf<Persona>(
        Persona("Jhon", "Nieve", "3434", "castillonegro@elmuro.in"),
        Persona("Daenerys", "Targaryen", "1113434", "madrededragones@rocadragon.dk"),
        Persona("Rey", "de la Noche", "16534", "elmalo@mashalladelmuro.mhm"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(findViewById(R.id.toolbar))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(com.pasantiago.agenda.R.menu.menu, menu);

        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemNuevo -> {
                launcher.launch(Intent(this, Alta::class.java))
                true
            }

            R.id.itemListado -> {
                val intent = Intent(this, Listado::class.java)
                intent.putParcelableArrayListExtra("personas", personas)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}