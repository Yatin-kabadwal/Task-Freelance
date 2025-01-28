package com.example.task_influncers

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LinksFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LinksAdapter
    private lateinit var btnShuffle: Button
    private var linksList: MutableList<LinkItem> = mutableListOf(
        LinkItem("Apple", "www.MERCEDES.com"),
        LinkItem("BMW", "taplink.cc/BMW.com"),
        LinkItem("cARCHalao", "https://in.pinterest.com/pin/108367872907..."),
        LinkItem("Muscle Blaze", "www.racked.com"),
        LinkItem("sdhsdkfj kjhdfk", "www.dsjlksj.com")
    )

    companion object {
        fun newInstance(position: Int): LinksFragment {
            val fragment = LinksFragment()
            val args = Bundle()
            args.putInt("position", position)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_links, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        btnShuffle = view.findViewById(R.id.btnShuffle)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = LinksAdapter(linksList) { link ->
            openCouponTab(link)
        }
        recyclerView.adapter = adapter

        // **Shuffle Button Click Listener**
        btnShuffle.setOnClickListener {
            shuffleList()
        }

        return view
    }

    private fun shuffleList() {
        linksList.shuffle()  // Shuffle the list
        adapter.notifyDataSetChanged()  // Notify adapter about the changes
    }

    private fun openCouponTab(link: LinkItem) {
        val intent = Intent(requireContext(), CouponActivity::class.java).apply {
            putExtra("title", link.title)
            putExtra("url", link.url)
        }
        startActivity(intent)
    }
}
