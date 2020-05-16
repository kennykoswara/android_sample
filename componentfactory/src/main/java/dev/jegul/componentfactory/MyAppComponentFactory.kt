package dev.jegul.componentfactory

import android.app.Activity
import android.content.Intent
import androidx.core.app.AppComponentFactory

/**
 * Created by jegul on 16/05/20
 */
class MyAppComponentFactory : AppComponentFactory() {

    override fun instantiateActivityCompat(
        cl: ClassLoader,
        className: String,
        intent: Intent?
    ): Activity {
        val activityClass = cl.loadClass(className)
        return if (activityClass == MainActivity::class.java) MainActivity("This is injected")
        else super.instantiateActivityCompat(cl, className, intent)
    }
}