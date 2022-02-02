package id.gits.library.extensions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.pm.PackageInfoCompat
import androidx.fragment.app.Fragment
import java.lang.Exception

private const val TAG = "ContextExt"

fun Context.getAppVersionCode(): Int? {
    try {
        return packageManager?.getPackageInfo(packageName, 0)
            ?.let { PackageInfoCompat.getLongVersionCode(it).toInt() }
    } catch (ex: Exception) {
        Log.e(TAG, ex.message.orEmpty())
    }

    return null
}

fun Context.showToast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(this, message, duration).show()
}

fun Context.hasCameraPermission(): Boolean =
    ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED

fun Context.hasReadExtStoragePermission(): Boolean =
    ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.READ_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED

fun Context.hasWriteExtStoragePermission(): Boolean =
    ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED