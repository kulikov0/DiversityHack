package com.sainote.waveshackathon.ui.question

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sainote.waveshackathon.data.model.User
import com.sainote.waveshackathon.util.navigator.Navigator
import com.sainote.waveshackathon.util.session.SessionManager
import com.sainote.waveshackathon.util.ui.UIUtils
import javax.inject.Inject

class QuestionViewModelImpl @Inject constructor(val model: Model,
                                                val uiUtils: UIUtils,
                                                val navigator: Navigator,
                                                val sessionManager: SessionManager): QuestionViewModel {

    override val category = MutableLiveData<String>()

    override val question = MutableLiveData<String>()

    override val executing = MutableLiveData<Boolean>()


    override fun onCategoryClicked() {
        uiUtils.showSelectFromListDialog("Choose category", mapOf("Java" to "1", "NodeJs" to "2", "JavaScript" to "0", "Kotlin" to "3", "PHP" to "4", "Ruby" to "4")) {
                item, id ->
            category.postValue(item)
        }
    }

    override fun onSendClick() {
        executing.postValue(true)
        Handler().postDelayed({
            category.postValue("")
            question.postValue("")
            amount.postValue("")
            sessionManager.user = User(sessionManager.user!!.seed, sessionManager.user!!.amount - money)
            navigator.makeToast("Send")
            executing.postValue(false)
        }, 1000)
    }

    override val amount = MutableLiveData<String>()

    private var money = 0

    override fun onAmountClick() {
        val much = mutableMapOf<String, String>()
        for (i in 1..100) {
            much.put("${i * 5}", "$i")
        }
        uiUtils.showSelectFromListDialog("How much?", much) {
                item, id ->
            money = item.toInt()
            //sendDonation(money)
            amount.postValue(item)
        }
    }


    class Model: ViewModel()

}