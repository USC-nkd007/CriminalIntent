package com.example.criminalintent

import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.databinding.ListItemCrimeBinding
import com.google.android.material.snackbar.Snackbar

class CrimeHolder(
    val binding: ListItemCrimeBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Snackbar.make(it, "${crime.title} clicked!", Snackbar.LENGTH_SHORT).show()
        }
    }
}