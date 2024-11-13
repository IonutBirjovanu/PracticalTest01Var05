package ro.pub.cs.systems.eim.practicaltest01var05

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TransferActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        val transferredText = intent.getStringExtra("transferredText")
        val buttonPressCount = intent.getIntExtra("buttonPressCount", 0)

        val textView = findViewById<TextView>(R.id.transferred_text_view)
        textView.text = "Text: $transferredText\nButton Press Count: $buttonPressCount"
    }
}