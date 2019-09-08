package com.sainote.waveshackathon.ui.news

import android.Manifest
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sainote.waveshackathon.data.model.News
import com.sainote.waveshackathon.ui.base.viewmodel.BaseListViewModel
import com.sainote.waveshackathon.ui.base.viewmodel.BaseViewModelSimple
import javax.inject.Inject

class NewsViewModelImpl @Inject constructor(
    val model: Model,
    lifecycle: Lifecycle,
    val fragment: NewsFragment
    ) : BaseViewModelSimple(lifecycle), NewsViewModel {


    override val loading: LiveData<Boolean>
        get() = model.loading

    override val news: LiveData<List<News>>
        get() = model.data

    override fun refresh() = load()

    override fun onStart() {
        super.onStart()
        if (model.loadRequired) load()
    }


    private fun load() {
        model.loading.postValue(true)
        Handler().postDelayed({
            model.data.postValue(listOf(
                News(
                    title = "Bulletproof node.js project architecture",
                    author = "Sam Quinn",
                    text = "Express.js is great frameworks for making a node.js REST APIs however it doesn't give you any clue on how to organizing your node.js project.While it may sound silly, this is a real problem.The correct organization of your node.js project structure will avoid duplication of code, will improve stability, and potentially, will help you scale your services if is done correctly.This post is extense research, from my years of experience dealing with a poor structured node.js project, bad patterns, and countless hours of refactoring code and moving things around.",
                    image = "https://software.intel.com/sites/default/files/managed/fa/a0/Runtime-logo-Node.jpg",
                    authorPhoto = "https://cdn4.iconfinder.com/data/icons/social-messaging-productivity/64/x-01-512.png",
                    fromNewsScreen = true
            ),
                News(
                    title = "Introducing Node.js",
                    author = "Michael Dawson",
                    text = "We are excited to announce Node.js 12 today. Highlighted updates and features include faster startup and better default heap limits, updates to V8, TLS, llhttp, new features including diagnostic report, bundled heap dump capability and updates to Worker Threads, N-API and ES6 module support and more. The Node.js 12 release replaces version 11 in our current release line. The Node.js release line will become a Node.js Long Term Support (LTS) release in Oct 2019 ",
                    image = "https://www.mememaker.net/api/bucket?path=static/img/memes/full/2019/Jan/8/3/pennywise-nodejs-212.png",
                    authorPhoto = "https://miro.medium.com/max/3150/1*nGx5t_wfmnmey8B7Ngmv5w.png",
                    fromNewsScreen = true
                ),
                News(
                    title = "Building A Node.js Express API To Convert Markdown To HTML",
                    author = "Sameer Borate",
                    text = "Our teeny-tiny application, which we will call ‘Markdown Converter’, will enable us to post Markdown-styled text and retrieve an HTML version. The application will be created using the Node.js Express framework, and support authentication for conversion requests.\n" +
                            "\n" +
                            "We will build the application in small stages — initially creating a scaffold using Express and then adding various features like authentication as we go along. So let us start with the initial stage of building the application by creating a scaffold.",
                    authorPhoto = "https://www.gravatar.com/avatar/fa9df688ce1e6ff39052faa763e839ff?s=70&d=mm&r=g",
                    image = "https://gsferreira.com/images/reduce-the-path-length-of-your-node-js-project-dependencies-dependencies-everywhere.jpg",
                    fromNewsScreen = true
                )))
            model.loading.postValue(false)
        }, 1000)
    }

    override fun onAuthorClicked(news: News) {
        super.onAuthorClicked(news)
        fragment.openAuthorScreen(news)
    }


    class Model: BaseListViewModel<News>() {
    }

}