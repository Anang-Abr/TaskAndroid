package com.android.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.myapplication.databinding.ActivityPhotosBinding
import com.android.myapplication.retrofit.Api
import com.android.myapplication.retrofit.Photos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Photos : AppCompatActivity() {
    private lateinit var binding: ActivityPhotosBinding
    private val BASE_URL: String = "https://jsonplaceholder.typicode.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotosBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Log.i("HASIL RESPONSE", "COBA CONNECT")
        fetchPhoto()
    }

    private fun fetchPhoto(){
        Log.i("HASIL RESPONSE", "COBA CONNECT")
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)

        api.getPhotos().enqueue(object : Callback<List<Photos>>{
            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                if(response.isSuccessful){
                    response.body()?.let{
                        for (photo in it){
                            Log.i("HASIL RESPONSE", photo.title)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
                Log.i("HASIL RESPONSE", "GAGAL CONNECT")
            }

        })
    }
}