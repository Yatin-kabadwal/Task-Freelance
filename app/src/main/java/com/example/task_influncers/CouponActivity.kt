package com.example.task_influncers

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CouponActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon)

        val titleTextView: TextView = findViewById(R.id.title)
        val urlTextView: TextView = findViewById(R.id.url)

        val title = intent.getStringExtra("title") ?: "Unknown"
        val url = intent.getStringExtra("url") ?: "No URL"

        titleTextView.text = title
        urlTextView.text = url

        // Long press to copy URL
        urlTextView.setOnLongClickListener {
            copyToClipboard(url)
            true
        }
    }

    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Coupon URL", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this, "Link copied to clipboard", Toast.LENGTH_SHORT).show()
    }
}
