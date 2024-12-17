package com.example.hm3_m6.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hm3_m6.R
import com.example.hm3_m6.ui.models.Book

@Composable
fun DetailScreen(bookId: Int?) {
    val book = bookId?.let { BookRepository.getBookById(it) }

    if (book != null) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = book.title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Автор: ${book.author}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Описание: ${book.description}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = book.imageResId),
                contentDescription = book.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
        }
    } else {
        Text(text = "Книга не найдена", style = MaterialTheme.typography.bodyLarge)
    }
}

