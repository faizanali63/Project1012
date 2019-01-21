package com.example.faizan.project101

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListAdapter


class MainActivity : AppCompatActivity() {

    private val apkList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {
            getApps()
        }

    }

    fun getApps()
    {
        val packList = packageManager.getInstalledPackages(0)       //Getting the list of all the installed packages in the system
        for (i in packList.indices)         // for(i=0;i<=packklist.size();i++), indices is a pre-defined variable to get the index of the collection
        {
            val packInfo = packList[i]

            if (packInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM == 0)
            {
                val appName = packInfo.applicationInfo.loadLabel(packageManager).toString()
                apkList.add(appName)
            }
        }
        /*var myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, apkList)
        lview.adapter = myAdapter*/


        var myAdapter = ArrayAdapter<String>(this, R.layout.apps_installed, apkList)
        lview.adapter = myAdapter
    }
}

