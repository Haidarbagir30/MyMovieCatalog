package com.learning.mymoviecatalog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ContactActivity
import com.ListMovieAdapter
import com.Movie

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies= findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()

        val contact : ImageView =findViewById(R.id.contact_1)
        contact.setOnClickListener{
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvMovies.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvMovies.layoutManager = GridLayoutManager(this, 2)
            }
//            R.id.contact_person -> {
//                val contact = findViewById<TextView>(R.id.contact_person)
//                contact.setOnClickListener{
//                    val intent = Intent(this,ContactActivity::class.java)
//                    startActivity(intent)
//                }
//            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListMovies(): ArrayList<Movie> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMovie = ArrayList<Movie>()
        for (i in dataName.indices) {
            val Movie = Movie(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listMovie.add(Movie)
        }
        return listMovie
    }

    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListMovieAdapter(list)
        rvMovies.adapter = listHeroAdapter
}
}