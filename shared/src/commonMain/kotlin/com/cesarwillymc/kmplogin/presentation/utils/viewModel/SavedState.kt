package com.cesarwillymc.kmplogin.presentation.utils.viewModel

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Parcelize
data class SavedState(val value: Parcelable) : Parcelable

@Suppress("UNCHECKED_CAST") // I know what i'm doing
class SavedStateHandle(default: SavedState?) : InstanceKeeper.Instance {
    private var savedState: SavedState? = default
    val value: Parcelable? get() = savedState
    fun <T : Parcelable> get(): T? = savedState?.value as? T?
    fun set(value: Parcelable) {
        this.savedState = SavedState(value)
    }

    override fun onDestroy() {
        savedState = null
    }
}