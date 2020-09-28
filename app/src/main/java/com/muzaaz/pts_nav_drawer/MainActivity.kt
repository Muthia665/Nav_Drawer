package com.muzaaz.pts_nav_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.muzaaz.pts_nav_drawer.Fragment.DuaFragment
import com.muzaaz.pts_nav_drawer.Fragment.RealFragment
import com.muzaaz.pts_nav_drawer.Fragment.SatuFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerlayout: DrawerLayout
    lateinit var navigationView: NavigationView

    lateinit var satuFragment: SatuFragment
    lateinit var duaFragment: DuaFragment
    lateinit var realFragment: RealFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerlayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        val toogle = ActionBarDrawerToggle(
            this, drawerlayout, toolbar, 0, 0
        )

        drawerlayout.addDrawerListener(toogle)
        toogle.syncState()
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.one -> {
                satuFragment = SatuFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, satuFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.two -> {
                duaFragment = DuaFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, duaFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.real -> {
                realFragment = RealFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, realFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

        }
        drawerlayout.closeDrawer(GravityCompat.START)
        return true

    }
}
