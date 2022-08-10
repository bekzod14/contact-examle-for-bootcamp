package uz.gita.contactexample.ui.screen

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.contactexample.R
import uz.gita.contactexample.adapter.ContactAdapter
import uz.gita.contactexample.presenter.MainViewModel
import uz.gita.contactexample.presenter.impl.MainViewModelImpl

class MainScreen : Fragment(R.layout.screen_main) {

    private lateinit var list: RecyclerView
    private lateinit var btnAdd: FloatingActionButton
    private lateinit var btnInfo: ImageView
    val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private val adapter: ContactAdapter by lazy { ContactAdapter() }
    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewModel.openAddContactLiveData.observe(this) {
            navController.navigate(MainScreenDirections.actionMainScreenToAddContactScreen())
        }

        viewModel.openInfoLiveData.observe(this) {
           navController.navigate(MainScreenDirections.actionMainScreenToInfoScreen())
        }

        viewModel.openEditLiveData.observe(this) {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list = view.findViewById(R.id.listContact)
        btnAdd = view.findViewById(R.id.btnAdd)
        btnInfo = view.findViewById(R.id.btnInfo)

        list.layoutManager = LinearLayoutManager(requireContext())
        list.adapter = adapter

        btnAdd.setOnClickListener {
            viewModel.openAddContactScreen()
        }
        btnInfo.setOnClickListener {
            viewModel.openInfoScreen()
        }

        viewModel.contactListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        adapter.setOnDeleteListener {
            viewModel.deleteContact(it)
        }
        adapter.setOnEditListener {
            viewModel.openEditContactScreen(it)
        }

    }
}