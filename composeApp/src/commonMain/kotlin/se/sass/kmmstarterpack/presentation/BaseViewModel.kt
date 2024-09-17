package se.sass.kmmstarterpack.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

/**
 * [BaseViewModel] is alternative way for using ViewModel with scope in KMM
 * BE AWARE since this is not life-cycle aware so you must [clear] it yourself
 */

abstract class BaseViewModel {
    private val viewModelJob: Job = SupervisorJob()
    protected val viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    open fun clear() {
        viewModelScope.cancel()
    }
}