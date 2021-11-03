/*
import android.content.Context.WINDOW_SERVICE
import android.graphics.Point
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

fun cut(){
    val screenDimensions = IntArray(2) // width[0], height[1]
    val x: Int
    val y: Int
*/
/*
        val orientation = context.resources.configuration.orientation
*//*


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
        val screenSize = Point()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            d.getRealSize(screenSize)
            x = screenSize.x
            y = screenSize.y
        } else {
            d.getSize(screenSize)
            x = screenSize.x
            y = screenSize.y
        }
    } else {
        x = d.width
        y = d.height
    }
    screenDimensions[0] = x  // width
    screenDimensions[1] = y // height
    Log.i("MainActivity", "$screenDimensions[0]\n")
    Log.i("MainActivity", "$screenDimensions[1]\n")
}*/
