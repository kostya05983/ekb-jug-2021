package ru.kontur.test.benchmark

import java.util.*

data class User(
    val id: UUID,
    val type: UserType,
    val notificationId: UUID,
    val onceMoreId: UUID
)

enum class UserType {
    TYPE_1,
    TYPE_2,
    TYPE_3,
    TYPE_4,
    TYPE_5,
    TYPE_6
}
