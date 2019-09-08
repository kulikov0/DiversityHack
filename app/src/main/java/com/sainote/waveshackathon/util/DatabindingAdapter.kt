package com.sainote.waveshackathon.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.ui.base.activity.BaseActivity

class DataBindingAdapter<T>(
    var context: Context,
    var itemLayoutId: Int,
    var data: List<T>,
    var onItemClick: ((T) -> Unit)?,
    var viewmodel: Any?) : RecyclerView.Adapter<DataBindingAdapter.BaseViewHolder>(), Filterable {
    private var items = ArrayList<T>()

    init {
        setNewData(data)
    }

    fun setNewData(newData: List<T>) {
        items.clear()
        items.addAll(newData)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == items.size && hasMore)
            return 1
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        if (viewType == 0)
            DataBindingViewHolder<T>(
                context, DataBindingUtil.inflate(
                    LayoutInflater.from(context), itemLayoutId, parent, false
                ), viewmodel
            )
        else
            ProgressViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_hasmore,
                    parent,
                    false
                )
            )

    override fun getItemCount() = items.size + (if (hasMore) 1 else 0)

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is DataBindingViewHolder<*>) {
            val pos = position
//            if (reverse && hasMore)
//                pos = pos - 1
            (holder as DataBindingViewHolder<T>).bind(items[pos], pos % 2 == 0)
        }
    }

    open class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class DataBindingViewHolder<T>(
        val context: Context,
        var binding: ViewDataBinding?,
        var viewmodel: Any?
    ) : BaseViewHolder(binding?.root!!) {
        fun bind(item: T, even: Boolean) {
            binding?.apply {
                setVariable(BR.item, item)
                setVariable(BR.viewmodel, viewmodel)
                //setVariable(BR.even, even)
                executePendingBindings()
                if (context is BaseActivity)
                    lifecycleOwner = context
                if (context is Fragment)
                    lifecycleOwner = (context as Fragment)

            }
        }
    }

    class ProgressViewHolder(view: View) : BaseViewHolder(view)

    var filter: String? = null
        set(value) {
            mFilter.filter(value)
        }

    private val mFilter: Filter = Filter()

    var hasMore: Boolean = false
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var reverse: Boolean = false
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getFilter(): Filter = mFilter

    interface OnItemClickListener {
        fun onClick(item: Any?)
    }

    inner class Filter : android.widget.Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val results = FilterResults()
            return results
        }

        private fun isFilter(x: Any?, constraint: CharSequence?): Boolean {
            return x.toString().toLowerCase().contains(constraint.toString().toLowerCase(), false)
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            items = results?.values as ArrayList<T>
            notifyDataSetChanged()
        }
    }
}