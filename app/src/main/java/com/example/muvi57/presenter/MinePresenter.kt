package com.example.muvi57.presenter

import com.example.muvi57.model.MuviApi
import com.example.muvi57.model.MuviModel
import com.example.muvi57.view.MineView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MinePresenter @Inject constructor(private val muviApi: MuviApi) {

    private lateinit var mineView: MineView

    fun getMuvi(name: String){
        muviApi.getMuvi(name).enqueue(object : Callback<MuviModel>{
            override fun onResponse(call: Call<MuviModel>, response: Response<MuviModel>) {
                response.body()?.let {
                    mineView.goToSecondFragment(it)
                }
            }

            override fun onFailure(call: Call<MuviModel>, t: Throwable) {
                mineView.showError(t.message.toString())
            }

        })
    }

    fun attachView(mineView: MineView){
        this.mineView = mineView
    }
}