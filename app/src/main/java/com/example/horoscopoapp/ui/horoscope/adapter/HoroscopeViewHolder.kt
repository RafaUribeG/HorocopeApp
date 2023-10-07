package com.example.horoscopoapp.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.databinding.ItemHoroscopeBinding
import com.example.horoscopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo) {
        with(binding){
            val context = tvTittle.context
            ivHoroscope.setImageResource(horoscopeInfo.img)
            tvTittle.text = context.getString(horoscopeInfo.name)
        }
    }
}