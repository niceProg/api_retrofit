package com.uas.mymanga.Model

class Model (
    val mangaplus: List<Data>
) {
    data class Data (val judul_manga:String?, val author:String?)
}