package com.example.task_influncers

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class CouponFragment : Fragment() {

    private lateinit var titleTextView: TextView
    private lateinit var urlTextView: TextView

    companion object {
        fun newInstance(title: String, url: String): CouponFragment {
            val fragment = CouponFragment()
            val args = Bundle()
            args.putString("TITLE", title)
            args.putString("URL", url)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_coupon, container, false)

        titleTextView = view.findViewById(R.id.title)
        urlTextView = view.findViewById(R.id.url)

        val title = arguments?.getString("TITLE") ?: "No Title"
        val url = arguments?.getString("URL") ?: "No URL"

        titleTextView.text = title
        urlTextView.text = url

        // Long press to copy the URL
        urlTextView.setOnLongClickListener {
            copyToClipboard(url)
            true
        }

        return view
    }

    private fun copyToClipboard(text: String) {
        val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copied URL", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(requireContext(), "Link copied to clipboard", Toast.LENGTH_SHORT).show()
    }
}
