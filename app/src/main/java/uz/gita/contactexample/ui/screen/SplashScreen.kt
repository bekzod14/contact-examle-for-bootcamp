package uz.gita.contactexample.ui.screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.gita.contactexample.R
import uz.gita.contactexample.presenter.SplashViewModel
import uz.gita.contactexample.presenter.impl.SplashViewModelImpl

// Created by Jamshid Isoqov an 8/9/2022
class SplashScreen : Fragment(R.layout.screen_splash) {

    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    private val navController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openMainScreenLiveData.observe(this) {
            navController.navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
        }
    }
}