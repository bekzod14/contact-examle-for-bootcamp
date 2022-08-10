package uz.gita.contactexample.utils

import android.view.View

fun View.selected () {
    this.alpha = 1f
}

fun View.unselected() {
    this.alpha = 0.5f
}

fun View.selectOrUnselect(state : Boolean) {
    if (state) selected()
    else unselected()
}