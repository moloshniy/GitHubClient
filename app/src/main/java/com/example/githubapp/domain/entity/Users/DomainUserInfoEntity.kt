package com.example.githubapp.domain.entity.Users

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DomainUserInfoEntity(
    val id:Int,
    val login:String,
    val avatarUrl:String
):Parcelable