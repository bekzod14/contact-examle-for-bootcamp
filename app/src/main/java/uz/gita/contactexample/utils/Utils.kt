package uz.gita.contactexample.utils

import android.content.Context

fun getDrawableResId(context: Context, name: String): Int {
    return context.resources.getIdentifier(name, "drawable", context.packageName)
}

