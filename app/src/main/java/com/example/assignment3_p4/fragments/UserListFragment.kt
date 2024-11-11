package com.example.assignment3_p4.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assignment3_p4.R
import com.example.assignment3_p4.viewmodel.UserViewModel

class UserListFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)
        val textView = view.findViewById<TextView>(R.id.user_list_text)
        val editText = view.findViewById<EditText>(R.id.user_input)
        val addButton = view.findViewById<Button>(R.id.add_user_button)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.users.observe(viewLifecycleOwner) { users ->
            textView.text = users.joinToString(", ")
        }
//        userViewModel.inputText.observe(viewLifecycleOwner) { text ->
//            editText.setText(text)
//        }
//        addButton.setOnClickListener {
//            userViewModel.addUser()
//        }
//        editText.addTextChangedListener { text ->
//            userViewModel.updateInputText(text.toString())
//        }
        addButton.setOnClickListener {
            val name = editText.text.toString()
            if (name.isNotBlank()) {
                userViewModel.addUser(name)
                editText.text.clear()
            }
        }


        return view
    }
}
