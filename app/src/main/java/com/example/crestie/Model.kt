package com.example.crestie

class Model {
    private var image:Int
    private var title:String
    private var desc:String

    constructor(image: Int, title: String, desc: String) {
        this.image = image
        this.title = title
        this.desc = desc
    }

    fun getImage(): Int {
        return this.image
    }

    fun getTitle(): Any {
        return this.title
    }

    fun getText(): Any {
        return this.desc
    }
}