package ru.sug4chy.timetable.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.sug4chy.timetable.R
import ru.sug4chy.timetable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Default setup
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Inject root fragment
        supportFragmentManager
            .beginTransaction()
            .replace(binding.rootFragmentContainer.id, RootFragment.createNew())
            .commit()
    }
}