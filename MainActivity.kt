package com.example.faizan.project101

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.util.Log
import java.nio.file.Files.size



class MainActivity : AppCompatActivity() {

    lateinit var apps: ArrayList<ApplicationInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun getInstalledApps() {
        var count: Int = 0
        var appInfo: ApplicationInfo? = null

        val packList = packageManager.getInstalledPackages(0)
        for (i in packList.indices) {
            val packInfo = packList[i]
            if (packInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM == 0) {
                val appName = packInfo.applicationInfo.loadLabel(packageManager).toString()
                count++
                Log.e("App № " + Integer.toString(i), appName)
                apps.add(packList[i].applicationInfo)
            }
        }
    }
}
