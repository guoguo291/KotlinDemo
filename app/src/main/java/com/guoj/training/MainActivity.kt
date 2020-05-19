package com.guoj.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.guoj.training.databinding.ActivityMainBinding
import com.guoj.training.vp.RotateFragment
import com.guoj.training.vp.ScaleFragment
import com.guoj.training.vp.TranslationFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVp()
    }

    private fun initVp() {
        viewPager2=binding.vp
        viewPager2.adapter=object : FragmentStateAdapter(this){
            override fun getItemCount(): Int = 3

            override fun createFragment(position: Int): Fragment {
                return when(position){
                    0->RotateFragment()
                    1->ScaleFragment()
                    else->TranslationFragment()
                }
            }

        }
        TabLayoutMediator(binding.tablayout,viewPager2) { tab, position ->
            when(position){
                0->tab.text="旋转"
                1->tab.text="缩放"
                else->tab.text="平移"
            }
        }.attach()
    }
}
