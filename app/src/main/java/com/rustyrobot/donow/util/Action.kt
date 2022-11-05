package com.rustyrobot.donow.util

enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}

fun String?.toAction() = if (this.isNullOrEmpty()) Action.NO_ACTION else Action.valueOf(this)
