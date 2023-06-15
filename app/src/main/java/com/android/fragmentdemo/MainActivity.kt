package com.android.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.android.fragmentdemo.ui.Fragment1
import com.android.fragmentdemo.ui.Fragment2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Fragment2.newInstance()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment

        findViewById<Button>(R.id.btn1).setOnClickListener {
            navHostFragment.navController.navigateUp()
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            navHostFragment.navController.navigate(R.id.action_fragment1_to_fragment2)
        }

    }
}