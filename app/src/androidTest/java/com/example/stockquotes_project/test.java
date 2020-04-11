package com.example.stockquotes_project;

import android.content.Context;

import org.junit.Test;

import androidx.test.platform.app.InstrumentationRegistry;

import static junit.framework.TestCase.assertEquals;

public class test  {
    @Test
    public void useAppContext() {

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.stockquotes_project",appContext.getPackageName());
    }
}

