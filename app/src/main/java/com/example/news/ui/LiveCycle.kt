package com.example.news.ui

interface LiveCycle<V> {
    fun bind(view: V)
    fun unbind()
}