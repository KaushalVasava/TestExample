package com.lahsuak.apps.testexample.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import junit.framework.Assert.assertEquals
import org.junit.Before

import org.junit.Test
import java.io.FileNotFoundException

class ProductTypeManagerTest {

    lateinit var context: Context
    lateinit var typeManager: ProductTypeManager

    @Before
    fun setUp() {
        typeManager = ProductTypeManager()
        context = ApplicationProvider.getApplicationContext()
    }

    @Test(expected = FileNotFoundException::class)
    fun populateProductTypeFromAssets() {
        typeManager.populateProductTypeFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun populateProductTypeFromAssets_InvalidJSON_expected_Exception() {
        typeManager.populateProductTypeFromAssets(context, "malformed.json")
    }

    @Test
    fun populateProductTypeFromAssets_ValidJSON_expected_Count() {
        typeManager.populateProductTypeFromAssets(context, "productType.json")
        assertEquals(13, typeManager.typeList.size)
    }

    @Test
    fun testPreviousProductType_expected_CorrectProductType() {
        typeManager.populateProductTypes(
            arrayOf(
                ProductType("12edf", "gram"),
                ProductType("13edf", "kg"),
                ProductType("14edf", "piece")
            )
        )
        val type = typeManager.getPreviousProductType()
        assertEquals("gram", type.name)
    }
    @Test
    fun testNextProductType_expected_CorrectProductType() {
        typeManager.populateProductTypes(
            arrayOf(
                ProductType("12edf", "gram"),
                ProductType("13edf", "kg"),
                ProductType("14edf", "piece")
            )
        )
        val type = typeManager.getNextProductType()
        assertEquals("kg", type.name)
    }
}