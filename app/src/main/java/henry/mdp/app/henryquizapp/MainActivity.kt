package henry.mdp.app.henryquizapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var selectedAnswer: TextView
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onReset(view: View){
        cbOne.isChecked = false
        cbTwo.isChecked = false
        cbThree.isChecked = false

        rbOne.isChecked = false
        rbTwo.isChecked = false
        rbThree.isChecked = false
    }

    fun qtnOneSubmit(view: View){

        if ((cbThree.isChecked) && !(cbOne.isChecked) && !(cbTwo.isChecked)){
            alertSuccessMessageDateAndTime()
        }else{
            alertFailureMessageDateAndTime()
        }

        // 1. Get the checked radio button id from the radio group
        var selectedOption: Int = radioGroup!!.checkedRadioButtonId

        // 2. Assign id of the checked radio button
        if(selectedOption >= 0) {
            selectedAnswer = findViewById(selectedOption)
        }else{
            selectedAnswer = findViewById(R.id.tvQtnOne)
        }

        if(selectedAnswer != null){
            if(selectedAnswer.text.toString().equals("fun")){
                alertSuccessMessageDateAndTime()
            }
            alertFailureMessageDateAndTime()
        }else{
            Toast.makeText(this,"Select an answer",Toast.LENGTH_LONG).show()
        }
    }

    fun alertFailureMessageDateAndTime(){
        score += 0
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance() //or use getDateInstance()
        val currentDateTime = formatter.format(date)

        //Show dialog box with Congratulations, submitted on current date and time, Your score is score%
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Your score summary")
        builder.setMessage("Confirmation! You submitted on $currentDateTime. You achieved $score%")
        builder.setIcon(R.drawable.alerticon)
        builder.setPositiveButton("OK"){
                dialogInterface, which ->
            dialogInterface.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun alertSuccessMessageDateAndTime(){
        score += 50
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance() //or use getDateInstance()
        val currentDateTime = formatter.format(date)

        //Show dialog box with Congratulations, submitted on current date and time, Your score is score%
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Your score summary")
        builder.setMessage("Congratulations! You submitted on $currentDateTime. You achieved $score%")
        builder.setIcon(R.drawable.alerticon)
        builder.setPositiveButton("OK"){
                dialogInterface, which ->
            dialogInterface.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}