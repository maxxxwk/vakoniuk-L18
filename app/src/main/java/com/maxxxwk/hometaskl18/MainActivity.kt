package com.maxxxwk.hometaskl18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.maxxxwk.hometaskl18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(this, getFragments())
        val tabs =
            listOf(
                getString(R.string.drawble_tab_text), getString(R.string.bitmap_tab_text),
                getString(R.string.glide_tab_text)
            )
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }

    private fun getFragments() = listOf(
        DrawableFragment.newInstance(),
        BitmapFragment.newInstance(),
        GlideFragment.newInstance()
    )
}