package com.jp.customsnackbarlibrary

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.ContentViewCallback
import com.jp.customsnackbarlibrary.databinding.CustomSnackbarViewBinding

class CustomSnackBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ContentViewCallback {

    val customSnackbarViewBinding: CustomSnackbarViewBinding =
        CustomSnackbarViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        clipToPadding = false
    }

    override fun animateContentIn(delay: Int, duration: Int) {
        val scaleX = ObjectAnimator.ofFloat(customSnackbarViewBinding.imgVwIcon, View.SCALE_X, 0f, 1f)
        val scaleY = ObjectAnimator.ofFloat(customSnackbarViewBinding.imgVwIcon, View.SCALE_Y, 0f, 1f)
        val animatorSet = AnimatorSet().apply {
            interpolator = OvershootInterpolator()
            setDuration(500)
            playTogether(scaleX, scaleY)
        }
        animatorSet.start()
    }

    override fun animateContentOut(delay: Int, duration: Int) {
    }
}