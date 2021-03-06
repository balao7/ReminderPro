package ir.roohi.farshid.reminderpro.customViews

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import ir.roohi.farshid.reminderpro.R

/**
 * Created by Farshid Roohi.
 * ReminderPro | Copyrights 2018.
 */


class CustomItemView : LinearLayout {


    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.initAttr(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.initAttr(context, attrs)
    }

    private fun initAttr(context: Context, attributeSet: AttributeSet?) {
        if (attributeSet == null) {
            return
        }

        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomItemView)

        val backgroundColor = typedArray.getResourceId(R.styleable.CustomItemView_bgColor, Color.WHITE)
        val icon = typedArray.getResourceId(R.styleable.CustomItemView_item_icon, 0)
        val backgroundRadius = typedArray.getDimension(R.styleable.CustomItemView_item_radius, 10f).toInt()
        val tintColor = typedArray.getResourceId(R.styleable.CustomItemView_android_tint, Color.DKGRAY)
        val title = typedArray.getString(R.styleable.CustomItemView_title)
        val description = typedArray.getString(R.styleable.CustomItemView_description)


        typedArray.recycle()


        val view = LayoutInflater.from(context).inflate(R.layout.custom_item_view, this, true)

        val txtCaption = view.findViewById<TextView>(R.id.txt_caption)
        val txtDescription = view.findViewById<TextView>(R.id.txt_description)
        val imgIcon = view.findViewById<ImageView>(R.id.img_icon)

        if (icon != 0) {
            imgIcon.setImageResource(icon)
            imgIcon.setColorFilter(ContextCompat.getColor(context, tintColor))
        }
        if (title != null) {
            txtCaption.text = title
            txtCaption.setTextColor(ContextCompat.getColor(context, tintColor))
        }

        if (description != null){
            txtDescription.text = description
        }

        val gradientDrawable = GradientDrawable()
        gradientDrawable.setColor(ContextCompat.getColor(context, backgroundColor))
        if (resources.configuration.layoutDirection == 0) {
            gradientDrawable.cornerRadii = floatArrayOf(
                backgroundRadius.toFloat(),
                backgroundRadius.toFloat(),
                0f,
                0f,
                0f,
                0f,
                backgroundRadius.toFloat(),
                backgroundRadius.toFloat()
            )

        } else {
            gradientDrawable.cornerRadii = floatArrayOf(
                0f,
                0f,
                backgroundRadius.toFloat(),
                backgroundRadius.toFloat(),
                backgroundRadius.toFloat(),
                backgroundRadius.toFloat(),
                0f,
                0f
            )
        }

        this.background = gradientDrawable
    }

}
