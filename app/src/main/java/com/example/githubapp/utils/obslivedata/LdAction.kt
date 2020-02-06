package com.example.githubapp.utils.obslivedata

import java.lang.Exception
import kotlin.properties.Delegates

sealed class LdAction<S : Any, E : Exception> {
    private var consumed: Boolean = false
    private var result: S by Delegates.notNull()
    private var err: E by Delegates.notNull()

    fun setValue(s: S) {
        result = s
    }

    fun setError(e: E) {
        err = e
    }

    fun getValue(): S {
        return result
    }

    fun getError(): E {
        return err
    }

    fun doSingleValue(block: (S) -> Unit) {
        if (!consumed) {
            block.invoke(result)
            consumed = true
        }
    }

    fun doSingleError(block: (E) -> Unit) {
        if (!consumed) {
            block.invoke(err)
            consumed = true
        }
    }

    fun doSingle(block: () -> Unit) {
        if (!consumed) {
            block.invoke()
            consumed = true
        }
    }

    class OnStart<S : Any, E : Exception> : LdAction<S, E>()
    class OnSuccess<S : Any, E : Exception> : LdAction<S, E>()
    class OnError<S : Any, E : Exception> : LdAction<S, E>()
    class OnComplete<S : Any, E : Exception> : LdAction<S, E>()
}

