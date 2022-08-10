package uz.gita.contactexample.ui.screen

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.gita.contactexample.R
import uz.gita.contactexample.presenter.InfoViewModel
import uz.gita.contactexample.presenter.impl.InfoViewModelImpl


class InfoScreen:Fragment(R.layout.screen_info) {

    private val viewModel:InfoViewModel by viewModels<InfoViewModelImpl>()
    private lateinit var back_btn:ImageButton
    private val navController by lazy { findNavController() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.backLiveData.observe(this){
            navController.navigateUp()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadView(view)

        back_btn.setOnClickListener {
            viewModel.back()
        }


    }

    private fun loadView(view: View) {
        view.apply {
            back_btn = findViewById(R.id.btn_back)
        }
    }
}