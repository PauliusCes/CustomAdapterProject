package lt.paulius.customadapterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class Employees : AppCompatActivity() {

    lateinit var adapter: CustomAdapter
    lateinit var employeeListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeeListView = findViewById(R.id.employeeListView)


        val employees = mutableListOf<Employee>()

        adapter = CustomAdapter(this)
        adapter.add(employees)
        adapter.add(
            Employee(1, "John", "Smith", "Manager"),
            Employee(2, "William", "Johnson", "Builder"),
            Employee(3, "Hugh", "Williamson", "Accountant")
        )

        employeeListView.adapter = adapter
    }
}