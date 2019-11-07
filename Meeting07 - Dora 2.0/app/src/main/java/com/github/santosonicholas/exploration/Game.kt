package com.github.santosonicholas.exploration


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.santosonicholas.exploration.databinding.FragmentGameBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class Game : Fragment() {

    private val scenes = MyApplication.scenes
    lateinit var currentScene: MyApplication.Scene
    private var selectedActionId: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false)

        // This is IMPORTANT! without this, "@{}" things in [fragment_game.sml] won't work.
        currentScene = scenes[0]

        val gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        binding.gameViewModel = gameViewModel

        binding.lifecycleOwner = this

        // Bind this fragment class to the layout
        gameViewModel.goToMainMenu.observe(this, Observer { yes ->
            if (yes) goToMainMenu()
        })

        binding.invalidateAll()
        return binding.root
    }



    private fun goToMainMenu() {
        this.activity!!.onBackPressed()
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
