package com.example.githubapp.utils.obslivedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.githubapp.utils.obslivedata.LdAction.*
import java.lang.Exception

class ObservableLiveData<T:Any> {

    private val onStartLd:MutableLiveData<Unit> = MutableLiveData()
    private val onSuccessLd:MutableLiveData<T> = MutableLiveData()
    private val onCompleteLd:MutableLiveData<Unit> = MutableLiveData()
    private val onErrorLd:MutableLiveData<Exception> = MutableLiveData()

    private var recievedSuccessOrError:Boolean = false
    private var hasLastComplete:Boolean = false


    private var onStartAction:LdAction<T,Exception> = OnStart()
    private var onCompleteAction:LdAction<T,Exception> = OnComplete()
    private var onErrorAction:LdAction<T,Exception> = OnError()
    private var onSuccessAction:LdAction<T,Exception> = OnSuccess()

    fun observe(owner:LifecycleOwner, onAction: (LdAction<T,Exception>)->Unit){
        onStartLd.observe(owner, Observer {
         if (recievedSuccessOrError) return@Observer
          //  onStartAction.setValue()
            onAction.invoke(onStartAction)
        })

        onSuccessLd.observe(owner, Observer {
            recievedSuccessOrError = true
            onSuccessAction.setValue(it)
            onAction.invoke(onSuccessAction)
        })

        onErrorLd.observe(owner, Observer {
            if (recievedSuccessOrError) return@Observer
            recievedSuccessOrError = true
            onErrorAction.setError(it)
            onAction.invoke(onErrorAction)
        })

        onCompleteLd.observe(owner, Observer {
            if (recievedSuccessOrError && hasLastComplete) return@Observer
            if (recievedSuccessOrError )
                hasLastComplete = true

           // onCompleteAction.setValue(null)
            onAction.invoke(onCompleteAction)
        })
    }

    fun onStart(){
        onStartLd.value = null
    }

    fun onSuccess(t:T){
        onSuccessLd.value = t
    }

    fun onComplete(){
        onCompleteLd.value = null
    }

    fun <E:Exception>onError(e:E){
        onErrorLd.value = e
    }
}