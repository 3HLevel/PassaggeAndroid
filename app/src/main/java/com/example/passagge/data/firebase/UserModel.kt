package com.example.passagge.data.firebase

class UserModel() {
    var nickname: String? = null
    var email: String? = null
    var password: String? = null

    constructor(nickname: String, email: String, password: String) : this() {
        this.nickname = nickname
        this.email = email
        this.password = password
    }
}