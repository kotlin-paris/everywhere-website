package paris.kotlin.everywhere.utils

fun <T> T?.coerceToNull(): T? = if (this === undefined) null else this
