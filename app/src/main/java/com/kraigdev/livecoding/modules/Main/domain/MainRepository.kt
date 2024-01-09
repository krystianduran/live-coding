package com.kraigdev.livecoding.modules.Main.domain

import kotlinx.coroutines.flow.Flow

fun interface MainRepository {
    fun getCategories(): Flow<MainModel>
}