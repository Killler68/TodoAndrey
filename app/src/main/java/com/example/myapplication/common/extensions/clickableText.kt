package com.example.myapplication.common.extensions

import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import java.util.regex.Pattern

fun Fragment.clickableText(
    text: String,
    clickableText: String,
    click: () -> Unit,
    textView: TextView
) {

    val spannableString = SpannableString(text)

    val pattern = Pattern.compile("(.*)($clickableText)(.*)")
    val matcher = pattern.matcher(text).also { it.find() }

    val clickableSpan = object : ClickableSpan() {
        override fun updateDrawState(ds: TextPaint) {
            ds.color = resources.getColor(R.color.primary_light)
            ds.isUnderlineText = false
        }

        override fun onClick(view: View) {
            click()
        }
    }

    val start = matcher.group(1)?.length ?: 0
    val end = start + (matcher.group(2)?.length ?: 0)

    spannableString.setSpan(
        clickableSpan,
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE,
    )

    textView.movementMethod = LinkMovementMethod.getInstance()
    textView.setText(spannableString, TextView.BufferType.SPANNABLE)
}
