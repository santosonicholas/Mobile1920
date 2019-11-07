package com.github.santosonicholas.exploration


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.santosonicholas.exploration.databinding.FragmentFinishBinding
import timber.log.Timber

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
    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")
    }
    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
    }
    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }
    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy called")
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("onAttach called")
    }
    override fun onDetach() {
        super.onDetach()
        Timber.i("onDetach called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("onActivityCreated called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("onDestroyView called")
    }
}
