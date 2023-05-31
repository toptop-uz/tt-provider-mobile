package com.toptop.provider.resources

//@Immutable
data class StringResources(
    val appName: String = "Top-Top",
    val chooseYourLanguage: String,
    val pleaseSelectLanguage: String,
    val uzbek: String = "O'zbekcha",
    val english: String = "English",
    val russian: String = "Русский",
    val appDescription: String,
    val getStarted: String
)

//fun stringResourcesUz() = StringResources(
//    chooseYourLanguage = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
//    appDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
//    getStarted = "Davom etish",
//)

fun stringResourcesEn() = StringResources(
    chooseYourLanguage = "Choose Your Preferred Language",
    pleaseSelectLanguage = "Please select your language",
    appDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
    getStarted = "Get started",
)