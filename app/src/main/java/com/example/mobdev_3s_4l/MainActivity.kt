package com.example.mobdev_3s_4l

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val colorList = ArrayList(arrayListOf(
            ColorData("Black", 0xFF000000),
            ColorData("Blue", 0xFF0000FF),
            ColorData("Lime", 0xFF00FF00),
            ColorData("Aqua", 0xFF00FFFF),
            ColorData("Navy", 0xFF000080),
            ColorData("Green", 0xFF008000),
            ColorData("Teal", 0xFF008080),
            ColorData("Maroon", 0xFF800000),
            ColorData("Purple", 0xFF800080),
            ColorData("Still Olive", 0xFF808000),
            ColorData("Grey", 0xFF808080),
            ColorData("Silver", 0xFFC0C0C0),
            ColorData("Red", 0xFFFF0000),
            ColorData("Fuchsia", 0xFFFF00FF),
            ColorData("Yellow", 0xFFFFFF00),
            ColorData("White", 0xFFFFFFFF),
            ColorData("Orange", 0xFFFFA500),
        ).shuffled())

        adapter = Adapter(this, colorList)
        recyclerView.adapter = adapter
    }
}

data class ColorData(
    var colorName: String,
    var colorHex: Long,
)