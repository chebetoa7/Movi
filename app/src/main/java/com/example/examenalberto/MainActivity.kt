package com.example.examenalberto

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenalberto.Movi.MoviAdapter
import com.example.examenalberto.Movi.MoviResponse
import com.example.examenalberto.Movi.Result_
import com.example.examenalberto.databinding.ActivityMainBinding
import com.example.examenalberto.services.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener,
androidx.appcompat.widget.SearchView.OnQueryTextListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MoviAdapter
    private val Movi = mutableListOf<Result_>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        binding.svMovies.setOnQueryTextListener(this)
    }

    private fun initRecyclerView(){
        adapter = MoviAdapter(Movi)
        binding.recyclerMV.layoutManager = LinearLayoutManager(this)
        binding.recyclerMV.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query:String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<MoviResponse> = getRetrofit().create(APIService::class.java).getMoviByBreeds("$query?api_key=266b1f1010336734c5cad16f255ca1f3&language=es-MX&page=1")
            val puppies:MoviResponse? = call.body()
            val resp = call.body()!!
            runOnUiThread {
                if(call.isSuccessful){
                    val movis_t: List<Result_> = puppies?.results ?: emptyList()
                    Movi.clear()
                    Movi.addAll(movis_t)
                    adapter.notifyDataSetChanged()

                }else{
                    showError()
                }

            }
        }
    }

    private fun showError() {
        TODO("Not yet implemented")
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

}


