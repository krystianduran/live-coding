package com.kraigdev.livecoding.modules.Main.data

import com.kraigdev.livecoding.modules.Main.domain.MainModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class MainResponse(
    val categoryList: List<String>
) {

    fun toModel(): MainModel = MainModel(categoryList = categoryList)
}
