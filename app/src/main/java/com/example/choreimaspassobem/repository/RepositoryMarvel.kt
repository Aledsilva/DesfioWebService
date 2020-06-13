package com.example.choreimaspassobem.repository

import com.example.choreimaspassobem.model.ComicResponse
import com.example.choreimaspassobem.network.RetrofitInit
import com.example.choreimaspassobem.network.ServiceMarvel
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class RepositoryMarvel {

    private var url = "https://gateway.marvel.com/v1/public/"
    private var service = ServiceMarvel::class
    private var ts = (System.currentTimeMillis() / 1000).toString()
    private val hash = getMd5(ts)
    private val serviceMarvel = RetrofitInit(url).create(service)

    suspend fun getComicService(): ComicResponse = serviceMarvel.getComicService(ts, hash, PUBLIC_KEY)

    private fun getMd5(ts: String): String {
        try {
            val messageDigest = MessageDigest.getInstance(MD5).digest(
                ts.toByteArray() + PRIVATE_KEY.toByteArray() + PUBLIC_KEY.toByteArray()
            )

            var hashText = BigInteger(SIGNUM_1, messageDigest).toString(RADIX)
            while (hashText.length < HASH_TEXT_LENGTH) {
                hashText = "0$hashText"
            }
            return hashText
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }

    companion object {
        private const val PUBLIC_KEY = "759f4ff044fbca66b28597acfbba8473"
        private const val PRIVATE_KEY = "e41134690427bcf770f5a3cad50724e503619873"

        private const val MD5 = "MD5"
        private const val SIGNUM_1 = 1
        private const val RADIX = 16
        private const val HASH_TEXT_LENGTH = 32
    }
}