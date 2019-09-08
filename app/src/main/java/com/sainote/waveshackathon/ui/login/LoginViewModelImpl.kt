package com.sainote.waveshackathon.ui.login

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sainote.waveshackathon.data.model.User
import com.sainote.waveshackathon.util.navigator.Navigator
import com.sainote.waveshackathon.util.session.SessionManager
import javax.inject.Inject

class LoginViewModelImpl @Inject constructor(val navigator: Navigator,
                                             val sessionManager: SessionManager,
                                             val model: Model): LoginViewModel {

    override val buttonEnabled = Transformations.map(login) {it.length > 5}

    override val executing = MutableLiveData<Boolean>()

    override val login: MutableLiveData<String>
        get() = model.login

    override fun onLoginClicked() {
        executing.postValue(true)
        Handler().postDelayed({
            executing.postValue(false)
            if (login.value == "3N3dfnsDCM6fPtpUkEE8G9uUrxuoiXZPa7J" || login.value == "3MzToKQZvzyW5kSyyubwnm4XYPSLUssm46Z") {
                sessionManager.user = User(seed = login.value!!, amount = 10000)
                navigator.openMainScreen()
            } else navigator.makeToast("Unknown seed")
        }, 1000)
    }

    class Model: ViewModel() {
        val login = MutableLiveData<String>()
    }

}