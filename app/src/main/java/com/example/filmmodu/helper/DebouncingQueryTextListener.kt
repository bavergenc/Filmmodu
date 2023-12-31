package com.redroid.iptv.util.helper

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DebouncingQueryTextListener(
    lifecycle: Lifecycle,
    private val onDebouncingQueryTextChange: (String?) -> Unit
) : TextWatcher {
    private var debouncePeriod: Long = 800

    private val coroutineScope = lifecycle.coroutineScope
    private var searchJob: Job? = null

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        searchJob?.cancel()
        searchJob = coroutineScope.launch {
            s.toString().let {
                delay(debouncePeriod)
                onDebouncingQueryTextChange(it)
            }
        }
    }

}