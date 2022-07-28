package com.example.caloriecounter.base

/** Use for routes args in [composable] */
infix fun String.connectArgs(args: Any): String {
    return "$this/{$args}"
}

/** Use to attach args to [NavHostController.navigate] */
infix fun String.withArgs(args: Any): String {
    return "$this/$args"
}
