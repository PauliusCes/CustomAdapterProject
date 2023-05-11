package lt.paulius.customadapterproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts

class Employees : AppCompatActivity() {

    lateinit var adapter: CustomAdapter
    lateinit var employeeListView: ListView
    lateinit var clickButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeeListView = findViewById(R.id.employeeListView)
        clickButton = findViewById(R.id.btnClick)


        val employees = mutableListOf<Employee>()
        setUpListView()
        updateAdapter(employees)

        setUpOnClickListener()
    }


    private fun setUpListView() {
        adapter = CustomAdapter(this)
        employeeListView.adapter = adapter
    }

    private fun updateAdapter(employees: MutableList<Employee>) {
        adapter.add(employees)
        adapter.add(
            Employee(1, "John", "Smith", "Manager"),
            Employee(2, "William", "Johnson", "Builder"),
            Employee(3, "Hugh", "Williamson", "Accountant")
        )
    }
    private fun setUpOnClickListener() {
        clickButton.setOnClickListener {
            startActivityForResult.launch(Intent(this, SecondActivity::class.java))
        }
    }

    private val startActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when (result.resultCode) {
                Activity.RESULT_OK -> {
                    val employee = Employee(
                        id = result.data
                            ?.getIntExtra(SecondActivity.SECOND_ACTIVITY_EMPLOYEE_ID, 0) ?: 0,
                        firstName = result.data
                            ?.getStringExtra(SecondActivity.SECOND_ACTIVITY_EMPLOYEE_FIRST_NAME) ?: "",
                        lastName = result.data
                            ?.getStringExtra(SecondActivity.SECOND_ACTIVITY_EMPLOYEE_LAST_NAME) ?: "",
                        position = result.data
                            ?.getStringExtra(SecondActivity.SECOND_ACTIVITY_EMPLOYEE_POSITION) ?: "",
                    )

                    adapter.add(employee)
                }
            }
        }

    companion object {
        const val MAIN_ACTIVITY_EMPLOYEE_ID = "lt.paulius.customadapterproject_employee_id"
        const val MAIN_ACTIVITY_FIRST_NAME = "lt.paulius.customadapterproject_employee_first_name"
        const val MAIN_ACTIVITY_LAST_NAME = "lt.paulius.customadapterproject_employee_last_name"
        const val MAIN_ACTIVITY_POSITION = "lt.paulius.customadapterproject_employee_position"
    }
}