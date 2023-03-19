package com.zpp.mobile.zmusic.Adapter

import com.chad.library.adapter.base.QuickAdapterHelper

class test {
    private lateinit var helper: QuickAdapterHelper
    private lateinit var homeAdapter: HomeAdapter;
    fun test() {
        helper = QuickAdapterHelper.Builder(homeAdapter)
            .build()
    }
}