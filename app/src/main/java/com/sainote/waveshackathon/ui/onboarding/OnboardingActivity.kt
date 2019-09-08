package com.sainote.waveshackathon.ui.onboarding

import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.ActivityOnboardingBinding
import com.sainote.waveshackathon.ui.onboarding.articles.ExploreArticlesFragment
import com.sainote.waveshackathon.ui.onboarding.courses.TakeCoursesFragment
import com.sainote.waveshackathon.ui.onboarding.start.StartExploringFragment
import com.sainote.waveshackathon.util.navigator.Navigator
import dagger.Lazy
import javax.inject.Inject


class OnboardingActivity: BaseActivity(R.layout.activity_onboarding) {

    @Inject
    lateinit var viewModel: OnboardingViewModel

    @Inject
    override
    lateinit var binding: Lazy<ActivityOnboardingBinding>

    @Inject
    lateinit var navigator: Navigator

    lateinit var fragments: List<Fragment>

    @Inject
    fun registerFragments(
        articlesFragment: ExploreArticlesFragment,
        coursesFragment: TakeCoursesFragment,
        startExploringFragment: StartExploringFragment
    ) {
        fragments = listOf(
            articlesFragment,
            coursesFragment,
            startExploringFragment
        )
        viewModel.pageCount = fragments.size
        viewModel.pageIndex.observe(this, Observer { onPageIndexChanged() })
    }

    private var currentFragment: Fragment? = null

    private var pageIndex = -1

    private fun onPageIndexChanged() {
        val newFragment = fragments[viewModel.pageIndex.value?:0]
        if (currentFragment != newFragment && pageIndex < viewModel.pageIndex.value!!) {
            val transaction = supportFragmentManager.beginTransaction()
            newFragment.enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.onboarding_enter)
            newFragment.exitTransition = TransitionInflater.from(this).inflateTransition(R.transition.onboarding_exit)
            transaction.replace(R.id.fragment_container, newFragment)
            transaction.addToBackStack("fragment${viewModel.pageIndex.value}")
            transaction.commit()
            pageIndex = viewModel.pageIndex.value!!
        }
    }

    override fun onBackPressed() {
        if ((viewModel.pageIndex.value ?: 0) > 0) {
            goBack()
            super.onBackPressed()
        }
        else
            navigator.closeScreen()


    }

    private fun goBack() {
        viewModel.pageIndex.value = (viewModel.pageIndex.value ?: 0) - 1
        pageIndex = viewModel.pageIndex.value ?: 0
    }

}