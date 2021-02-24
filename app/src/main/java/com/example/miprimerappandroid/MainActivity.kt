package com.example.miprimerappandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.miprimerappandroid.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    val miTag:String = "udelp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonAceptar.setOnClickListener {
            Log.d("boton","nos vamos")
            val i = Intent(this@MainActivity,SecondActivity::class.java).apply {
                putExtra("Id",23)
                putExtra("Name","Juancho")
            }
            startActivity(i)
        }

        binding.buttonToast.setOnClickListener {
            Toast.makeText(this@MainActivity,"esto es un ejemplo de mensaje Toast",Toast.LENGTH_LONG).show()
        }
        binding.buttonSnackbar.setOnClickListener {
            Snackbar.make(it,"esto es un ejemplo de mensaje Snackbar", Snackbar.LENGTH_SHORT).show()
        }
        binding.buttonDialog.setOnClickListener {
            miDialogo().show()
        }
        binding.fabMiBoton.setOnClickListener{
            Toast.makeText(this@MainActivity,"Botón flotante",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(miTag,"estoy en onStart -HOME")
    }

    override fun onResume() {
        super.onResume()
        Log.d(miTag,"estoy en onResume -HOME")
    }

    override fun onPause() {
        super.onPause()
        Log.d(miTag,"estoy en onPause -HOME")
    }

    override fun onStop() {
        super.onStop()
        Log.d(miTag,"estoy en onStop -HOME")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(miTag,"estoy en onRestart -HOME")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(miTag,"estoy en onDestroy -HOME")
    }
    
    private fun miDialogo():AlertDialog{
        val miAlerta = AlertDialog.Builder(this@MainActivity)

        miAlerta.setTitle("Titulo del dialogo")
        miAlerta.setMessage("mensaje del dialogo")
        miAlerta.setPositiveButton("Simon"){_,_ ->
            Toast.makeText(this@MainActivity,"Click afirmativo",Toast.LENGTH_SHORT).show()
        }
        miAlerta.setNegativeButton("Nel"){_,_ ->
            Toast.makeText(this@MainActivity,"Click negativo",Toast.LENGTH_SHORT).show()
        }
        return miAlerta.create()
    }
}