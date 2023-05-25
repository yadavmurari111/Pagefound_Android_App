package com.example.pagefound

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

//fun replace() {
//
//        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
//        ft.add(R.id.fragment_container_view_tag, UserHomeFragment())
//        Toast.makeText(this, "Fragment is replaced!!!!!!", Toast.LENGTH_SHORT).show();
//        ft.addToBackStack(null);
//        ft.commit();
//
//    }