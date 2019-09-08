package com.sainote.waveshackathon.util.ui

import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import android.app.Activity
import android.app.DatePickerDialog
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.*
import javax.inject.Inject

class UIUtilsImpl @Inject constructor(var context: BaseActivity): UIUtils {

    override fun showDatePickerDialog(title: String?, date: Date?, minDate: Date?, maxDate: Date?, onDateSelect: (Date) -> Unit) {
        val c = Calendar.getInstance()
        if (date != null)
            c.time = date
        val dialog = DatePickerDialog(context,
            { _, y, m, d ->
                val nc = Calendar.getInstance()
                nc.set(y, m, d)
                onDateSelect(nc.time)
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
        if (title != null) dialog.setTitle(title)
        if (minDate != null)
            dialog.datePicker.minDate = minDate.time
        if (maxDate != null)
            dialog.datePicker.maxDate = maxDate.time
        dialog.show()
    }

    override fun hideKeyboard() {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = context.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(context)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun showSelectFromListDialog(title: String?, items: Map<String, String>, onItemSelect: (String, String) -> Unit) {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(context)
        if (title != null) dialog.setTitle(title)
        val listItems = items.keys.toTypedArray()
        dialog.setItems(
            listItems
        ) { _, itemPosition ->
            onItemSelect(listItems[itemPosition], items.getValue(listItems[itemPosition]))
        }
        dialog.show()
    }

}