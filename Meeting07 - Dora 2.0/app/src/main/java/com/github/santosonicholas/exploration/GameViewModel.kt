package com.github.santosonicholas.exploration

import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.santosonicholas.exploration.MyApplication.Companion.scenes

class GameViewModel : ViewModel() {
    private var _scene = MutableLiveData<MyApplication.Scene>()
    val scene: LiveData<MyApplication.Scene>
        get() = _scene

    private var _goToMainMenu = MutableLiveData<Boolean>()
    val goToMainMenu:LiveData<Boolean>
        get() = _goToMainMenu

    val scenes = MyApplication.scenes

    private var selectedActionId: Int = 0

    init{
        _scene.value = scenes[0]
        _goToMainMenu.value = false
    }

    fun onAction(actions: RadioGroup, opt1: RadioButton, opt2: RadioButton, opt3: RadioButton, opt4: RadioButton, scrollView: ScrollView){
        val checkedRadioButtonId = actions.checkedRadioButtonId

        when (checkedRadioButtonId) {
            opt1.id-> selectedActionId = 0
            opt2.id-> selectedActionId = 1
            opt3.id -> selectedActionId = 2
        }

        if(checkedRadioButtonId != -1) {
            when (checkedRadioButtonId) {
                opt1.id-> selectedActionId = 0
                opt2.id-> selectedActionId = 1
                opt3.id -> selectedActionId = 2
            }

            when (_scene.value) {
                scenes[0] ->//intro
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[1]
                        1 -> _scene.value = scenes[2]
                        2 -> _scene.value = scenes[3]
                    }
                scenes[1] -> //carpet
                    when(selectedActionId){
                        0 -> _scene.value = scenes[4]
                        1 -> _scene.value = scenes[5]
                        2 -> _scene.value = scenes[15]

                    }

                scenes[2] -> { //flower pot
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[0]
                        1 -> _scene.value = scenes[14]
                    }
                }
                scenes[3] -> { // window
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[0]
                        1 -> _scene.value = scenes[14]
                    }
                }
                scenes[4] -> {//couch
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[7]
                        1 -> _scene.value = scenes[6]
                        2 -> _scene.value = scenes[8]
                    }
                }
                scenes[5] -> { // leave key
                    ending()
                }
                scenes[6] -> { // Strong Enough On My Own
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[0]
                        1 -> _scene.value = scenes[14]
                    }
                }
                scenes[7] -> {//bed
                    when(selectedActionId){
                        0 -> _scene.value = scenes[9]
                        1 -> _scene.value = scenes[10]
                    }
                }
                scenes[8] -> {
                    when(selectedActionId) { //door not locked
                        0 -> _scene.value = scenes[0]
                        1 -> _scene.value = scenes[14]
                    }
                }
                scenes[9] -> { //safe key
                    when(selectedActionId) { // Heroic Comeuppance!
                        0 -> _scene.value = scenes[11]
                        1 -> _scene.value = scenes[12]
                        2 -> _scene.value = scenes[13]
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

            if (_scene.value.actions[0] == "") opt1.isEnabled = false else opt1.isEnabled = true
            if (_scene.value.actions[1] == "") opt2.isEnabled = false else opt2.isEnabled = true
            if (_scene.value.actions[2] == "") opt3.isEnabled = false else opt3.isEnabled = true


            actions.clearCheck()
            scrollView.fullScroll(ScrollView.FOCUS_UP)


            } else {
                Toast.makeText(_goToMainMenu.value, "Select one of the options!", Toast.LENGTH_SHORT).show()
            }

    }
    private fun ending() {
        when(selectedActionId) {
            0 -> _goToMainMenu.value = true
            1 -> _scene.value = MyApplication.scenes[0]
        }
    }

    }



}