package com.pourkazemi.mahdi.mymaktab_hw15

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout.HORIZONTAL
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import com.pourkazemi.mahdi.mymaktab_hw15.adapter.CityDetailLookup
import com.pourkazemi.mahdi.mymaktab_hw15.adapter.RecycleViewAdapter
import com.pourkazemi.mahdi.mymaktab_hw15.viewmodel.SharedViewModel
import com.pourkazemi.mahdi.mymaktab_hw15.databinding.FragmentAvailableBinding
import com.pourkazemi.mahdi.mymaktab_hw15.model.City
import com.pourkazemi.mahdi.mymaktab_hw15.adapter.CityKProvider

class AvailableFragment : Fragment(R.layout.fragment_available) {
    private lateinit var bind:FragmentAvailableBinding
   // private val fViewModer: SharedViewModel by activityViewModels()
    private lateinit var tracker: SelectionTracker<Long>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentAvailableBinding.bind(view)


        val mlinearLayoutManager = LinearLayoutManager(requireContext())
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        val list= listOf<City>(City(1L,"isfahan"),City(2L,"tehran"),City(3L,"shiraz"))

        val ARecycle = RecycleViewAdapter()
        ARecycle.setListCity(list)

        bind.availableRecycle.layoutManager=mlinearLayoutManager
        bind.availableRecycle.adapter = ARecycle

        tracker = SelectionTracker.Builder(
            "selectionItem",
            bind.availableRecycle,
            CityKProvider(RecycleViewAdapter()),
            CityDetailLookup(bind.availableRecycle),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        tracker.addObserver(
            object : SelectionTracker.SelectionObserver<Long>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()
                Log.d("test","is selected")
                }
            })

        ARecycle.tracker = tracker
        ARecycle.notifyDataSetChanged()

    }
}