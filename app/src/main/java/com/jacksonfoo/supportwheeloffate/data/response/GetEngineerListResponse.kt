package com.jacksonfoo.supportwheeloffate.data.response

import com.google.gson.annotations.SerializedName
import com.jacksonfoo.supportwheeloffate.data.model.Engineer

data class GetEngineerListResponse(
    @SerializedName("engineers")
    val engineerList: ArrayList<Engineer>
)