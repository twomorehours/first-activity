package com.example.firstactivity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        val btn: Button = findViewById(R.id.button1)
        btn.setOnClickListener {
//            Toast.makeText(this, "btn1 pressed", Toast.LENGTH_SHORT).show()
//            finish()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.add_item -> Toast.makeText(this, "click add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "click remove", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}