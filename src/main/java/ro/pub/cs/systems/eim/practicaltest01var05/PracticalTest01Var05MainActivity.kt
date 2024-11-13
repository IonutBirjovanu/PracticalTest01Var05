package ro.pub.cs.systems.eim.practicaltest01var05

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textField: EditText
    private val buttonNames = mutableListOf<String>()
    private var buttonPressCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var05_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textField = findViewById(R.id.text_field)

        val buttons = listOf(
            findViewById<Button>(R.id.button_top_left),
            findViewById<Button>(R.id.button_top_right),
            findViewById<Button>(R.id.button_bottom_left),
            findViewById<Button>(R.id.button_bottom_right),
            findViewById<Button>(R.id.button_center)
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                buttonNames.add(button.text.toString())
                textField.setText(buttonNames.joinToString(", "))
                buttonPressCount++
            }
        }

        val transferButton = findViewById<Button>(R.id.button_transfer)
        transferButton.setOnClickListener {
            val intent = Intent(this, TransferActivity::class.java)
            intent.putExtra("transferredText", textField.text.toString())
            intent.putExtra("buttonPressCount", buttonPressCount)
            startActivity(intent)
        }
    }
}