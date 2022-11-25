package com.example.myapplication.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.common.fragment.navigateToFragment
import com.example.myapplication.databinding.FragmentAuthorizationBinding
import com.example.myapplication.notes.FragmentNotes

private const val INPUT_ERROR = "Неверные данные"

class FragmentAuthorization : Fragment() {

    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signIn.setOnClickListener {
            if (binding.enterLogin.text.toString() == ""
                &&
                binding.enterPassword.text.toString() == ""
            ) {
                navigateToFragment(FragmentNotes())
            } else {
                Toast.makeText(activity, INPUT_ERROR, Toast.LENGTH_LONG).show()
            }
        }
    }
}