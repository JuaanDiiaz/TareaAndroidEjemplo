package com.example.miprimerappandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.miprimerappandroid.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    val miTag:String = "udelp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id:Int = intent.getIntExtra("Id",0)
        val name:String? = intent.getStringExtra("Name")

        Toast.makeText(this@SecondActivity,"${id} ${name}", Toast.LENGTH_SHORT).show()
        binding.btnUrl.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW).apply { data= Uri.parse("http://itcarecfdi.ddns.net:8096") }
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity,"no hay navegador disponible", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnMapa.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW).apply { data= Uri.parse("geo:19.28958619366017,-99.13938537622406?z=21 &q=19.28958619366017,-99.13938537622406") }
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity,"no hay mapa disponible", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnLlamada.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL).apply { data= Uri.parse("tel:5532499504") }
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity,"no hay aplicacion para llmadas disponible", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnEmail.setOnClickListener {

            val emails = arrayOf("minijorda22@gmail.com")
            var intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL,emails)
                putExtra(Intent.EXTRA_SUBJECT,"Correo juancho")
                putExtra(Intent.EXTRA_TEXT,"Hola mundo desde android")
            }
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this@SecondActivity,"no hay aplicacion para llmadas disponible", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(miTag,"estoy en onStart -SECOND")
    }

    override fun onResume() {
        super.onResume()
        Log.d(miTag,"estoy en onResume -SECOND")
    }

    override fun onPause() {
        super.onPause()
        Log.d(miTag,"estoy en onPause -SECOND")
    }

    override fun onStop() {
        super.onStop()
        Log.d(miTag,"estoy en onStop -SECOND")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(miTag,"estoy en onRestart -SECOND")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(miTag,"estoy en onDestroy -SECOND")
    }
}