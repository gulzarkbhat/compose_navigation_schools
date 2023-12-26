package com.nyc.schools.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nyc.schools.data.models.SchoolDetail
import com.nyc.schools.viewmodels.DetailViewModel


/**
 * School Detail screen for showing the selected school information
 */
@Composable
fun SchoolDetailScreen(
    dbn: String,
    viewModel: DetailViewModel = viewModel()
) {

    LaunchedEffect(key1 = true, block = {
        viewModel.getSchoolDetail(dbn)
    })

    val uiStateDetail by viewModel.uiState2.collectAsState()
    uiStateDetail.let { schoolDetailState ->
        when (schoolDetailState) {
            DetailViewModel.SchoolDetailState.Loading -> {
                FullScreenLoading()
            }

            is DetailViewModel.SchoolDetailState.Success -> {
                if (schoolDetailState.data.isNullOrEmpty())
                    ErrorState("No data fetched about this school.")
                else
                    SchoolDetailSAT(schoolDetailState.data.firstOrNull())
            }

            DetailViewModel.SchoolDetailState.Failure -> {
                ErrorState()
            }
        }
    }

}

@Composable
fun SchoolDetailSAT(school: SchoolDetail?) {
    school?.let {
        Column(modifier = Modifier.padding(all = 16.dp)) {
            Text(
                text = it.schoolName,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
            Text(
                text = "Math Avg Score: ${it.satMathAvgScore}",
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Writing Avg Score: ${it.satWritingAvgScore}",
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Critical Reading Avg Score: ${it.satCriticalReadingAvgScore}",
                modifier = Modifier.padding(top = 16.dp)
            )
        }

    }
}