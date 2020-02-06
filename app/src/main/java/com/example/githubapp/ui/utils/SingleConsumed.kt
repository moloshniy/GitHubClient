package com.example.githubapp.ui.utils


class SingleConsumed<T>(private val event: T){

    private var isConsumed: Boolean = false

    internal fun getIfNotConsumed(): T? {
        return if (isConsumed)
            null
        else {
            isConsumed = true
            event
        }
    }

    internal fun doIfNotConsumed(block:()->Unit) {
         if (isConsumed) return

            isConsumed = true
            block.invoke()
    }

}