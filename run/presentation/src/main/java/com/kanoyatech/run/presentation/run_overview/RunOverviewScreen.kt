@file:OptIn(ExperimentalMaterial3Api::class)

package com.kanoyatech.run.presentation.run_overview

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanoyatech.core.presentation.designsystem.AnalyticsIcon
import com.kanoyatech.core.presentation.designsystem.LogoIcon
import com.kanoyatech.core.presentation.designsystem.LogoutIcon
import com.kanoyatech.core.presentation.designsystem.RunIcon
import com.kanoyatech.core.presentation.designsystem.RuniqueTheme
import com.kanoyatech.core.presentation.designsystem.components.RuniqueFloatingActionButton
import com.kanoyatech.core.presentation.designsystem.components.RuniqueScaffold
import com.kanoyatech.core.presentation.designsystem.components.RuniqueToolbar
import com.kanoyatech.core.presentation.designsystem.components.util.DropDownItem
import com.kanoyatech.run.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun RunOverviewScreenRoot(
    onStartRunClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel()
) {
    RunOverviewScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                is RunOverviewAction.OnStartClick -> {
                    onStartRunClick()
                }
                else -> Unit
            }

            viewModel.onAction(action)
        }
    )
}

@Composable
private fun RunOverviewScreen(
    state: RunOverviewState,
    onAction: (RunOverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )

    RuniqueScaffold(
        topAppBar = {
            RuniqueToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.runique),
                scrollBehavior = scrollBehavior,
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(id = R.string.analytics)
                    ),
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(id = R.string.logout)
                    )
                ),
                onMenuItemClick = { index ->
                    when(index) {
                        0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                        1 -> onAction(RunOverviewAction.OnLogoutClick)
                    }
                },
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        },
        floatingActionButton = {
            RuniqueFloatingActionButton(
                icon = RunIcon,
            ) {
                onAction(RunOverviewAction.OnStartClick)
            }
        }
    ) {

    }
}

@Preview
@Composable
private fun RunOverviewScreenRootScreenPreview() {
    RuniqueTheme {
        RunOverviewScreen(
            state = RunOverviewState(),
            onAction = {}
        )
    }
}