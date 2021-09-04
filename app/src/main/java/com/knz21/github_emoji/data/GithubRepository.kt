package com.knz21.github_emoji.data

import android.util.Log
import com.knz21.github_emoji.api.GithubService
import com.knz21.github_emoji.model.Emoji
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository @Inject constructor(
    private val githubService: GithubService
) {

    suspend fun fetchEmojis(): List<Emoji> = withContext(Dispatchers.IO) {
        try {
            githubService.fetchEmojis().map { Emoji(it.key, it.value) }
        } catch (e: Exception) {
            Log.e("GithubRepository", "error: $e")
            emptyList()
        }
    }
}