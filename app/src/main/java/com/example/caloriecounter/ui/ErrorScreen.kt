package com.example.caloriecounter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caloriecounter.R
import com.example.caloriecounter.ui.theme.CalorieCounterTheme

@Composable
fun ErrorScreen(
    errorMessage: String,
    reloadData: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_sync_problem),
            contentDescription = stringResource(id = R.string.error),
            modifier = Modifier.size(82.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = errorMessage,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = reloadData) {
            Text(text = stringResource(id = R.string.reload))
        }
    }
}

@Preview(name = "ErrorScreen")
@Composable
private fun ErrorScreenPreview(){
    CalorieCounterTheme {
        ErrorScreen(errorMessage = stringResource(id = R.string.error), reloadData = {})
    }
}
