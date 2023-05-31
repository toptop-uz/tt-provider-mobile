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

val Russian: ImageVector
    get() {
        if (_russian != null) return _russian!!

        _russian = Builder(
            name = "Russia", defaultWidth = 512.0.dp, defaultHeight = 512.0.dp,
            viewportWidth = 512.0f, viewportHeight = 512.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFF0F0F0)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(256.0f, 512.0f)
                    curveTo(397.385f, 512.0f, 512.0f, 397.385f, 512.0f, 256.0f)
                    curveTo(512.0f, 114.615f, 397.385f, 0.0f, 256.0f, 0.0f)
                    curveTo(114.615f, 0.0f, 0.0f, 114.615f, 0.0f, 256.0f)
                    curveTo(0.0f, 397.385f, 114.615f, 512.0f, 256.0f, 512.0f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF0052B4)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(496.077f, 345.043f)
                    curveTo(506.368f, 317.31f, 512.0f, 287.314f, 512.0f, 256.0f)
                    curveTo(512.0f, 224.686f, 506.368f, 194.69f, 496.077f, 166.957f)
                    horizontalLineTo(15.923f)
                    curveTo(5.633f, 194.69f, 0.0f, 224.686f, 0.0f, 256.0f)
                    curveTo(0.0f, 287.314f, 5.633f, 317.31f, 15.923f, 345.043f)
                    lineTo(256.0f, 367.304f)
                    lineTo(496.077f, 345.043f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFD80027)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(256.0f, 512.0f)
                    curveTo(366.071f, 512.0f, 459.906f, 442.528f, 496.077f, 345.043f)
                    horizontalLineTo(15.923f)
                    curveTo(52.094f, 442.528f, 145.929f, 512.0f, 256.0f, 512.0f)
                    close()
                }
            }
        }.build()

        return _russian!!
    }

private var _russian: ImageVector? = null
