package com.uas.mymanga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.uas.mymanga.Adapter.Adapter
import com.uas.mymanga.Model.Model
import com.example.mymanga.R
import com.uas.mymanga.api.ApiRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MangaActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var mangaAdapter: Adapter
    private lateinit var listManga : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga)
        setupList()
    }

    private fun setupList(){
        listManga = findViewById(R.id.list_manga)
        mangaAdapter = Adapter(arrayListOf())
        listManga.adapter = mangaAdapter
    }

    override fun onStart() {
        super.onStart()
        getManga()
    }

    private fun getManga(){
        api.data().enqueue(object : Callback<Model> {
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("daftar_hadir",t.toString())
            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.mangaplus
                    mangaAdapter.setData( listData )
//                    listData.forEach {
//                        Log.e("daftar_hadir","nama ${it.nama}")
//                    }
                }
            }

        })
    }
}