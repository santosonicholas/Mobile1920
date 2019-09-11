package com.github.santosonicholas.lorremgenerator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.github.santosonicholas.lorremgenerator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val cupcakeIpsum: MyData = MyData("Cupcake Ipsum","Cupcake ipsum dolor sit. Amet I love liquorice jujubes pudding croissant I love pudding. Apple pie macaroon toffee jujubes pie tart cookie applicake caramels. Halvah macaroon I love lollipop. Wypas I love pudding brownie cheesecake tart jelly-o. Bear claw cookie chocolate bar jujubes toffee")
    private val baconIpsum: MyData = MyData("Bacon Ipsum","Bacon ipsum dolor sit amet salami jowl corned beef, andouille flank tongue ball tip kielbasa pastrami tri-tip meatloaf short loin beef biltong. Cow bresaola ground round strip steak fatback meatball shoulder leberkas pastrami sausage corned beef t-bone pork belly drumstick.")
    private val tunaIpsum:  MyData = MyData("Tuna Ipsum","Moonfish, steelhead, lamprey southern flounder tadpole fish sculpin bigeye, blue-redstripe danio collared dogfish. Smalleye squaretail goldfish arowana butterflyfish pipefish wolf-herring jewel tetra, shiner; gibberfish red velvetfish. Thornyhead yellowfin pike threadsail ayu cutlassfish.")
    private val veggieIpsum: MyData = MyData ("Veggie Ipsum","Veggies sunt bona vobis, proinde vos postulo esse magis grape pea sprouts horseradish courgette maize spinach prairie turnip jícama coriander quandong gourd broccoli seakale gumbo. Parsley corn lentil zucchini radicchio maize burdock avocado sea lettuce. Garbanzo tigernut earthnut pea fennel.")
    private val zombieIpsum: MyData = MyData("Zombie Ipsum","Zombie ipsum reversus ab viral inferno, nam rick grimes malum cerebro. De carne lumbering animata corpora quaeritis. Summus brains sit , morbo vel maleficia? De apocalypsi gorger omero undead survivor dictum mauris. Hi mindless mortuis soulless creaturas, imo evil stalking monstra adventus resi dentevil vultus comedat cerebella viventium.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.cupcakeIpsum = cupcakeIpsum
        binding.tunaIpsum = tunaIpsum
        binding.baconIpsum = baconIpsum
        binding.veggieIpsum = veggieIpsum
        binding.zombieIpsum = zombieIpsum

        binding.creatorButton.setOnClickListener{
            pickCreatorName(it)
        }

        binding.creatorText.setOnClickListener{
            changeCreatorName(it)
        }
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.lorrem_type, android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spGen.adapter = adapter
        binding.spGen.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val currentType: String = binding.spGen.getItemAtPosition(position).toString()
                if (currentType == "Cupcake Ipsum"){
                    // binding.titleText.text = cupcakeIpsum.type
                    binding.lorremText.text = cupcakeIpsum.content
                } else if (currentType == "Tuna Ipsum") {
                    binding.lorremText.text = tunaIpsum.content
                } else if (currentType == "Bacon Ipsum") {
                    binding.lorremText.text = baconIpsum.content
                } else if (currentType == "Veggie Ipsum") {
                    binding.lorremText.text = veggieIpsum.content
                } else if (currentType == "Zombie Ipsum") {
                    binding.lorremText.text = zombieIpsum.content
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("LoremGenerator :: ","onNothingSelected() is Called! Doing Absolutely Nothing....")
            }
        }
    }

    private fun pickCreatorName(view: View){
        //change text
        binding.apply{
            creatorText.text = creatorFill.text.toString()
            creatorFill.visibility = View.GONE
            creatorButton.visibility = View.GONE
            spGen.visibility = View.VISIBLE
            creatorText.visibility = View.VISIBLE
        }
        //hide and show required views
        //hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun changeCreatorName(view: View){
        binding.apply{
            creatorText.text = creatorFill.text.toString()
            creatorFill.visibility = View.GONE
            creatorButton.visibility = View.GONE
            spGen.visibility = View.VISIBLE
            creatorText.visibility = View.VISIBLE
        }
        //hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

}


