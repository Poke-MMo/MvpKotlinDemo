package com.xp.mvptest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    val b = "1"
    val array = arrayOf(1, 2, 3, 4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*for (i in array.indices) {
            println(array[i])
        }*/
        val tvContent : TextView = find(R.id.tv_content)
//        tvContent.onClick { startActivity<FlexBoxActivity>() }
        tvContent.onClick { startActivity<CustomerActivity>() }
    }
}
