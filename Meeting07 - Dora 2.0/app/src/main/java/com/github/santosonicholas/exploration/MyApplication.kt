package com.github.santosonicholas.exploration


import android.app.Application
import timber.log.Timber

class MyApplication: Application() {

    data class Scene(
        val title: String,
        val body: String,
        val actions: List<String>
    )

    companion object {
        //
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"




        val scenes: List<Scene> = listOf (
            // 0
            Scene (
                "Introduction",
                "Emma wants to open her safe deposit box because she want to put some money inside of it, she needs the safe deposit box key at her bedroom, " +
                        "but first she need to find her house key, After she get the house key, she must find her room key to enter her room. The story started" +
                        "when Emma got arrived at her house, Emma walks into her front of her House where do you think the key is located?",
                actions = listOf (
                    "Below WELCOME carpet",
                    "Beside the flower pot",
                    "Right between the Window"
                )
            ),
            // 1
            Scene (
                "The Carpet",
                "The Carpet looks dirty, she must clean the dirt first, Uhhm, after she clean the dirt she finnaly got the key, but she dont know what key it is",
                actions = listOf (
                    "Take the key",
                    "Leave the key",
                    "Throw the key away"

                )
            ),

            // 2
            Scene (
                "Flower Pot",
                "Uhmm, the flower is colorful and good smell, but wait you will not getting distracted by the flower" +
                        "you need to find the key first, You move the flower pot and you found nothing, You only found pile of garbage, You want to try to search another place?",
                actions = listOf (
                    "Yes",
                    "No",
                    ""
                )
            ),

            // 3
            Scene (
                "Between the Window",
                "This place is not quite good for hiding the key, i think you need to find at another place, want to try ?",
                actions = listOf (
                    "Yes",
                    "No",
                    ""
                )
            ),

            // 4
            Scene (
                "House Key",
                "After she took the key, she try to put the key to the door, finnaly the door is open. She get in the house and she see her dog Luna is laying down beside the couch" +
                        "See pet Luna and give Luna some food, After that, she wants to find her bedroom key, Where do you think is her bedroom key located?",
                actions = listOf (
                    "Below the couch near her room",
                    "Above the bookshelf in the living room",
                    "The door is not locked"
                )
            ),

            // 5
            Scene (
                "Leave the Key",
                "Why you leave the key, you should try to pick up the key! You failed the mission to find Emma safe deposit box key!",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN,
                    ""

                )
            ),

            // 6
            Scene (
                "Bookshelf",
                "This place is for rat house, this place is not quite right, you need to try again to find the key, Try Again?",
                actions = listOf (
                    "Yes",
                    "No",
                    ""
                )
            ),

            // 7
            Scene (
                "Bedroom Key",
                "Yeah, the key was located in below the coach, finally she get her beedroom key, she put in the key to her bedroom door" +
                        "the door is open and she forget where is her safe deposit box, Where is Emma's safe deposit box?",
                actions = listOf (
                    "Below the bed",
                    "Behind the wardrobe",
                    ""

                )
            ),

            // 8
            Scene (
                "The Beedroom door is not locked",
                "Oops, the door is locked by the way, all the door is locked because Emma have bad memory about thief, You want to try again to find the key?",
                actions = listOf (
                    "Yes",
                    "No",
                    ""
                )
            ),

            // 9
            Scene (
                "Safe Deposit Box",
                "Wow, she remember where the safe deposit box now, its located under her bed, yeah, she is quite old now , she forget everything" +
                        "last job to do, she need to find her safe deposit box key, help Emma for the last time, where do you think is her safe deposit box key located?",
                actions = listOf (
                    "Below the safe deposit box itself",
                    "In the wardrobe",
                    "Leave it"
                )
            ),

            // 10
            Scene (
                "Behind the wardrobe",
                "Woah, you find the nest of wasp, you need to clean up, aaaaaah the sting is deadly, you are dead right now because the sting",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN,
                    ""

                )
            ),

            // 11
            Scene (
                "You Found the Safe Deposit Box Key",
                "Yeay You Found the Key, now you can put something inside the safe deposit box, thanks for helping Emma to find her safe deposit box key!",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN,
                    ""
                )
            ),

            // 12
            Scene (
                "In The Wardrobe",
                "You found the MASTER KEY that open everything in Emma House, Now you can open all key stuff in this house, this is the key that Emma looking for" +
                        "the long time, and now Emma can put something in the safe deposit box, thank you!",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    ""
                )
            ),

            // 13
            Scene (
                "You Leave Closest Chance",
                "Why you leave the mission? The mission is almost complete, why would you do that?",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    ""
                )
            ),

            // 14
            Scene (
                "Why you Dont Try ?",
                "You fail the mission to find Emma safe deposit box key",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    ""
                )
            ),

            // 15
            Scene (
                "You Throw the Key",
                "Why You Throw the Key? You should try the key first, poor you!",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    ""
                )
            )

        )

        var badEnding = false
        var normalEnding = false
        var bestEnding = false

        lateinit var currentDisplayedEnding: Scene
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}