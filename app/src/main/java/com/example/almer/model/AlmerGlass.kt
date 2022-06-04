package com.example.almer.model

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.example.almer.R

data class AlmerGlass constructor(
    val icone : Int,
    val name : String,
    val status : String
)

// Mock List for Presentation Purpose
val almerGlassList = arrayListOf(

    AlmerGlass(
        icone = R.drawable.itemicon,
        name = "Almer Glasses #225",
        status = "Pairing removed"
    ),
    AlmerGlass(
        icone = R.drawable.itemicon,
        name = "Almer Glasses #226",
        status = "not connected"
    ),


)
