package com.example.dynamicimageviewer

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamicimageviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtons()
    }

    private fun setupButtons() {
        binding.apply {
            btnNature.setOnClickListener {
                changeImage(R.drawable.nature_image)
            }

            btnCity.setOnClickListener {
                changeImage(R.drawable.city_image)
            }

            btnFood.setOnClickListener {
                changeImage(R.drawable.food_image)
            }
        }
    }

    private fun changeImage(imageResource: Int) {
        // Create fade out animation
        val fadeOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
        fadeOut.duration = 500

        // Create fade in animation
        val fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        fadeIn.duration = 500

        binding.imageView.startAnimation(fadeOut)
        binding.imageView.setImageResource(imageResource)
        binding.imageView.startAnimation(fadeIn)
    }
}
