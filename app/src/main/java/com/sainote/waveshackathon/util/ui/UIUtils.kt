package com.sainote.waveshackathon.util.ui

import java.util.*

interface UIUtils {

    fun hideKeyboard()
    fun showDatePickerDialog(title: String?, date: Date?, minDate: Date?, maxDate: Date?, onDateSelect: (Date) -> Unit)
    fun showSelectFromListDialog(title: String?, items: Map<String, String>, onItemSelect: (String, String) -> Unit)

}