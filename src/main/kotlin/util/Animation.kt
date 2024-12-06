package util
import kotlin.math.*

class Animation {
    fun inoutsine(x: Double, min: Double = 0.0, max: Double = 1.0): Double {
        val clampedX = x.coerceIn(0.0, 1.0)
        return (sin((clampedX * PI) - (PI / 2)) / 2 + 0.5) * (max - min) + min
    }
}
