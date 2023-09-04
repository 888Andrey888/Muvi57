package com.example.muvi57.model

import java.io.Serializable

data class MuviModel(
    var Title: String,
    var Year: String,
    var Genre: String,
    var Awards: String,
    var Poster: String,
    var Ratings: ArrayList<RatingModel>,
) : Serializable

data class RatingModel(
    var Value:String,
    var Source:String
)
