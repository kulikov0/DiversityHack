package com.sainote.waveshackathon.util.permissions

interface PermissionManager {
    fun execute(task: ExecuteTask)

    class ExecuteTask(
        val permissions : Array<String>,
        val execute: (() -> Unit),
        val warnBeforePermissionRequest: ((continueCallback: () -> Unit, abortCallback: () -> Unit) -> Unit)? = null,
        val failedPermissionRequest: (() -> Unit)? = null)
}