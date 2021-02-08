package com.jp.customsnackbarlibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.jp.customsnackbarlibrary.databinding.CustomSnackbarViewInflationBinding

class CustomSnackBar(
    parent: ViewGroup,
    content: CustomSnackBarView
) : BaseTransientBottomBar<CustomSnackBar>(parent, content, content) {

    init {
        getView().setBackgroundColor(
            ContextCompat.getColor(
                view.context,
                android.R.color.transparent
            )
        )
        getView().setPadding(0, 0, 0, 0)
    }

    companion object {

        fun make(
            view: View,
            message: String,
            duration: Int,
            listener: View.OnClickListener? = null,
            icon: Int? = null,
            actionLabel: String? = null,
            bgColor: Int? = null
        ): CustomSnackBar {

            val parent = view.findSuitableParent() ?: throw IllegalArgumentException(

            )

            val customSnackbarViewInflationBinding = CustomSnackbarViewInflationBinding
                .inflate(LayoutInflater.from(view.context), parent, false)

            val customView = customSnackbarViewInflationBinding.root.customSnackbarViewBinding

            customView.txtVwMessage.text = message

            actionLabel?.let {
                customView.txtVwAction.text = actionLabel
                customView.txtVwAction.setOnClickListener {
                    listener?.onClick(customView.txtVwAction)
                }
            }

            if (icon != null) {
                customView.imgVwIcon.setImageResource(icon)
            } else {
                customView.imgVwIcon.visibility = View.GONE
            }

            bgColor?.let { customView.snackConstraint.setBackgroundColor(it) }

            return CustomSnackBar(
                parent,
                customView.root as CustomSnackBarView
            ).setDuration(duration)
        }

        private fun View?.findSuitableParent(): ViewGroup? {
            var view = this
            var fallback: ViewGroup? = null
            do {
                if (view is CoordinatorLayout) {
                    return view
                } else if (view is FrameLayout) {
                    if (view.id == android.R.id.content) {
                        return view
                    } else {
                        fallback = view
                    }
                }

                if (view != null) {
                    val parent = view.parent
                    view = if (parent is View) parent else null
                }
            } while (view != null)

            return fallback
        }
    }
}

