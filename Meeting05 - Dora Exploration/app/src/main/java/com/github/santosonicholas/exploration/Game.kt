package com.github.santosonicholas.exploration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.santosonicholas.exploration.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class Game : Fragment() {

    private val scenes = MyApplication.scenes
    lateinit var currentScene: MyApplication.Scene
    private var selectedActionId: Int = 0
    private var kayaRelationship = 0
    private var leonRelationship = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false)

        // This is IMPORTANT! without this, "@{}" things in [fragment_game.sml] won't work.
        currentScene = scenes[0]


        // Bind this fragment class to the layout
        binding.scene = this

        // Listener for action button
        binding.actionButton.setOnClickListener {

            if(binding.actions.checkedRadioButtonId != -1) {

                when (binding.actions.checkedRadioButtonId) {
                    binding.actionOne.id -> selectedActionId = 0
                    binding.actionTwo.id -> selectedActionId = 1
                    binding.actionThree.id -> selectedActionId = 2
                }

                when (currentScene) {
                    scenes[0] ->//intro
                        when(selectedActionId) {
                            0 -> currentScene = scenes[1]
                            1 -> currentScene = scenes[2]
                            2 -> currentScene = scenes[3]
                        }
                    scenes[1] -> //carpet
                        when(selectedActionId){
                            0 -> currentScene = scenes[4]
                            1 -> currentScene = scenes[5]
                            2 -> currentScene = scenes[15]

                        }

                    scenes[2] -> { //flower pot
                        when(selectedActionId) {
                            0 -> currentScene = scenes[0]
                            1 -> currentScene = scenes[14]
                        }
                    }
                    scenes[3] -> { // window
                        when(selectedActionId) {
                            0 -> currentScene = scenes[0]
                            1 -> currentScene = scenes[14]
                        }
                    }
                    scenes[4] -> {//couch
                        when(selectedActionId) {
                            0 -> currentScene = scenes[7]
                            1 -> currentScene = scenes[6]
                            2 -> currentScene = scenes[8]
                        }
                    }
                    scenes[5] -> { // leave key
                        ending()
                    }
                    scenes[6] -> { // Strong Enough On My Own
                        when(selectedActionId) {
                            0 -> currentScene = scenes[0]
                            1 -> currentScene = scenes[14]
                        }
                    }
                    scenes[7] -> {//bed
                        when(selectedActionId){
                            0 -> currentScene = scenes[9]
                            1 -> currentScene = scenes[10]
                        }
                    }
                    scenes[8] -> {
                        when(selectedActionId) { //door not locked
                            0 -> currentScene = scenes[0]
                            1 -> currentScene = scenes[14]
                        }
                    }
                    scenes[9] -> { //safe key
                        when(selectedActionId) { // Heroic Comeuppance!
                            0 -> currentScene = scenes[11]
                            1 -> currentScene = scenes[12]
                            2 -> currentScene = scenes[13]
                        }
                    }
                    scenes[10] -> { // behind wardrobe
                        MyApplication.badEnding = true
                        ending()
                    }
                    scenes[11] -> { //found deposit box key
                        MyApplication.normalEnding = true
                        ending()
                    }
                    scenes[12] -> { // in the wardrobe
                        MyApplication.bestEnding = true
                        ending()
                    }
                    scenes[13] -> { // leave it
                        ending()
                    }
                    scenes[14] -> { //end
                        ending()
                    }
                    scenes[15] -> { //end
                        ending()
                    }
                }

                if (currentScene.actions[0] == "") binding.actionOne.isEnabled = false else binding.actionOne.isEnabled = true
                if (currentScene.actions[1] == "") binding.actionTwo.isEnabled = false else binding.actionTwo.isEnabled = true
                if (currentScene.actions[2] == "") binding.actionThree.isEnabled = false else binding.actionThree.isEnabled = true


                binding.actions.clearCheck()
                binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.invalidateAll()

            } else {
                Toast.makeText(this.activity, "Select one of the options!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun ending() {
        when(selectedActionId) {
            0 -> this.activity!!.onBackPressed()
            1 -> currentScene = scenes[0]
        }
    }

}
