package com.github.santosonicholas.exploration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.santosonicholas.exploration.databinding.FragmentFinishDisplayBinding


/**
 * A simple [Fragment] subclass.
 */
class FinishDisplay : Fragment() {

    val currentEnding: MyApplication.Scene = MyApplication.currentDisplayedEnding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFinishDisplayBinding>(inflater,
            R.layout.fragment_finish_display, container, false)

        binding.endingDisplay = this

        return binding.root

    }
}
