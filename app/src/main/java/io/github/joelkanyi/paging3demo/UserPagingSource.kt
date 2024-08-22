package io.github.joelkanyi.paging3demo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.joelkanyi.paging3demo.UsersResponse.Companion.toUser

class UserPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, User>() {
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val nextPage = params.key ?: FIRST_PAGE_INDEX

        return try {
            val response = apiService.getUsers(
                page = nextPage,
                size = params.loadSize
            )

            LoadResult.Page(
                data = response.data.map { it.toUser() },
                prevKey = if (nextPage == FIRST_PAGE_INDEX) null else nextPage - 1,
                nextKey = if (response.data.isEmpty()) null else nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val FIRST_PAGE_INDEX = 1
    }
}