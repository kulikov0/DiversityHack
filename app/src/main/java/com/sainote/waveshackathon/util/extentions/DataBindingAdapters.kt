package com.sainote.waveshackathon.util.extentions

import android.util.Log
import com.sainote.waveshackathon.util.validator.Validator
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputLayout
import com.sainote.waveshackathon.util.DataBindingAdapter
import java.util.HashMap


class ViewValidatorHolder {
    companion object {
        val Map = HashMap<View, Validator>()
    }
}

@BindingAdapter("validate:validateField")
fun TextInputLayout.validateField(validator: Validator) {
    editText?.setOnFocusChangeListener { _, hasFocus ->
        if (!hasFocus) {
            validator.validateView(this)
        }
    }
}

@BindingAdapter("validate:validator")
fun View.validateValidator(validator: Validator) {
    ViewValidatorHolder.Map[this] = validator
}


@BindingAdapter("validate:error1", "validate:message1", requireAll = false)
fun View.validateError1(error: Boolean, message: String) {
    if (ViewValidatorHolder.Map.containsKey(this))
        ViewValidatorHolder.Map[this]?.setValidationState(this, 0, error, message)
}

@BindingAdapter("validate:error2", "validate:message2")
fun validateError2(view: View, error: Boolean, message: String) {
    if (ViewValidatorHolder.Map.containsKey(view))
        ViewValidatorHolder.Map[view]?.setValidationState(view, 1, error, message)
}

@BindingAdapter("validate:error3", "validate:message3", requireAll = false)
fun validateError3(view: View, error: Boolean, message: String) {
    if (ViewValidatorHolder.Map.containsKey(view))
        ViewValidatorHolder.Map[view]?.setValidationState(view, 2, error, message)
}

@BindingAdapter("validate:error4", "validate:message4", requireAll = false)
fun validateError4(view: View, error: Boolean, message: String) {
    if (ViewValidatorHolder.Map.containsKey(view))
        ViewValidatorHolder.Map[view]?.setValidationState(view, 3, error, message)
}

@BindingAdapter(value = ["validate:error5", "validate:message5"], requireAll = false)
fun validateError5(view: View, error: Boolean, message: String) {
    if (ViewValidatorHolder.Map.containsKey(view))
        ViewValidatorHolder.Map[view]?.setValidationState(view, 4, error, message)
}

@BindingAdapter("visibility")
fun setVisibility(view: View, visible: Boolean) {
    if (visible) view.visibility = View.VISIBLE else view.visibility = View.GONE
}

@BindingAdapter("visible")
fun setVisibile(view: View, visible: Boolean) {
    if (visible) view.visibility = View.VISIBLE else view.visibility = View.INVISIBLE
}

@BindingAdapter("app:onrefresh")
fun SwipeRefreshLayout.setOnRefresh(listener: SwipeRefreshLayout.OnRefreshListener) {
    this.setOnRefreshListener(listener)
}

@BindingAdapter("app:isrefreshing")
fun SwipeRefreshLayout.setIsRefreshing(refreshing: Boolean) {
    this.isRefreshing = refreshing
}

@BindingAdapter(
    "app:datasource", "app:item_layout", "app:viewmodel", "app:hasmore", "app:horizontal",
    "app:gridspan", "app:reverse", "app:filter", requireAll = false
)
fun <T> RecyclerView.setBinding(
    data: List<T>?, itemLayout: Int?, viewmodel: Any?, hasMore: Boolean?, horizontal: Boolean = false,
    gridspan: Int = 0, reverse: Boolean = false, filter: String?
) {
    if (data != null && itemLayout != null) {
        if (adapter == null) {
            layoutManager =
                if (gridspan == 0) {
                    LinearLayoutManager(context).apply {
                        orientation =
                            if (horizontal)
                                RecyclerView.HORIZONTAL
                            else
                                RecyclerView.VERTICAL
                    }
                } else
                    GridLayoutManager(context, gridspan)

            if (reverse && layoutManager is LinearLayoutManager) {
                (layoutManager as LinearLayoutManager).reverseLayout = true
                (layoutManager as LinearLayoutManager).stackFromEnd = true
            }

            adapter = DataBindingAdapter(context, itemLayout, data, {
                //onitemclick?.onClick(item)
            }, viewmodel).apply {
                this.reverse = reverse
                if (reverse)
                    scrollToPosition(0)
            }
        } else {
            (adapter as DataBindingAdapter<T>).apply {
                setNewData(data)
                //adapter?.notifyItemRangeInserted(adapter.itemCount, data.size - 1)
            }
            adapter?.notifyDataSetChanged()
        }
        if (hasMore != null)
            (adapter as DataBindingAdapter<*>?)?.hasMore = hasMore
        if (filter != null) {
            (adapter as DataBindingAdapter<*>).filter = filter
        }

    }
}

@BindingAdapter("app:itemspacing")
fun <T> RecyclerView.setItemSpacing(spacing: Float) {
    this.addItemDecoration(VerticalSpacingItemDecoration(spacing))
}

@BindingAdapter("app:onPageChangeListener")
fun ViewPager.useOnPageChangeListener(listener: ViewPager.OnPageChangeListener) {
    this.addOnPageChangeListener(listener)
}

@BindingAdapter("app:imageLink")
fun ImageView.setImageLink(link: String) {
    this.loadImage(link = link)
}


@BindingAdapter("app:url")
fun loadImage(view: ImageView?, url: String?) {
    url?.let { view?.loadWithoutCrop(url) }
}

@BindingAdapter("app:logResult")
fun View.logResult(result: Any?) {
    Log.e("Result", result.toString())
}



@BindingAdapter("app:webUrl")
fun WebView.webUrl(link: String) {
    this.loadUrl(link)
}

@BindingAdapter("app:WebViewClient")
fun WebView.webViewClient(client: WebViewClient) {
    this.webViewClient = client
}

