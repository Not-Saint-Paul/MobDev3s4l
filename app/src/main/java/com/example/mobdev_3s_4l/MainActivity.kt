package com.example.mobdev_3s_4l

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    val okHttpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tag = "Filckr cats"
        val tagOkHttp = "Filckr OkCats"
        val btnHTTP = findViewById<Button>(R.id.btnHTTP)
        val btnOkHTTP = findViewById<Button>(R.id.btnOkHTTP)

        btnHTTP.setOnClickListener{
            val link = URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")
            Thread {
                val connection = link.openConnection() as HttpURLConnection
                connection.connect()
                val data = connection.inputStream.bufferedReader().readText()
                connection.disconnect()
                Log.d(tag, data)
            }.start()
        }

        btnOkHTTP.setOnClickListener{
            Thread {
                val link = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1"
                val request = Request.Builder().url(link).build()
                val data = okHttpClient.newCall(request).execute().body?.string()
                Log.i(tagOkHttp, "$data")
            }.start()
        }
    }
}