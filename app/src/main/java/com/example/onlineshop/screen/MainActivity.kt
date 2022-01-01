package com.example.onlineshop.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.screen.cart.CartFragment
import com.example.onlineshop.screen.favorite.FavoriteFragment
import com.example.onlineshop.screen.home.HomeFragment
import com.example.onlineshop.screen.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val homeFragment = HomeFragment.newInstance()
    val favoriteFragment = FavoriteFragment.newInstance()
    val profileFragment = ProfileFragment.newInstance()
    val cartFragment = CartFragment.newInstance()
    var activeFragment :Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.flContainer,homeFragment,homeFragment.tag).hide(homeFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer,favoriteFragment,favoriteFragment.tag).hide(favoriteFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer,profileFragment,profileFragment.tag).hide(profileFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer,cartFragment,cartFragment.tag).hide(cartFragment).commit()

        supportFragmentManager.beginTransaction().show(activeFragment).commit()

        bottomNavigationView.setOnNavigationItemSelectedListener{

            if (it.itemId == R.id.actionHome){
                supportFragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
                activeFragment = homeFragment
            }else if (it.itemId == R.id.actionFavorit){
                supportFragmentManager.beginTransaction().hide(activeFragment).show(favoriteFragment).commit()
                activeFragment = favoriteFragment
            }else if (it.itemId == R.id.actionCart){
                supportFragmentManager.beginTransaction().hide(activeFragment).show(cartFragment).commit()
                activeFragment = cartFragment
            }else if (it.itemId == R.id.actionProfile){
                supportFragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit()
                activeFragment = profileFragment
            }
            return@setOnNavigationItemSelectedListener true
        }

    }
}