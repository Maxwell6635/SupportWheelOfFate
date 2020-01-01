package com.jacksonfoo.supportwheeloffate.data.model

import com.google.gson.annotations.SerializedName

data class Engineer(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
)