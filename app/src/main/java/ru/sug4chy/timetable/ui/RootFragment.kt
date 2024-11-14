package ru.sug4chy.timetable.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.sug4chy.timetable.R
import ru.sug4chy.timetable.databinding.FragmentRootBinding
import ru.sug4chy.timetable.ui.today_timetable.TodayTimetableFragment
import ru.sug4chy.timetable.ui.week_timetable.WeekTimetableFragment

class RootFragment private constructor() : Fragment(R.layout.fragment_root) {

    private val binding: FragmentRootBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Default setup
        super.onViewCreated(view, savedInstanceState)

        // Set default current fragment
        val weekTimetableFragment = WeekTimetableFragment.createNew()
        replaceContainerWithFragment(weekTimetableFragment)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.week_timetable_btn -> replaceContainerWithFragment(weekTimetableFragment)
                R.id.today_timetable_btn -> replaceContainerWithFragment(TodayTimetableFragment.createNew())
                else -> return@setOnItemSelectedListener false
            }
            true
        }
    }

    private fun replaceContainerWithFragment(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(binding.childrenFragmentsContainer.id, fragment)
            .commit()
    }

    companion object {

        @JvmStatic
        fun createNew(): RootFragment =
            RootFragment().apply {

            }
    }
}