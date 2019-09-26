package com.github.santosonicholas.exploration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.santosonicholas.exploration.databinding.FragmentFinishBinding

/**
 * A simple [Fragment] subclass.
 */
class Finish : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFinishBinding>(inflater,
            R.layout.fragment_finish, container, false)

        binding.badEndingButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[10]
            it.findNavController().navigate(R.id.action_finish_to_finishDisplay)

        }
        binding.normalEndingButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[11]
            it.findNavController().navigate(R.id.action_finish_to_finishDisplay)
        }

        binding.bestEndingButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[12]
            it.findNavController().navigate(R.id.action_finish_to_finishDisplay)
        }

        // Enabling/disabling buttons
        if (MyApplication.badEnding) binding.badEndingButton.isEnabled = true
        if (MyApplication.normalEnding) binding.normalEndingButton.isEnabled = true
        if (MyApplication.bestEnding) binding.bestEndingButton.isEnabled = true

        return binding.root
    }
}
