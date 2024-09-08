package com.ndregt.project.curvebottom_nav

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.ndregt.project.curvebottom_nav.fragments.HomeFragment
import com.ndregt.project.curvebottom_nav.fragments.NotificationFragment
import com.ndregt.project.curvebottom_nav.fragments.ProfileFragment
import com.ndregt.project.curvebottom_nav.fragments.SettingFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1, "Home", R.drawable.ic_home)
        )

        bottomNavigation.add(
            CurvedBottomNavigation.Model(2, "Notification", R.drawable.ic_notification)
        )

        bottomNavigation.add(
            CurvedBottomNavigation.Model(3, "Setting", R.drawable.ic_setting)
        )

        bottomNavigation.add(
            CurvedBottomNavigation.Model(4, "Profile", R.drawable.ic_profile)
        )

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1 -> {
                    replaceFragment(HomeFragment())
                }

                2 -> {
                    replaceFragment(NotificationFragment())
                }

                3 -> {
                    replaceFragment(SettingFragment())
                }

                4 -> {
                    replaceFragment(ProfileFragment())
                }
            }
        }

        // default Bottom Tab Selected
        replaceFragment(HomeFragment())
        bottomNavigation.show(1)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}