package com.lahsuak.apps.testexample.utils

import android.content.Context
import com.google.gson.Gson

class ProductTypeManager {
    var typeList = emptyArray<ProductType>()
    var currentIndex = 0

    fun populateProductTypeFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        typeList = gson.fromJson(json, Array<ProductType>::class.java)
    }

    fun populateProductTypes(productTypes: Array<ProductType>) {
        typeList = productTypes
    }

    fun getCurrentProductType(): ProductType {
        return typeList[currentIndex]
    }

    fun getNextProductType(): ProductType {
        return if (currentIndex == typeList.size - 1)
            typeList[currentIndex]
        else
            typeList[++currentIndex]
    }

    fun getPreviousProductType(): ProductType {
        return if (currentIndex == 0)
            typeList[currentIndex]
        else
            typeList[--currentIndex]
    }
}