package com.mobbelldev.netflixclone.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbelldev.netflixclone.R
import com.mobbelldev.netflixclone.domain.entities.LayoutDataItem
import com.mobbelldev.netflixclone.presentation.component.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHomeData()
    }

    private fun setupHomeData() {
        val homeData = listOf(
            LayoutDataItem.SingleMain,
            LayoutDataItem.NowPlaying,
            LayoutDataItem.UpComing,
            LayoutDataItem.Popular,
            LayoutDataItem.TopRated,
        )

        val rvHome = view?.findViewById<RecyclerView>(R.id.rv_home)
        val homeAdapter = MainAdapter(homeData)
        rvHome?.apply {
            adapter = homeAdapter
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}