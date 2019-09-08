package com.sainote.waveshackathon.ui.profile

import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.sainote.waveshackathon.ui.base.viewmodel.BaseViewModelSimple
import com.sainote.waveshackathon.util.navigator.Navigator
import com.sainote.waveshackathon.util.session.SessionManager
import com.wavesplatform.sdk.WavesSdk
import com.wavesplatform.sdk.utils.RxUtil
import com.wavesplatform.sdk.utils.getScaledAmount
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProfileViewModelImpl @Inject constructor(val model: Model,
                                               lifecycle: Lifecycle,
                                               val navigator: Navigator,
                                               val fragment: ProfileFragment,
                                               val sessionManager: SessionManager) : BaseViewModelSimple(lifecycle), ProfileVIewModel {

    private val compositeDisposable = CompositeDisposable()

    private val delay: Long = 2000L

    val handler = Handler()

    private var runnable: Runnable = object : Runnable {
        override fun run() {
            try {
                balance.postValue("${sessionManager.user!!.amount} FW")
                //getWavesBalance(sessionManager.user!!.seed)
                handler.postDelayed(this, delay)
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
    }

    override fun onStart() {
        super.onStart()
        handler.postDelayed(runnable, delay)
    }



    override val userPhoto = MutableLiveData<String>().apply { value = "https://i.pinimg.com/originals/93/fb/2d/93fb2dd2a8e0fb0fcfc7ad7b31e5229d.jpg" }

    override val name = MutableLiveData<String>().apply { value = "Test User" }

    override val seed = MutableLiveData<String>().apply { value = sessionManager.user!!.seed }

    override val balance = MutableLiveData<String>()

    override val executing = MutableLiveData<Boolean>()

    private fun getWavesBalance(address: String) {
        compositeDisposable.add(
            WavesSdk.service()
                .getNode() // You can choose different Waves services: node, matcher and data service
                .assetsBalance(address, "43YQoMxd76p3WUpQvaHm2V6LpmP6NcPaY2maTruzTdfU") // Here methods of service
                .compose(RxUtil.applyObservableDefaultSchedulers())
                .subscribe({ response ->
                    // Do something on success, now we have wavesBalance.balance in satoshi in Long
                    balance.postValue("Balance : ${getScaledAmount(response.balance, 8)} forumWAVES")
                }, { error ->
                    // Do something on fail
                    val errorMessage = "Can't get addressesBalance! + ${error.message}"
                    Log.e("MainActivity", errorMessage)
                    error.printStackTrace()
                })
        )
    }


    override fun onLogoutClicked() {
        sessionManager.logout()
        navigator.openAuthScreen()
    }


    class Model: ViewModel()

}