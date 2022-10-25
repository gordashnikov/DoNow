package com.rustyrobot.donow.data.models

import androidx.compose.ui.graphics.Color
import com.rustyrobot.donow.ui.theme.HighPriorityColor
import com.rustyrobot.donow.ui.theme.LowPriorityColor
import com.rustyrobot.donow.ui.theme.MediumPriorityColor
import com.rustyrobot.donow.ui.theme.NonePriorityColor


enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}