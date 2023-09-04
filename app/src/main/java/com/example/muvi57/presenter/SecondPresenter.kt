package com.example.muvi57.presenter

import com.example.muvi57.model.MuviModel
import com.example.muvi57.view.SecondView

class SecondPresenter(private val secondView: SecondView) {

    fun showMuviDetails(muviModel: MuviModel){
        secondView.showMuviDetails(muviModel)
    }
}