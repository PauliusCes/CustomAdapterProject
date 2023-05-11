package lt.paulius.customadapterproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {

    lateinit var idEditText: EditText
    lateinit var firstnameEditText: EditText
    lateinit var lastNameEditText: EditText
    lateinit var positionEditText: EditText
    lateinit var closeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        idEditText = findViewById(R.id.etEmployeeID)
        firstnameEditText = findViewById(R.id.etFirstName)
        lastNameEditText = findViewById(R.id.etLastName)
        positionEditText = findViewById(R.id.etPosition)
        closeButton = findViewById(R.id.closeButton)

        getIntentExtra()
        setClickListenerOfCloseButton()
    }

    private fun getIntentExtra() {
        idEditText.setText(
            intent.getIntExtra(Employees.MAIN_ACTIVITY_EMPLOYEE_ID, -1).toString()
        )
        firstnameEditText.setText(
            intent.getStringExtra(Employees.MAIN_ACTIVITY_FIRST_NAME)
        )
        lastNameEditText.setText(
            intent.getStringExtra(Employees.MAIN_ACTIVITY_LAST_NAME)
        )
        positionEditText.setText(
            intent.getStringExtra(Employees.MAIN_ACTIVITY_POSITION)
        )
    }

    private fun setClickListenerOfCloseButton() {
        closeButton.setOnClickListener {
            val finishIntent = Intent()

            finishIntent.putExtra(SECOND_ACTIVITY_EMPLOYEE_ID, (idEditText.text.toString()).toInt())
            finishIntent.putExtra(SECOND_ACTIVITY_EMPLOYEE_FIRST_NAME, firstnameEditText.text.toString())
            finishIntent.putExtra(SECOND_ACTIVITY_EMPLOYEE_LAST_NAME, lastNameEditText.text.toString())
            finishIntent.putExtra(SECOND_ACTIVITY_EMPLOYEE_POSITION, positionEditText.text.toString())

            setResult(RESULT_OK, finishIntent)
            finish()
        }

    }

    companion object {
        const val SECOND_ACTIVITY_EMPLOYEE_ID = "lt.paulius.customadapterproject.secondactivity_employee_id"
        const val SECOND_ACTIVITY_EMPLOYEE_FIRST_NAME = "lt.paulius.customadapterproject.secondactivity_first_name"
        const val SECOND_ACTIVITY_EMPLOYEE_LAST_NAME = "lt.paulius.customadapterproject.secondactivity_last_name"
        const val SECOND_ACTIVITY_EMPLOYEE_POSITION = "lt.paulius.customadapterproject.secondactivity_position"
    }
}