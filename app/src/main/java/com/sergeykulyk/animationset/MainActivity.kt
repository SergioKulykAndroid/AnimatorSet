package com.sergeykulyk.animationset

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val SEARCH_ANIMATION_DURATION: Long = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search.setOnClickListener { v ->
            run {
                val displayMetrics: DisplayMetrics = resources.displayMetrics
                val modifierX = (-(displayMetrics.widthPixels - v.width)).toFloat()

                val searchIconLeftAnimation = ObjectAnimator.ofFloat(v, "translationX", modifierX)
                searchIconLeftAnimation.duration = SEARCH_ANIMATION_DURATION

                val logoFadeOutAnimation = ObjectAnimator.ofFloat(logo, "alpha", 1f, 0f)
                logoFadeOutAnimation.duration = SEARCH_ANIMATION_DURATION

                val cancelFadeInAnimation = ObjectAnimator.ofFloat(cancel, "alpha", 0f, 1f)
                cancelFadeInAnimation.duration = SEARCH_ANIMATION_DURATION

                val searchEditTextAnimation = ObjectAnimator.ofFloat(editText, "alpha", 0f, 1f)
                searchEditTextAnimation.duration = SEARCH_ANIMATION_DURATION

                val animatorSet = AnimatorSet()
                animatorSet.play(searchIconLeftAnimation).with(logoFadeOutAnimation)
                animatorSet.play(searchIconLeftAnimation).with(cancelFadeInAnimation)
                animatorSet.play(searchIconLeftAnimation).with(searchEditTextAnimation)
                animatorSet.start()
            }
        }

        cancel.setOnClickListener {
            val searchIconRightAnimator = ObjectAnimator.ofFloat(search, "translationX", 0f)
            searchIconRightAnimator.duration = SEARCH_ANIMATION_DURATION

            val logoFadeInAnimator = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f)
            logoFadeInAnimator.duration = SEARCH_ANIMATION_DURATION

            val cancelFadeOutAnimator = ObjectAnimator.ofFloat(cancel, "alpha", 1f, 0f)
            cancelFadeOutAnimator.duration = SEARCH_ANIMATION_DURATION

            val searchEditTextAnimator = ObjectAnimator.ofFloat(editText, "alpha", 1f, 0f)
            searchEditTextAnimator.duration = SEARCH_ANIMATION_DURATION

            val animatorSet = AnimatorSet()
            animatorSet.play(searchIconRightAnimator).with(logoFadeInAnimator)
            animatorSet.play(searchIconRightAnimator).with(cancelFadeOutAnimator)
            animatorSet.play(searchIconRightAnimator).with(searchEditTextAnimator)
            animatorSet.start()
        }
    }
}
