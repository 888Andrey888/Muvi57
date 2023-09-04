package com.example.muvi57.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.muvi57.R
import com.example.muvi57.databinding.FragmentSecondBinding
import com.example.muvi57.model.MuviModel
import com.example.muvi57.presenter.SecondPresenter
import com.example.muvi57.view.SecondView

class SecondFragment : Fragment(), SecondView {

    private lateinit var binding: FragmentSecondBinding
    private val secondPresenter = SecondPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        arguments?.let {
            val navArgs = SecondFragmentArgs.fromBundle(it)
            secondPresenter.showMuviDetails(navArgs.muviModel)
        }
    }

    override fun showMuviDetails(muviModel: MuviModel) {
        with(binding) {
            ivPoster.load(muviModel.Poster)
            tvTitle.text = muviModel.Title
            tvYear.text = muviModel.Year
            tvGenre.text = muviModel.Genre
            tvAwards.text = muviModel.Awards
            muviModel.Ratings.forEach {
                tvRating.append("Source: ${it.Source}\n Value: ${it.Value}\n\n")
            }
        }
    }
}