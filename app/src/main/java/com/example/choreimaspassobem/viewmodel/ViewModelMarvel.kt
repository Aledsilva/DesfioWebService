package com.example.choreimaspassobem.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.choreimaspassobem.model.Results
import com.example.choreimaspassobem.repository.RepositoryMarvel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ViewModelMarvel : ViewModel() {

    var listMutableComic = MutableLiveData<MutableSet<Results>>()
    private val repositoryMarvel = RepositoryMarvel()

    fun getAllComics() = CoroutineScope(IO).launch {
        repositoryMarvel.getComicService().let {
            listMutableComic.postValue(it.data.results)
        }
    }
}