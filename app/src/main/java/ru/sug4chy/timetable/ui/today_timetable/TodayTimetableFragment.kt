package ru.sug4chy.timetable.ui.today_timetable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.sug4chy.timetable.R
import ru.sug4chy.timetable.databinding.FragmentTodayTimetableBinding
import ru.sug4chy.timetable.utils.DateTimeUtils
import ru.sug4chy.timetable.utils.TimetableData

class TodayTimetableFragment private constructor() : Fragment(R.layout.fragment_today_timetable) {

    private val binding: FragmentTodayTimetableBinding by viewBinding()
    private val adapter: TimetableItemRecyclerAdapter = TimetableItemRecyclerAdapter(
        data = TimetableData[
            DateTimeUtils.isCurrentWeekOdd(),
            DateTimeUtils.currentDayOfWeek
        ]?.lessons ?: emptyList()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Default setup
        super.onViewCreated(view, savedInstanceState)

        binding.currentDayOfWeekTxv.text = DateTimeUtils.formatDayOfWeek(
            dayOfWeek = DateTimeUtils.currentDayOfWeek
        )

        with(binding.todayLessonsRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TodayTimetableFragment.adapter
        }
    }

    companion object {

        @JvmStatic
        fun createNew(): TodayTimetableFragment =
            TodayTimetableFragment().apply {

            }
    }
}