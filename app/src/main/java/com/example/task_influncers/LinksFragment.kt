package com.example.task_influncers

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class LinksFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LinksAdapter
    private lateinit var btnShuffle: Button
    private var linksList = mutableListOf(
        LinkItem(1, "Apple", "https://www.apple.com/in/"),
        LinkItem(2, "BMW", "https://www.bmw.in/en/index.html"),
        LinkItem(3, "CarDekho", "https://www.cardekho.com/"),
        LinkItem(4, "Muscle Blaze", "https://www.muscleblaze.com/"),
        LinkItem(5, "Spinny", "https://www.spinny.com/")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_links, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        btnShuffle = view.findViewById(R.id.btnShuffle) // Initialize Shuffle Button

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = LinksAdapter(linksList, ::openCouponTab, ::deleteItem)
        recyclerView.adapter = adapter

        // Shuffle button click listener
        btnShuffle.setOnClickListener {
            shuffleList()
        }

        val btnAdd: Button = view.findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            showAddItemDialog()
        }

        return view
    }

    private fun openCouponTab(link: LinkItem) {
        val intent = Intent(requireContext(), CouponActivity::class.java).apply {
            putExtra("title", link.title)
            putExtra("url", link.url)
        }
        startActivity(intent)
    }

    private fun showAddItemDialog() {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_item, null)
        val editTitle = dialogView.findViewById<EditText>(R.id.editTitle)
        val editUrl = dialogView.findViewById<EditText>(R.id.editUrl)

        AlertDialog.Builder(requireContext())
            .setTitle("Add New Brand")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val title = editTitle.text.toString()
                val url = editUrl.text.toString()
                if (title.isNotEmpty() && url.isNotEmpty()) {
                    addItem(title, url)
                } else {
                    Toast.makeText(requireContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun addItem(title: String, url: String) {
        val newItem = LinkItem(linksList.size + 1, title, url)
        linksList.add(newItem)
        adapter.notifyItemInserted(linksList.size - 1)
    }

    private fun deleteItem(item: LinkItem) {
        val position = linksList.indexOf(item)
        if (position != -1) {
            linksList.removeAt(position)
            adapter.notifyItemRemoved(position)
        }
    }

    // Shuffle function
    private fun shuffleList() {
        linksList.shuffle(Random(System.currentTimeMillis())) // Shuffle the list
        adapter.notifyDataSetChanged() // Notify adapter to refresh UI
    }
}
