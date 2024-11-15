package ru.sug4chy.timetable.ui.adapter.item_decoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.timetable.ui.adapter.view_holder.DayOfWeekViewHolder
import ru.sug4chy.timetable.ui.adapter.view_holder.TimetableItemViewHolder

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
            if (!isCurrentDayOfWeek(view, parent)) {
                i++
                continue
            }

            for (j in (i + 1)..<parent.childCount) {
                var viewEnd = parent.getChildAt(j)
                if (isCurrentDayOfWeek(viewEnd, parent) && j != parent.childCount - 1) {
                    continue
                }

                viewEnd = if (isCurrentDayOfWeek(viewEnd, parent) && j == parent.childCount - 1) {
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

            i++
        }
    }

    private fun isCurrentDayOfWeek(view: View, parent: RecyclerView): Boolean =
        when (val viewHolder = parent.getChildViewHolder(view)) {
            is DayOfWeekViewHolder -> viewHolder.isForCurrentDayOfWeek
            is TimetableItemViewHolder -> viewHolder.isForCurrentDayOfWeek
            else -> false
        }
}