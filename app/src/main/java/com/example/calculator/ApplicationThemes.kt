package com.example.calculator

enum class ApplicationThemes(val resource: Int, val key: String) {
    ONE_THEMES(
        R.style.Theme_Calculator,
        "first_themes"
    ),
    TWO_THEMES(
        R.style.Theme_Calculator_Another,
        "second_themes"
    ),
    THREE_THEMES(R.style.Theme_Calculator_Light, "third_themes");
}
