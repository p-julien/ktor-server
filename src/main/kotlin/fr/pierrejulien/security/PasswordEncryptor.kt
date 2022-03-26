package fr.pierrejulien.security

import io.ktor.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

// Todo: .env en Kotlin ?
private const val SECRET_KEY = "4968110512"
private const val ALGORITHM = "HmacSHA1"
private val HASH_KEY = hex(SECRET_KEY)
private val HMAC_KEY = SecretKeySpec(HASH_KEY, ALGORITHM)

fun hash(password: String): String {
    val hmac = Mac.getInstance(ALGORITHM)
    hmac.init(HMAC_KEY)
    return hex(hmac.doFinal(password.toByteArray(Charsets.UTF_8)))
}

fun main() {
    val password = "1234"
    val hashedPassword = hash(password)
    println(hashedPassword)
}