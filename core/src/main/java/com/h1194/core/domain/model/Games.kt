package com.h1194.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class  Games(
    val tourismId: Int,
    val name: String,
    val rating: String,
    val image: String?,
    val isFavorite: Boolean
) : Parcelable