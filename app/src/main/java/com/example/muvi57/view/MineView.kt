package com.example.muvi57.view

import com.example.muvi57.model.MuviModel

interface MineView {

    fun goToSecondFragment(muviModel: MuviModel)
    fun showError(message: String)

}