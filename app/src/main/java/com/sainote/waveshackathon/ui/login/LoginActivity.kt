package com.sainote.waveshackathon.ui.login

import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.ActivityLoginBinding
import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import dagger.Lazy
import javax.inject.Inject

class LoginActivity : BaseActivity(R.layout.activity_login) {

    @Inject
    override
    lateinit var binding: Lazy<ActivityLoginBinding>

}