package com.wizard.cardapp.elm

data class State(
    val secondsPassed: Long = 0,
    val isStarted: Boolean = false
)

sealed class Effect {
    data class Error(val throwable: Throwable) : Effect()
}

sealed class Command {
    object Start : Command()
    object Stop : Command()
}

sealed class Event {
    object Init : Event()
    object Start : Event()
    object Stop : Event()
    object OnTimeTick : Event()
    data class OnTimeError(val throwable: Throwable) : Event()
}