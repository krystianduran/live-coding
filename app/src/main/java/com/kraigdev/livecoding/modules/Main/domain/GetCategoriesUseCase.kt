package com.kraigdev.livecoding.modules.Main.domain

import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    operator fun invoke() = mainRepository.getCategories()
}
