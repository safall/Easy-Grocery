package com.whitecatlabs.easygrocery.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.whitecatlabs.easygrocery.resources.PoppinsRegular
import com.whitecatlabs.easygrocery.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun poppinsFontFamily(): FontFamily = FontFamily(Font(Res.font.PoppinsRegular, FontWeight.Normal))

@Composable
fun appTypography(): Typography {
    val poppins = poppinsFontFamily()
    val baseline = Typography()

    return Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        displayMedium = baseline.displayMedium.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        displaySmall = baseline.displaySmall.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        titleLarge = baseline.titleLarge.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        titleMedium = baseline.titleMedium.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        titleSmall = baseline.titleSmall.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        bodySmall = baseline.bodySmall.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        labelLarge = baseline.labelLarge.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        labelMedium = baseline.labelMedium.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
        labelSmall = baseline.labelSmall.copy(fontFamily = poppins, fontWeight = FontWeight.Normal),
    )
}
