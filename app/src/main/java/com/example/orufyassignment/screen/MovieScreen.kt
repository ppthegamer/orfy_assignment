package com.example.orufyassignment.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.orufyassignment.customComponents.CustomMovieCard
import com.example.orufyassignment.viewModel.MovieViewModel

@Composable
fun MovieScreen(productsViewModel: MovieViewModel) {


    val lazyColumnState = rememberLazyListState()
    val imagesLoading by productsViewModel.isLoading.collectAsState()
    val moviesList by productsViewModel.productsList.collectAsState()
    var pageNumber by remember {
        mutableIntStateOf(1)
    }
    LaunchedEffect(productsViewModel) {
        productsViewModel.getProducts(pageNumber)
    }

    if (moviesList.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(top = 10.dp, start = 10.dp,end=10.dp),
                state = lazyColumnState,
                verticalArrangement = Arrangement.Center
            ) {
                items(moviesList) {
                    it.results.forEach { data ->
                        CustomMovieCard(
                            title = data.title,
                            description = data.overview,
                            imageLink = data.posterPath
                        )
                    }
                }
                if (lazyColumnState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == lazyColumnState.layoutInfo.totalItemsCount - 1
                    && lazyColumnState.isScrollInProgress.not() && !imagesLoading
                ) {
                    pageNumber++
                    productsViewModel.getProducts(pageNumber)
                }
                item {
                    if (imagesLoading) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(color = Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .clip(shape = CircleShape)
                                    .background(Color.White)
                                    .align(alignment = Alignment.Center),
                                color = Color.Black
                            )
                        }
                    }
                }
            }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = Color.Black)
        }
    }
}