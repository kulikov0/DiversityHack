package com.sainote.waveshackathon.ui.author

import android.annotation.SuppressLint
import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sainote.waveshackathon.data.model.News
import com.sainote.waveshackathon.data.model.User
import com.sainote.waveshackathon.util.navigator.Navigator
import com.sainote.waveshackathon.util.session.SessionManager
import com.sainote.waveshackathon.util.ui.UIUtils
import com.wavesplatform.sdk.WavesSdk
import com.wavesplatform.sdk.keeper.interfaces.KeeperCallback
import com.wavesplatform.sdk.keeper.model.KeeperResult
import com.wavesplatform.sdk.model.request.node.TransferTransaction
import com.wavesplatform.sdk.model.response.node.transaction.TransferTransactionResponse
import com.wavesplatform.sdk.utils.RxUtil
import com.wavesplatform.sdk.utils.SignUtil
import com.wavesplatform.sdk.utils.WavesConstants
import javax.inject.Inject

class AuthorProfileViewModelImpl @Inject constructor(val fragment: AuthorProfileFragment,
                                                     val uiUtils: UIUtils,
                                                     val navigator: Navigator,
                                                     val sessionManager: SessionManager):
        AuthorProfileViewModel {

    override val news: News
        get() = fragment.news

    override val executing = MutableLiveData<Boolean>()

    private var money = 0

    override fun onDonateClicked() {
        val much = mutableMapOf<String, String>()
        for (i in 1..100) {
            much.put("${i * 5}", "$i")
        }
        uiUtils.showSelectFromListDialog("How much?", much) {
                item, id ->
            money = item.toInt()
            executing.postValue(true)
            //sendDonation(money)

            Handler().postDelayed({
                sessionManager.user = User(sessionManager.user!!.seed, sessionManager.user!!.amount - money)
                executing.postValue(false)
                navigator.makeToast("Sent")
            }, 1000)
        }
    }

    @SuppressLint("CheckResult")
    private fun sendDonation(amount: Int) {

        val transaction = TransferTransaction(
            assetId = "43YQoMxd76p3WUpQvaHm2V6LpmP6NcPaY2maTruzTdfU",
            recipient = "3N3dfnsDCM6fPtpUkEE8G9uUrxuoiXZPa7J",
            amount = amount.toLong(),
            attachment = SignUtil.textToBase58("Hello-!"),
            feeAssetId = WavesConstants.WAVES_ASSET_ID_EMPTY
        )

        transaction.fee = WavesConstants.WAVES_MIN_FEE

        transaction.sign(seed = sessionManager.user!!.seed)

        WavesSdk.service()
            .getNode()
            .transactionsBroadcast(transaction)
            .compose(RxUtil.applyObservableDefaultSchedulers())
            .subscribe({response ->
                Log.e("Response", response.toString())
                executing.postValue(false)
                //Assert.assertEquals(true, true)
            }, { t -> t.printStackTrace()
                //Assert.assertEquals(true, false)
                executing.postValue(false)
            })

    }

}