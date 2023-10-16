package com.example.horoscopoapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.databinding.ItemHoroscopeBinding
import com.example.horoscopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        with(binding) {
            val context = tvTittle.context
            ivHoroscope.setImageResource(horoscopeInfo.img)
            tvTittle.text = context.getString(horoscopeInfo.name)
            parent.setOnClickListener {
                startRotationAnimation(ivHoroscope, newLambda = { onItemSelected(horoscopeInfo) })
                //onItemSelected(horoscopeInfo)
            }
        }


    }

    private fun startRotationAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLambda() }
            start()
        }
    }
}