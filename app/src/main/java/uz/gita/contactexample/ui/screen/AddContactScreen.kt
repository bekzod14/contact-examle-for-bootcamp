package uz.gita.contactexample.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uz.gita.contactexample.R
import uz.gita.contactexample.presenter.AddContactViewModel
import uz.gita.contactexample.presenter.impl.AddContactViewModelImpl
import uz.gita.contactexample.utils.selectOrUnselect

class AddContactScreen : Fragment(R.layout.screen_add_contact){
    private val viewModel : AddContactViewModel by viewModels<AddContactViewModelImpl>()
    private val navController by lazy { findNavController() }
    private lateinit var inputName :EditText
    private lateinit var inputPhone :EditText
    private lateinit var imgMan : ImageView
    private lateinit var imgWoman : ImageView
    private lateinit var btnSave : Button
    private lateinit var btnBack : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.backLiveData.observe(this){
            navController.navigateUp()
        }

        viewModel.messageLiveData.observe(this) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        init(view)

        subscribeDataObservers()

        clickButtons()
    }

    private fun clickButtons() {
        btnBack.setOnClickListener{
            viewModel.back()
        }

        btnSave.setOnClickListener {
            viewModel.saveContact(inputName.text.toString(), inputPhone.text.toString())
        }

        imgMan.setOnClickListener {
            viewModel.selectManImg()
        }

        imgWoman.setOnClickListener {
            viewModel.selectWomanImg()
        }
    }

    private fun subscribeDataObservers() {
        viewModel.manImgLiveData.observe(viewLifecycleOwner) {
            imgMan.selectOrUnselect(it)
        }

        viewModel.woManImgLiveData.observe(viewLifecycleOwner) {
            imgWoman.selectOrUnselect(it)
        }
    }

    private fun init(view: View) {
        view.apply {
            inputName = findViewById(R.id.input_name)
            inputPhone = findViewById(R.id.input_phone)
            imgMan = findViewById(R.id.img_man)
            imgWoman = findViewById(R.id.img_woman)
            btnSave = findViewById(R.id.btn_save)
            btnBack = findViewById(R.id.btn_back)
        }

    }


}