package com.pasantiago.agenda

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Alta : AppCompatActivity() {
    private lateinit var  personas:ArrayList<Persona>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alta)

       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        setSupportActionBar(findViewById(R.id.toolbar2))

        findViewById<Button>(R.id.buttonEnviar).setOnClickListener {
            val returnIntent = Intent()

            var persona=Persona(findViewById<EditText>(R.id.editTextNombre).text.toString(),"fsfsdf","dfdfs","dfdf")
            returnIntent.putExtra("persona",persona)
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.volver, menu);

        return true;
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