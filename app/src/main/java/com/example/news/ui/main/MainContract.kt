package com.example.news.ui.main

import com.example.news.ui.LiveCycle

interface MainContract {

    interface View {
    }

    interface Presenter : LiveCycle<View> {
        fun reset()
    }
}