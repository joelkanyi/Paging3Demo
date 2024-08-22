package io.github.joelkanyi.paging3demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn

class UserViewModel(
    userRepository: UserRepository
): ViewModel() {
    val users = userRepository.getUsers().cachedIn(viewModelScope)
}