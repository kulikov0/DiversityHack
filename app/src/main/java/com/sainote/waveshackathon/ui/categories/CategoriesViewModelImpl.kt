package com.sainote.waveshackathon.ui.categories

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CategoriesViewModelImpl @Inject constructor(val model: Model): CategoriesViewModel {

    class Model: ViewModel()

}