package io.github.joelkanyi.paging3demo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class UserRepository(private val apiService: ApiService) {
    fun getUsers(): Flow<PagingData<User>> = Pager(
        config = PagingConfig(
            pageSize = 5,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { UserPagingSource(apiService) }
    ).flow
}