package com.example.drwetube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.drwetube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            toggle= ActionBarDrawerToggle(this@MainActivity,drawitthelayoutway,R.string.open,R.string.close)
            drawitthelayoutway.addDrawerListener(toggle)
            toggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navview.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.news->{
                        Toast.makeText(this@MainActivity, "news has been selected", Toast.LENGTH_SHORT).show()

                    }
                    R.id.contacts->{
                        Toast.makeText(this@MainActivity, "contacts has been selected", Toast.LENGTH_SHORT).show()

                    }
                    R.id.home->{
                        Toast.makeText(this@MainActivity, "home has been selected", Toast.LENGTH_SHORT).show()

                    }

                    R.id.message->{
                        Toast.makeText(this@MainActivity, "message has been selected", Toast.LENGTH_SHORT).show()
                    }
                    R.id.quiz->{
                        Toast.makeText(this@MainActivity, "quiz has been selected", Toast.LENGTH_SHORT).show()
                    }

                }
                true
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }
}