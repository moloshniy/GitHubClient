package com.example.githubapp.app.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

import android.app.Application
import com.example.githubapp.app.App
import dagger.BindsInstance

@Component(
    modules = [
        AndroidInjectionModule::class
        , AppModule::class
        , ActivityBuilderModule::class
        , ViewModelModule::class
        , RetrofitModule::class
        , RepositoryManagerModule::class]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


}
