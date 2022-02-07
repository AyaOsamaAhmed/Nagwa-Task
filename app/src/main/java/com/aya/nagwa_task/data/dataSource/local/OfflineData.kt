package com.aya.nagwa_task.data.dataSource.local

import android.content.Context
import com.aya.nagwa_task.domian.model.MovieResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class OfflineData (val context: Context) {

    private fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    private val jsonFileString = getJsonDataFromAsset("getListOfFilesResponse.json")
    private val listPersonType = object : TypeToken<MovieResponse>() {}.type

    var movies: MovieResponse = Gson().fromJson(jsonFileString, listPersonType)


}