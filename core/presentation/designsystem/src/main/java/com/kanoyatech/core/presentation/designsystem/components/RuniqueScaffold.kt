@file:OptIn(ExperimentalMaterial3Api::class)

package com.kanoyatech.core.presentation.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanoyatech.core.presentation.designsystem.LogoIcon
import com.kanoyatech.core.presentation.designsystem.RunIcon
import com.kanoyatech.core.presentation.designsystem.RuniqueTheme

@Composable
fun RuniqueScaffold(
    modifier: Modifier = Modifier,
    withGradient: Boolean = true,
    topAppBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = topAppBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = Modifier
    ) { padding ->
        if (withGradient) {
            GradientBackground {
                content(padding)
            }
        } else {
            content(padding)
        }
    }
}

@Preview
@Composable
private fun RuniqueScaffoldPreview() {
    RuniqueTheme {
        RuniqueScaffold(
            modifier = Modifier.fillMaxSize(),
            withGradient = true,
            topAppBar = {
                RuniqueToolbar(
                    showBackButton = false,
                    title = "Runique"
                ) {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(35.dp)
                    )
                }
            },
            floatingActionButton = {
                RuniqueFloatingActionButton(
                    icon = RunIcon
                ) {

                }
            }
        ) {
        }
    }
}