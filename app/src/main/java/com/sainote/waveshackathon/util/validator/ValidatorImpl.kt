package com.sainote.waveshackathon.util.validator

import androidx.databinding.ViewDataBinding
import android.view.View
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import com.google.android.material.textfield.TextInputLayout

class ValidatorImpl(val binding: ViewDataBinding): Validator {

    override val showErrors = MutableLiveData<Boolean>()
    override val hasErrors = MutableLiveData<Boolean>()
    val states = ArrayList<ValidationState>()

    override fun setValidationState(view: View, index: Int, error: Boolean, message: String) {
        states.removeAll { x -> x.view == view && x.index == index }
        states.add(ValidationState(view, index, error, message))
    }

    data class ValidationState (var view: View, var index: Int, var error: Boolean, var message: String)

    override fun validateView(view: View) {
        hasErrors.value = false
        showErrors.value = false
        binding.invalidateAll()
        binding.executePendingBindings()

        val errors = HashMap<View, ArrayList<String>>()

        for (state in states) {
            if (state.view == view) {
                if (state.error) {
                    if (!errors.containsKey(state.view))
                        errors[state.view] = ArrayList()
                    errors[state.view]?.add(state.message)
                }
            }
        }
        hasErrors.value = errors.size > 0

        states.distinctBy { x -> x.view }.filter{ x -> !errors.containsKey(x.view) }.forEach { x -> clearView(x.view) }
        errors.forEach{ x -> setErrorForView(x.key, x.value.joinToString("; ")) }

        if (hasErrors.value == true)
            showErrors.value = true

    }

    override fun validate(): Boolean {
        hasErrors.value = false
        showErrors.value = false
        binding.invalidateAll()
        binding.executePendingBindings()

        val errors = HashMap<View, ArrayList<String>>()

        for (state in states) {
            if (state.error) {
                if (!errors.containsKey(state.view))
                    errors[state.view] = ArrayList()
                errors[state.view]?.add(state.message)
            }
        }
        hasErrors.value = errors.size > 0

        states.distinctBy { x -> x.view }.filter{ x -> !errors.containsKey(x.view) }.forEach { x -> clearView(x.view) }
        errors.forEach{ x -> setErrorForView(x.key, x.value.joinToString("; ")) }

        if (hasErrors.value == true)
            showErrors.value = true

        return hasErrors.value != true
    }

    private fun clearView(view: View) {
        if (view is EditText)
            view.error = null
        if (view is TextInputLayout)
            view.error = null
    }

    private fun setErrorForView(view: View, message: String) {
        if (view is EditText)
            view.error = message
        if (view is TextInputLayout)
            view.error = message
    }

}