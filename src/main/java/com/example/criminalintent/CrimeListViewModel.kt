package com.example.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criminalintent.database.CrimeRepository
import kotlinx.coroutines.launch

private const val TAG = "CrimeListViewModel"
class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimes = mutableListOf<Crime>()

    init {
        Log.d(TAG, "init started")
        viewModelScope.launch {
            Log.d(TAG, "coroutine launched")
            crimes += loadCrimes()
            Log.d(TAG, "Loading crimes finished")
        }
    }


    suspend fun loadCrimes(): List<Crime> {
        return crimeRepository.getCrimes()
    }
}