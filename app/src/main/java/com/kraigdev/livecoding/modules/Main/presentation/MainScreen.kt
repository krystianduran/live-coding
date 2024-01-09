package com.kraigdev.livecoding.modules.Main.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {

    val state by mainViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        mainViewModel.getCategories()
    }

    MainView(state.categoryList)
}

@Preview
@Composable
private fun MainPreview() {
    MainScreen()
}

@Composable
private fun MainView(categoryList: List<String>) {
    LazyColumn {

        items(categoryList) {
            Text(text = it)
        }
    }

}