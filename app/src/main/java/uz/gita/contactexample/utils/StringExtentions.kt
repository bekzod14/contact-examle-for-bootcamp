package uz.gita.contactexample.utils

fun String.isPhoneNumber() : Boolean {
    if (!this.startsWith("+")) return false

    if (this.length != 13) return false

    for (i in 1 until this.length) {
        if (!this[i].isDigit()) return false
    }

    return true
}