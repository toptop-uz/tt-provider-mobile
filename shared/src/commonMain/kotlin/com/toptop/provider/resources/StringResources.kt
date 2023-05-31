package com.toptop.provider.resources

data class StringResources(
    val appName: String = "TT Provider",
    val chooseYourLanguage: String,
    val pleaseSelectLanguage: String,
    val uzbek: String = "O'zbekcha",
    val english: String = "English",
    val russian: String = "Русский",
    val getStarted: String,
    val youWillReceiveCode: String,
    val signIn: String,
    val yourNumber: String,
    val acceptTerms: String,
    val verifyYourAccount: String,
    val weHaveSentCode: String,
    val didntReceiveCode: String,
    val resendCode: String,
    val resendCodeIn: String,
) {
    fun weHaveSentCode(phone: String): String {
        return weHaveSentCode.replace("{phone}", phone)
    }

    fun resendCodeIn(time: String): String {
        return resendCodeIn.replace("{time}", time)
    }
}

fun stringResourcesUz() = StringResources(
    chooseYourLanguage = "O'zingiz yoqtirgan tilni tanlang",
    pleaseSelectLanguage = "Please select your language",
    getStarted = "Get started",
    youWillReceiveCode = "You will receive a 4 digit code to verify next",
    signIn = "Sign in",
    yourNumber = "Your Number",
    acceptTerms = "I accept the Terms of Service as well as Privacy Policy",
    verifyYourAccount = "Verify Your Account",
    weHaveSentCode = "We have sent a 4 digit code to the number {phone}",
    didntReceiveCode = "Didn't receive OTP code?",
    resendCode = "Resend Code",
    resendCodeIn = "Resend code in {time}",
)

fun stringResourcesEn() = StringResources(
    chooseYourLanguage = "Choose Your Preferred Language",
    pleaseSelectLanguage = "Please select your language",
    getStarted = "Get started",
    youWillReceiveCode = "You will receive a 4 digit code to verify next",
    signIn = "Sign in",
    yourNumber = "Your Number",
    acceptTerms = "I accept the Terms of Service as well as Privacy Policy",
    verifyYourAccount = "Verify Your Account",
    weHaveSentCode = "We have sent a 4 digit code to the number {phone}",
    didntReceiveCode = "Didn't receive OTP code?",
    resendCode = "Resend Code",
    resendCodeIn = "Resend code in {time}",
)

fun stringResourcesRu() = StringResources(
    chooseYourLanguage = "Выберите предпочитаемый язык",
    pleaseSelectLanguage = "Please select your language",
    getStarted = "Get started",
    youWillReceiveCode = "You will receive a 4 digit code to verify next",
    signIn = "Sign in",
    yourNumber = "Your Number",
    acceptTerms = "I accept the Terms of Service as well as Privacy Policy",
    verifyYourAccount = "Verify Your Account",
    weHaveSentCode = "We have sent a 4 digit code to the number {phone}",
    didntReceiveCode = "Didn't receive OTP code?",
    resendCode = "Resend Code",
    resendCodeIn = "Resend code in {time}",
)