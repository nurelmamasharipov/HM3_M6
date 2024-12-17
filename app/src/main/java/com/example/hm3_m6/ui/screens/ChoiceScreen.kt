package com.example.hm3_m6.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hm3_m6.R
import com.example.hm3_m6.ui.models.Book

@Composable
fun ChoiceScreen(navController: NavController) {
    val books = listOf(
        Book(id = 1, title = "Книга 1", author = "Автор 1", description = "Описание книги 1", imageResId = R.drawable.img),
        Book(id = 2, title = "Книга 2", author = "Автор 2", description = "Описание книги 2", imageResId = R.drawable.img_1),
        Book(id = 3, title = "Книга 3", author = "Автор 3", description = "Описание книги 3", imageResId = R.drawable.img_2)
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(books) { book ->
            BookItem(book = book, navController = navController)
        }
    }
}

@Composable
fun BookItem(book: Book, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("detail/${book.id}")
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(
                text = book.title,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
