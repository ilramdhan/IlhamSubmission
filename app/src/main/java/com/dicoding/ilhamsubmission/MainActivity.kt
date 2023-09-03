package com.dicoding.ilhamsubmission

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvGames: RecyclerView
    private val list = ArrayList<Game>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGames = findViewById(R.id.rv_games)
        rvGames.setHasFixedSize(true)

        list.addAll(getListGames())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListGames(): ArrayList<Game> {
        val dataName = resources.getStringArray(R.array.data_game)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listGame = ArrayList<Game>()
        for (i in dataName.indices) {
            val game = Game(dataName[i], dataDesc[i], dataPhoto.getResourceId(i, -1))
            listGame.add(game)
        }
        return listGame
    }

    private fun showRecyclerList() {
        rvGames.layoutManager = LinearLayoutManager(this)
        val listGameAdapter = ListGameAdapter(list)
        rvGames.adapter = listGameAdapter

        listGameAdapter.setOnItemClickCallback(object : ListGameAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Game) {
                val intent = Intent(this@MainActivity, DetailGameActivity::class.java)
                intent.putExtra("key_game", data)
                startActivity(intent)
            }
        })

    }

}