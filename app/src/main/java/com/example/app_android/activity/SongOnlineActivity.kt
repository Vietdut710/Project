package com.example.app_android.activity

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_android.R
import com.example.app_android.obj.ApiClient
import com.example.app_android.obj.SongOnline
import com.example.app_android.adapter.SongOnlineAdapter
import com.example.app_android.role.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SongOnlineActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var SongOnline: List<SongOnline>
    lateinit var adapter: SongOnlineAdapter
    lateinit var apiInterface: ApiInterface
    lateinit var progressBar: ProgressBar
    lateinit var search: TextView
    lateinit var item: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songon)
        progressBar = findViewById(R.id.prograss)
        recyclerView = findViewById(R.id.songon_recyclerView)
        layoutManager = LinearLayoutManager(this@SongOnlineActivity)

        recyclerView.layoutManager = layoutManager
        recyclerView.setHasTransientState(true)
        fetchContact("song", "")
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    fun fetchContact(type: String?, key: String?) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        val call = apiInterface.getSong(type, key)
        call?.enqueue(object : Callback<List<SongOnline?>?> {
            override fun onResponse(
                    call: Call<List<SongOnline?>?>,
                    response: Response<List<SongOnline?>?>
            ) {
                progressBar.visibility = View.GONE
                SongOnline = response.body() as List<SongOnline>
                adapter = SongOnlineAdapter(SongOnline, this@SongOnlineActivity)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<SongOnline?>?>, t: Throwable) {
                progressBar.visibility = View.GONE
                Toast.makeText(this@SongOnlineActivity, "Error\n$t", Toast.LENGTH_LONG).show()
            }


        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(componentName)
        )
        searchView.isIconfiedByDefault
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                fetchContact("song", query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                fetchContact("song", newText)
                return false
            }
        })
        return true
    }
}