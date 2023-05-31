package com.toptop.provider.android.designsystem.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val AppLogo: ImageVector
    get() {
        if (_amazon != null) return _amazon!!

        _amazon = Builder(
            name = "Amazon", defaultWidth = 500.0.dp, defaultHeight = 151.0.dp,
            viewportWidth = 500.0f, viewportHeight = 151.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF696CFF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(310.121f, 117.897f)
                    curveTo(281.1f, 139.288f, 239.036f, 150.701f, 202.819f, 150.701f)
                    curveTo(152.038f, 150.701f, 106.321f, 131.919f, 71.735f, 100.68f)
                    curveTo(69.018f, 98.224f, 71.452f, 94.876f, 74.713f, 96.789f)
                    curveTo(112.039f, 118.506f, 158.19f, 131.571f, 205.863f, 131.571f)
                    curveTo(238.014f, 131.571f, 273.383f, 124.919f, 305.904f, 111.115f)
                    curveTo(310.817f, 109.028f, 314.926f, 114.332f, 310.121f, 117.897f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF696CFF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(322.186f, 104.093f)
                    curveTo(318.491f, 99.354f, 297.665f, 101.854f, 288.318f, 102.963f)
                    curveTo(285.47f, 103.311f, 285.035f, 100.832f, 287.6f, 99.05f)
                    curveTo(304.187f, 87.376f, 331.404f, 90.746f, 334.577f, 94.659f)
                    curveTo(337.751f, 98.593f, 333.751f, 125.875f, 318.165f, 138.897f)
                    curveTo(315.773f, 140.897f, 313.491f, 139.832f, 314.556f, 137.18f)
                    curveTo(318.056f, 128.441f, 325.904f, 108.854f, 322.186f, 104.093f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF696CFF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(288.97f, 16.639f)
                    verticalLineTo(5.291f)
                    curveTo(288.97f, 3.574f, 290.274f, 2.421f, 291.839f, 2.421f)
                    horizontalLineTo(342.642f)
                    curveTo(344.273f, 2.421f, 345.577f, 3.595f, 345.577f, 5.291f)
                    verticalLineTo(15.008f)
                    curveTo(345.555f, 16.639f, 344.186f, 18.769f, 341.751f, 22.138f)
                    lineTo(315.426f, 59.724f)
                    curveTo(325.208f, 59.485f, 335.534f, 60.942f, 344.403f, 65.942f)
                    curveTo(346.403f, 67.072f, 346.947f, 68.724f, 347.099f, 70.355f)
                    verticalLineTo(82.463f)
                    curveTo(347.099f, 84.115f, 345.273f, 86.05f, 343.36f, 85.05f)
                    curveTo(327.73f, 76.855f, 306.969f, 75.963f, 289.687f, 85.137f)
                    curveTo(287.926f, 86.094f, 286.078f, 84.181f, 286.078f, 82.528f)
                    verticalLineTo(71.029f)
                    curveTo(286.078f, 69.181f, 286.1f, 66.029f, 287.948f, 63.224f)
                    lineTo(318.447f, 19.486f)
                    horizontalLineTo(291.904f)
                    curveTo(290.274f, 19.486f, 288.97f, 18.334f, 288.97f, 16.639f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF696CFF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(103.647f, 87.441f)
                    horizontalLineTo(88.191f)
                    curveTo(86.713f, 87.333f, 85.539f, 86.224f, 85.43f, 84.811f)
                    verticalLineTo(5.486f)
                    curveTo(85.43f, 3.9f, 86.757f, 2.639f, 88.409f, 2.639f)
                    horizontalLineTo(102.821f)
                    curveTo(104.321f, 2.704f, 105.517f, 3.856f, 105.626f, 5.291f)
                    verticalLineTo(15.66f)
                    horizontalLineTo(105.908f)
                    curveTo(109.669f, 5.639f, 116.734f, 0.965f, 126.256f, 0.965f)
                    curveTo(135.929f, 0.965f, 141.973f, 5.639f, 146.32f, 15.66f)
                    curveTo(150.06f, 5.639f, 158.559f, 0.965f, 167.668f, 0.965f)
                    curveTo(174.146f, 0.965f, 181.233f, 3.639f, 185.559f, 9.639f)
                    curveTo(190.45f, 16.312f, 189.45f, 26.008f, 189.45f, 34.508f)
                    lineTo(189.428f, 84.572f)
                    curveTo(189.428f, 86.159f, 188.102f, 87.441f, 186.45f, 87.441f)
                    horizontalLineTo(171.016f)
                    curveTo(169.472f, 87.333f, 168.233f, 86.093f, 168.233f, 84.572f)
                    verticalLineTo(42.529f)
                    curveTo(168.233f, 39.181f, 168.537f, 30.834f, 167.798f, 27.66f)
                    curveTo(166.646f, 22.334f, 163.19f, 20.834f, 158.712f, 20.834f)
                    curveTo(154.972f, 20.834f, 151.059f, 23.334f, 149.473f, 27.334f)
                    curveTo(147.886f, 31.334f, 148.038f, 38.029f, 148.038f, 42.529f)
                    verticalLineTo(84.572f)
                    curveTo(148.038f, 86.159f, 146.712f, 87.441f, 145.06f, 87.441f)
                    horizontalLineTo(129.625f)
                    curveTo(128.06f, 87.333f, 126.843f, 86.093f, 126.843f, 84.572f)
                    lineTo(126.821f, 42.529f)
                    curveTo(126.821f, 33.682f, 128.277f, 20.66f, 117.299f, 20.66f)
                    curveTo(106.191f, 20.66f, 106.626f, 33.355f, 106.626f, 42.529f)
                    verticalLineTo(84.572f)
                    curveTo(106.626f, 86.159f, 105.3f, 87.441f, 103.647f, 87.441f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF696CFF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(389.315f, 0.965f)
                    curveTo(412.25f, 0.965f, 424.662f, 20.66f, 424.662f, 45.703f)
                    curveTo(424.662f, 69.898f, 410.945f, 89.093f, 389.315f, 89.093f)
                    curveTo(366.794f, 89.093f, 354.534f, 69.398f, 354.534f, 44.855f)
                    curveTo(354.534f, 20.16f, 366.946f, 0.965f, 389.315f, 0.965f)
                    close()
                    moveTo(389.446f, 17.16f)
                    curveTo(378.055f, 17.16f, 377.337f, 32.682f, 377.337f, 42.355f)
                    curveTo(377.337f, 52.051f, 377.185f, 72.746f, 389.315f, 72.746f)
                    curveTo(401.293f, 72.746f, 401.859f, 56.051f, 401.859f, 45.877f)
                    curveTo(401.859f, 39.181f, 401.576f, 31.182f, 399.554f, 24.834f)
                    curveTo(397.815f, 19.312f, 394.359f, 17.16f, 389.446f, 17.16f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF696CFF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(454.401f, 87.441f)
                    horizontalLineTo(439.01f)
                    curveTo(437.467f, 87.333f, 436.227f, 86.093f, 436.227f, 84.572f)
                    lineTo(436.206f, 5.226f)
                    curveTo(436.336f, 3.769f, 437.619f, 2.639f, 439.184f, 2.639f)
                    horizontalLineTo(453.51f)
                    curveTo(454.858f, 2.704f, 455.966f, 3.617f, 456.271f, 4.856f)
                    verticalLineTo(16.986f)
                    horizontalLineTo(456.553f)
                    curveTo(460.879f, 6.139f, 466.944f, 0.965f, 477.618f, 0.965f)
                    curveTo(484.553f, 0.965f, 491.313f, 3.465f, 495.661f, 10.313f)
                    curveTo(499.704f, 16.66f, 499.704f, 27.334f, 499.704f, 35.008f)
                    verticalLineTo(84.941f)
                    curveTo(499.531f, 86.333f, 498.248f, 87.441f, 496.726f, 87.441f)
                    horizontalLineTo(481.227f)
                    curveTo(479.813f, 87.333f, 478.64f, 86.289f, 478.487f, 84.941f)
                    verticalLineTo(41.855f)
                    curveTo(478.487f, 33.182f, 479.487f, 20.486f, 468.814f, 20.486f)
                    curveTo(465.053f, 20.486f, 461.596f, 23.008f, 459.879f, 26.834f)
                    curveTo(457.705f, 31.682f, 457.423f, 36.508f, 457.423f, 41.855f)
                    verticalLineTo(84.572f)
                    curveTo(457.401f, 86.159f, 456.053f, 87.441f, 454.401f, 87.441f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF696CFF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(248.471f, 49.551f)
                    verticalLineTo(46.203f)
                    curveTo(237.297f, 46.203f, 225.493f, 48.594f, 225.493f, 61.768f)
                    curveTo(225.493f, 68.442f, 228.949f, 72.964f, 234.884f, 72.964f)
                    curveTo(239.232f, 72.964f, 243.123f, 70.29f, 245.579f, 65.942f)
                    curveTo(248.623f, 60.594f, 248.471f, 55.572f, 248.471f, 49.551f)
                    close()
                    moveTo(264.057f, 87.224f)
                    curveTo(263.035f, 88.137f, 261.557f, 88.202f, 260.405f, 87.594f)
                    curveTo(255.275f, 83.333f, 254.362f, 81.355f, 251.536f, 77.289f)
                    curveTo(243.058f, 85.941f, 237.058f, 88.528f, 226.058f, 88.528f)
                    curveTo(213.058f, 88.528f, 202.928f, 80.507f, 202.928f, 64.442f)
                    curveTo(202.928f, 51.899f, 209.732f, 43.355f, 219.406f, 39.182f)
                    curveTo(227.797f, 35.486f, 239.514f, 34.834f, 248.471f, 33.812f)
                    verticalLineTo(31.812f)
                    curveTo(248.471f, 28.138f, 248.753f, 23.791f, 246.601f, 20.617f)
                    curveTo(244.71f, 17.769f, 241.101f, 16.595f, 237.927f, 16.595f)
                    curveTo(232.036f, 16.595f, 226.775f, 19.617f, 225.493f, 25.878f)
                    curveTo(225.232f, 27.269f, 224.21f, 28.638f, 222.819f, 28.704f)
                    lineTo(207.819f, 27.095f)
                    curveTo(206.558f, 26.812f, 205.167f, 25.791f, 205.515f, 23.856f)
                    curveTo(208.971f, 5.682f, 225.384f, 0.204f, 240.079f, 0.204f)
                    curveTo(247.601f, 0.204f, 257.427f, 2.204f, 263.361f, 7.9f)
                    curveTo(270.883f, 14.921f, 270.166f, 24.291f, 270.166f, 34.486f)
                    verticalLineTo(58.572f)
                    curveTo(270.166f, 65.811f, 273.166f, 68.985f, 275.992f, 72.898f)
                    curveTo(276.992f, 74.289f, 277.209f, 75.963f, 275.948f, 77.007f)
                    curveTo(272.796f, 79.637f, 267.188f, 84.528f, 264.101f, 87.268f)
                    lineTo(264.057f, 87.224f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF696CFF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(45.844f, 49.551f)
                    verticalLineTo(46.203f)
                    curveTo(34.671f, 46.203f, 22.867f, 48.594f, 22.867f, 61.768f)
                    curveTo(22.867f, 68.442f, 26.323f, 72.964f, 32.258f, 72.964f)
                    curveTo(36.605f, 72.964f, 40.497f, 70.29f, 42.953f, 65.942f)
                    curveTo(45.996f, 60.594f, 45.844f, 55.572f, 45.844f, 49.551f)
                    close()
                    moveTo(61.431f, 87.224f)
                    curveTo(60.409f, 88.137f, 58.931f, 88.202f, 57.779f, 87.594f)
                    curveTo(52.649f, 83.333f, 51.736f, 81.355f, 48.91f, 77.289f)
                    curveTo(40.431f, 85.941f, 34.431f, 88.528f, 23.432f, 88.528f)
                    curveTo(10.432f, 88.528f, 0.302f, 80.507f, 0.302f, 64.442f)
                    curveTo(0.302f, 51.899f, 7.106f, 43.355f, 16.78f, 39.182f)
                    curveTo(25.171f, 35.486f, 36.888f, 34.834f, 45.844f, 33.812f)
                    verticalLineTo(31.812f)
                    curveTo(45.844f, 28.138f, 46.127f, 23.791f, 43.975f, 20.617f)
                    curveTo(42.083f, 17.769f, 38.475f, 16.595f, 35.301f, 16.595f)
                    curveTo(29.41f, 16.595f, 24.149f, 19.617f, 22.867f, 25.878f)
                    curveTo(22.606f, 27.269f, 21.584f, 28.638f, 20.193f, 28.704f)
                    lineTo(5.193f, 27.095f)
                    curveTo(3.932f, 26.812f, 2.541f, 25.791f, 2.889f, 23.856f)
                    curveTo(6.345f, 5.682f, 22.758f, 0.204f, 37.453f, 0.204f)
                    curveTo(44.975f, 0.204f, 54.801f, 2.204f, 60.735f, 7.9f)
                    curveTo(68.257f, 14.921f, 67.539f, 24.291f, 67.539f, 34.486f)
                    verticalLineTo(58.572f)
                    curveTo(67.539f, 65.811f, 70.539f, 68.985f, 73.366f, 72.898f)
                    curveTo(74.366f, 74.289f, 74.583f, 75.963f, 73.322f, 77.007f)
                    curveTo(70.17f, 79.637f, 64.561f, 84.528f, 61.474f, 87.268f)
                    lineTo(61.431f, 87.224f)
                    close()
                }
            }
        }.build()

        return _amazon!!
    }

private var _amazon: ImageVector? = null
