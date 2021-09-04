package com.knz21.github_emoji.api

import retrofit2.http.GET

interface GithubService {

    @GET("emojis")
    suspend fun fetchEmojis(): Map<String, String>
}