package uz.gita.contactexample.ui.screen

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.contactexample.R
import uz.gita.contactexample.presenter.MainViewModel
import uz.gita.contactexample.presenter.impl.MainViewModelImpl

class MainScreen:Fragment(R.layout.screen_main) {
val viewModel:MainViewModel by viewModels<MainViewModelImpl>()
   private lateinit var list:RecyclerView
   private lateinit var btnAdd:FloatingActionButton
   private lateinit var btnInfo:ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list=view.findViewById(R.id.listContact)
        btnAdd=view.findViewById(R.id.btnAdd)
        btnInfo=view.findViewById(R.id.btnInfo)


    }

}