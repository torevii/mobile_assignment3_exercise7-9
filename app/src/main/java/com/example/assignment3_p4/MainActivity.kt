package com.example.assignment3_p4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3_p4.fragments.UserListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, UserListFragment())
                .commit()
        }
    }
}
