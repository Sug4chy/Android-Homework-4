package ru.sug4chy.timetable.ui.week_timetable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.sug4chy.timetable.R
import ru.sug4chy.timetable.databinding.FragmentWeekTimetableBinding
import ru.sug4chy.timetable.utils.DateTimeUtils
import ru.sug4chy.timetable.utils.TimetableData

class WeekTimetableFragment private constructor() : Fragment(R.layout.fragment_week_timetable) {

    private val binding: FragmentWeekTimetableBinding by viewBinding()
    private val adapter: TimetableDayRecyclerAdapter = TimetableDayRecyclerAdapter(
        TimetableData[
            DateTimeUtils.isCurrentWeekOdd()
        ]?.map { entry -> entry.value } ?: emptyList()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Default setup
        super.onViewCreated(view, savedInstanceState)

        binding.weekLessonsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@WeekTimetableFragment.adapter
        }
    }

    companion object {

        @JvmStatic
        fun createNew(): WeekTimetableFragment =
            WeekTimetableFragment().apply {

            }
    }
}