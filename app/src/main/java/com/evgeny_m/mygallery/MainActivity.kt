package com.evgeny_m.mygallery

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.evgeny_m.mygallery.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private lateinit var imageView: ImageView
    lateinit var scaleGestureDetector: ScaleGestureDetector

    private var FACTOR = 1.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageView = binding.imageView
        scaleGestureDetector = ScaleGestureDetector(this, scaleListener)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }


    private var scaleListener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            FACTOR *= detector?.scaleFactor ?: FACTOR
            FACTOR = Math.max(0.1f, Math.min(FACTOR, 10.0f))
            imageView.scaleX = FACTOR
            imageView.scaleY = FACTOR
            return true
        }
    }

}





