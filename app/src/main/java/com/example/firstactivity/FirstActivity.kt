package com.example.firstactivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
//            val intent = Intent("com.example.firstactivity.ACTION_START")
//            intent.addCategory("com.example.firstactivity.MY_CATEGORY")
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
            var intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 -> if(resultCode == RESULT_OK) {
                val rt =  data?.getStringExtra("return_data");
                Log.i(this.javaClass.name, rt ?: "NULL")
            }
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