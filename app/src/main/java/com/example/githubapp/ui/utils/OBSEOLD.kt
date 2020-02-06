/*package com.example.githubapp.ui.utils

package com.example.githubapp.ui.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.githubapp.utils.obslivedata.LdError
import com.example.githubapp.utils.obslivedata.LdAction
import java.lang.Exception

class ObservableLiveData<T> {

    private val onStartLd:MutableLiveData<Unit> = MutableLiveData()
    private val onStartSingleLd:MutableLiveData<SingleConsumed<Unit>> = MutableLiveData()

    private val onSuccessLd:MutableLiveData<T> = MutableLiveData()
    private val onSuccessSingleLd:MutableLiveData<SingleConsumed<T>> = MutableLiveData()

    private val onCompliteLd:MutableLiveData<Unit> = MutableLiveData()
    private val onCompliteSingleLd:MutableLiveData<SingleConsumed<Unit>> = MutableLiveData()

    private val onErrorLd:MutableLiveData<Exception> = MutableLiveData()
    private val onErrorSingleLd:MutableLiveData<SingleConsumed<Exception>> = MutableLiveData()


    fun observe(owner:LifecycleOwner, onAction:(LdAction<T>)->Unit, onError:(LdError<Exception>)->Unit ){
        onStartLd.observe(owner, Observer {
            onAction.invoke(LdAction.OnStart())
        })
        onStartSingleLd.observe(owner, Observer {
            onAction.invoke(LdAction.OnStart())
        })


        onSuccessLd.observe(owner, Observer {
            onAction.invoke(LdAction.OnSuccess())
        })
        onSuccessSingleLd.observe(owner, Observer {
            onAction.invoke(LdAction.OnSuccess())
        })

        onCompliteLd.observe(owner, Observer {
            onAction.invoke(LdAction.OnComplete())
        })
        onCompliteSingleLd.observe(owner, Observer {
            onAction.invoke(LdAction.OnComplete())
        })

        onErrorLd.observe(owner, Observer {
            onError.invoke(LdError.OnError(it))
        })

        onErrorSingleLd.observe(owner, Observer {
            onError.invoke(LdError.OnErrorSingle(it))
        })
    }

    fun onStart(){
        onStartLd.value = Unit
        onStartSingleLd.value = SingleConsumed(Unit)
    }

    fun onSuccess(t:T){
        onSuccessLd.value = t
        onSuccessSingleLd.value = SingleConsumed(t)
    }

    fun onComplete(){
        onCompliteLd.value = Unit
        onCompliteSingleLd.value = SingleConsumed(Unit)
    }

    fun <E:Exception>onError(e:E){
        onErrorLd.value = e
        onErrorSingleLd.value = SingleConsumed(e)
    }

    fun observeOnStart(owner: LifecycleOwner, observer: Observer<Unit>) {
        onStartLd.observe(owner,observer)
    }
    fun observeOnStartSingle(owner: LifecycleOwner, observer: Observer<SingleConsumed<Unit>>) {
        onStartSingleLd.observe(owner,observer)
    }

    fun observeOnSuccess(owner: LifecycleOwner, observer: Observer<in T>) {
        onSuccessLd.observe(owner,observer)
    }
    fun observeOnSuccessSingle(owner: LifecycleOwner, observer: Observer<in SingleConsumed<T>>) {
        onSuccessSingleLd.observe(owner,observer)
    }

    fun observeOnComplite(owner: LifecycleOwner, observer: Observer<Unit>) {
        onCompliteLd.observe(owner,observer)
    }
    fun observeOnCompliteSingle(owner: LifecycleOwner, observer: Observer<SingleConsumed<Unit>>) {
        onCompliteSingleLd.observe(owner,observer)
    }

    fun observeOnError(owner: LifecycleOwner, observer: Observer<in Exception>) {
        onErrorLd.observe(owner,observer)
    }
    fun observeOnErrorSingle(owner: LifecycleOwner, observer: Observer<in SingleConsumed<Exception>>) {
        onErrorSingleLd.observe(owner,observer)
    }
}*/