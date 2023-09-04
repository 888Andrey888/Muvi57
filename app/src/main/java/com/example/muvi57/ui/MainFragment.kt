package com.example.muvi57.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.muvi57.R
import com.example.muvi57.databinding.FragmentMainBinding
import com.example.muvi57.model.MuviModel
import com.example.muvi57.presenter.MinePresenter
import com.example.muvi57.view.MineView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(), MineView {

    private lateinit var binding: FragmentMainBinding
    @Inject
    lateinit var presenter: MinePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initListener()
    }

    private fun initListener() {
        binding.btnFind.setOnClickListener {
            presenter.getMuvi(binding.etName.text.toString())
        }
    }

    override fun goToSecondFragment(muviModel: MuviModel) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment(muviModel))
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}