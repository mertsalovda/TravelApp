package ru.mertsalovda.travelapp.ui.behavior

import android.R.attr
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar
import kotlin.math.min


class CardViewBehavior(context: Context?, attrs: AttributeSet?) :
    CoordinatorLayout.Behavior<CardView>(context, attrs) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: CardView,
        dependency: View
    ) = dependency is Snackbar.SnackbarLayout

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: CardView,
        dependency: View
    ): Boolean {
        val translationY = min(
            0.0f,
            dependency.translationY - dependency.height
        )
        child.translationY = translationY
        return true
    }

    override fun onDependentViewRemoved(
        parent: CoordinatorLayout,
        child: CardView,
        dependency: View
    ) {
        child.translationY = 0.0f
    }
}