package com.android.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.android.fragmentdemo.ui.Fragment1
import com.android.fragmentdemo.ui.Fragment2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Fragment2.newInstance()

        val fragment1 = Fragment1.newInstance()
        val fragment2 = Fragment2.newInstance()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragmentContainerView2, fragment1, "fragment1")
            commit()
            println("size==>${supportFragmentManager.fragments.size}")
        }

        findViewById<Button>(R.id.btn1).setOnClickListener {
            fragment1.apply {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView2,fragment1,"fragment1")
                    show(fragment1)
                    println("size==>${supportFragmentManager.fragments.size}")
                    commit()
                }
            }
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            fragment2.apply {
                supportFragmentManager.beginTransaction().apply {
                    if (isAdded) {
                        hide(fragment1)
                        show(fragment2)
                        println("isAdded")
                    } else {
                        hide(fragment1)
                        //add一定要写上R.id.fragmentContainerView2
                        add(
                            R.id.fragmentContainerView2,
                            fragment2,
                            "fragment2"
                        )
                        show(fragment2)
                    }
                    println("size==>${supportFragmentManager.fragments.size}")
                    commit()
                }
            }
        }
    }
}