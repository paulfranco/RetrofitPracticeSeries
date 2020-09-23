package co.paulfran.retrofitpracticeseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.paulfran.retrofitpracticeseries.adapter.MyAdapter
import co.paulfran.retrofitpracticeseries.model.Post
import co.paulfran.retrofitpracticeseries.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //val myPost = Post(2,2, "Paul Franco", "Android X")

        viewModel.pushPost2(2, 2, "Paul Franco", "Android")
        viewModel.myResponse.observe(this, Observer {response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body().toString())
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setupRecyclerView() {
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}