package com.kraigdev.livecoding.modules.Main.data

import com.kraigdev.livecoding.modules.Main.domain.MainModel
import com.kraigdev.livecoding.modules.Main.domain.MainRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl @Inject constructor(
    private val mainApi: MainApi
) : MainRepository {

    override fun getCategories(): Flow<MainModel> = flow {

        val response = mainApi.getCategories()

        if (response.isSuccessful) {
            response.body()?.let {
                emit(it.toModel())
            }
        } else {
            MainModel(categoryList = listOf())
        }
    }
}

