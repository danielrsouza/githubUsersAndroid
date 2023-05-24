package com.example.usergithub.data.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar: String,
    @SerializedName("html_url")
    val htmlUrl: String
)
