package com.dicoding.myfootball.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.myfootball.core.domain.usecase.MyFootballUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(myFootballUseCase: MyFootballUseCase) : ViewModel() {
    val league = myFootballUseCase.getAllLeague().asLiveData()
}