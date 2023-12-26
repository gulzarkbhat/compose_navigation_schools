package com.nyc.schools.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nyc.schools.R
import com.nyc.schools.data.models.School
import com.nyc.schools.viewmodels.SchoolsViewModel

/**
 * Screen for showing the list of schools and the interaction with item.
 */
@Composable
fun SchoolScreen(
    viewModel: SchoolsViewModel = viewModel(),
    onSelectionChanged: (String) -> Unit = {},
) {
    val schoolDate by viewModel.uiState.collectAsState()
    schoolDate.also { schools ->
        when (schools) {
            SchoolsViewModel.SchoolState.Loading -> {
                FullScreenLoading()
            }

            is SchoolsViewModel.SchoolState.Success -> {
                SchoolList(schools.data, onSelectionChanged)
            }

            SchoolsViewModel.SchoolState.Failure -> {
                ErrorState()
            }
        }
    }
}

@Composable
fun SchoolList(data: List<School>, onSelectionChanged: (String) -> Unit) {
    LazyColumn(content = {
        items(data) { item ->
            Text(
                text = item.schoolName,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(all = 16.dp)
                    .clickable {
                        onSelectionChanged.invoke(item.dbn)
                    }
            )
            Divider(
                color = Color.Gray,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    })
}

@Composable
fun FullScreenLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun ErrorState(msg: String = "Something went wrong. Please try again") {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Column {
            Icon(
                painter = painterResource(id = R.drawable.school), contentDescription = "School",
                modifier = Modifier
                    .padding(start = 100.dp),

                )
            Text(text = msg)
        }
    }
}