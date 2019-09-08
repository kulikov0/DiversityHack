package com.sainote.waveshackathon.util.permissions

import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

class PermissionManagerImpl  @Inject constructor(
    var activity: BaseActivity
) : PermissionManager, BaseActivity.RequestPermissionResultHandler
{
    init {
        activity.registerRequestPermissionResultHandler(this)
    }

    private var _viewmodel: PermissionManagerTaskViewModel? = null
    val viewmodel: PermissionManagerTaskViewModel
        get() {
            if (_viewmodel == null)
                _viewmodel = ViewModelProviders.of(activity).get(PermissionManagerTaskViewModel::class.java)
            return _viewmodel!!
        }

    class PermissionManagerTaskViewModel: ViewModel() {
        var task: PermissionManager.ExecuteTask? = null
        var executing = false
    }

    fun checkPermissions(permissions: Array<out String>) =
        permissions.all { permission ->
            ContextCompat.checkSelfPermission(activity, permission) ==
                    PackageManager.PERMISSION_GRANTED }

    override fun execute(task: PermissionManager.ExecuteTask)
    {
        if (!viewmodel.executing) {
            viewmodel.task = task
            viewmodel.executing = true
            if (checkPermissions(task.permissions)) {
                task.execute()
                viewmodel.executing = false
            } else {
                if (task.warnBeforePermissionRequest != null) {
                    task.warnBeforePermissionRequest.invoke ({
                        requestPermissions(task.permissions)
                    }, { viewmodel.executing = false })
                } else
                    requestPermissions(task.permissions)
            }
        }
    }

    private val PERMISSION_MANAGER_REQUEST: Int = 90

    private fun requestPermissions(permissions: Array<String>) {
        ActivityCompat.requestPermissions(activity, permissions, PERMISSION_MANAGER_REQUEST)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        if (requestCode == PERMISSION_MANAGER_REQUEST && viewmodel.task != null)
        {
            viewmodel.executing = false
            if (grantResults.all { grantResult -> grantResult == PackageManager.PERMISSION_GRANTED }) {
                viewmodel.task!!.execute()
            }
            else {
                viewmodel.task?.failedPermissionRequest?.invoke()
            }
        }
    }
}