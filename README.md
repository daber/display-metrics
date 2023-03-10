# display-metrics

Program fetches information about default display metrics
It does following calculations

```kotlin
    val INCH_TO_MM = 25.4f
    val widthPixels = metrics.widthPixels
    val heightPixels = metrics.heightPixels
    val widthInch = widthPixels / metrics.xdpi
    val heightInch = heightPixels / metrics.ydpi
    val widthMM = widthInch *INCH_TO_MM
    val heightMM = heightInch * INCH_TO_MM
    //c^2 = a^2 + b^2
    val diagonalInch = sqrt(widthInch.pow(2f) + heightInch.pow(2f))
```

