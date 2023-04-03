package com.derandecker.fbmessengeruiclone.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "phone light theme",
    device = Devices.PIXEL_4_XL,
    showSystemUi = true,
    group = "Phone"
)
@Preview(
    name = "phone dark theme",
    device = Devices.PIXEL_4_XL,
    showSystemUi = true,
    group = "Phone",
    uiMode = UI_MODE_NIGHT_YES
)
annotation class PhonePreviews

@Preview(
    name = "foldable light theme",
    device = Devices.FOLDABLE,
    showSystemUi = true,
    group = "Foldable"
)
@Preview(
    name = "foldable dark theme",
    device = Devices.FOLDABLE,
    showSystemUi = true,
    group = "Foldable",
    uiMode = UI_MODE_NIGHT_YES
)
annotation class FoldablePreviews

@Preview(
    name = "tablet light theme",
    device = Devices.TABLET,
    showSystemUi = true,
    group = "Tablet"
)
@Preview(
    name = "tablet dark theme",
    device = Devices.TABLET,
    showSystemUi = true,
    group = "Tablet",
    uiMode = UI_MODE_NIGHT_YES
)
annotation class TabletPreviews

@PhonePreviews
@FoldablePreviews
@TabletPreviews
annotation class CombinedPreviews
