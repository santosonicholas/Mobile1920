package com.github.santosonicholas.exploration


import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.santosonicholas.exploration.databinding.FragmentMainMenuBinding

/**
 * A simple [Fragment] subclass.
 */
class MainMenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding = DataBindingUtil.inflate<FragmentMainMenuBinding>(inflater, R.layout.fragment_main_menu,container, false)

        binding.startButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_mainMenu_to_game)
        }

        return binding.root
    }


}
