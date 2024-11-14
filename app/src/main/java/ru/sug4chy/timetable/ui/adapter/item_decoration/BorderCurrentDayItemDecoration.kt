package ru.sug4chy.timetable.ui.adapter.item_decoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.timetable.R
import ru.sug4chy.timetable.utils.DateTimeUtils

class BorderCurrentDayItemDecoration : RecyclerView.ItemDecoration() {

    private val paint: Paint = Paint().apply {
        color = Color.MAGENTA
        style = Paint.Style.STROKE
        strokeWidth = 10F
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val layoutManager = parent.layoutManager ?: return
        var i = 0
        while (i in 0..<parent.childCount) {
            val view = parent.getChildAt(i)
            if (isCurrentDayOfWeek(view, parent)) {
                for (j in (i + 1)..<parent.childCount) {
                    var viewEnd = parent.getChildAt(j)
                    if (isDayOfWeek(viewEnd, parent) || j == parent.childCount - 1) {
                        viewEnd = if (j == parent.childCount - 1 && !isDayOfWeek(viewEnd, parent)) {
                            parent.getChildAt(j)
                        } else {
                            parent.getChildAt(j - 1)
                        }
                        val top = view.top + view.translationY - paint.strokeWidth - view.paddingTop
                        val bottom = layoutManager.getDecoratedBottom(viewEnd) +
                                viewEnd.translationY + paint.strokeWidth + viewEnd.paddingBottom
                        val right = layoutManager.getDecoratedRight(view) + view.translationX +
                                paint.strokeWidth + view.paddingRight
                        val left = layoutManager.getDecoratedLeft(view) + view.translationX -
                                paint.strokeWidth - view.paddingLeft
                        c.drawRect(left, top, right, bottom, paint)
                        i = j - 1
                        break
                    }
                }
            }
            i++
        }
    }

    private fun isDayOfWeek(view: View, parent: RecyclerView): Boolean {
        val viewType = parent.layoutManager?.getItemViewType(view) ?: return false
        return viewType == 0
    }

    private fun isCurrentDayOfWeek(view: View, parent: RecyclerView): Boolean {
        val viewType = parent.layoutManager?.getItemViewType(view) ?: return false
        val layout = view as? ConstraintLayout

        return viewType == 0 &&
                layout?.findViewById<TextView>(R.id.current_day_of_week_txv)?.text ==
                DateTimeUtils.formatDayOfWeek(DateTimeUtils.currentDayOfWeek)
    }
}