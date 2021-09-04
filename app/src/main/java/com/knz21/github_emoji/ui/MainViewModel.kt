package com.knz21.github_emoji.ui

import androidx.lifecycle.*
import com.knz21.github_emoji.data.GithubRepository
import com.knz21.github_emoji.model.Emoji
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    val emojis: LiveData<List<Emoji>> = liveData(viewModelScope.coroutineContext) {
        emit(githubRepository.fetchEmojis())
    }
}