package com.example.oma.data.behaviour

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.appbar.AppBarLayout

class ToolbarBehavior (context: Context?, attrs: AttributeSet?) : CoordinatorLayout.Behavior<AppBarLayout>(context, attrs) {

    var visible = false

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
        if (dy > 0 && !visible) {
            child.elevation = 10f
            visible = true
        } else if (dy < 0 && visible) {
            child.elevation = 0f
            visible = false
        }
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: AppBarLayout, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }
}