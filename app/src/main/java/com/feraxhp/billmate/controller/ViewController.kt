package com.feraxhp.billmate.controller

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.feraxhp.billmate.activitys.CreateNewEvents
import com.feraxhp.billmate.activitys.CreateNewFund
import com.feraxhp.billmate.activitys.MainActivity

class ViewController(private val context: Context) {
    fun startMainActivity() {
        ContextCompat.startActivity(
            context, Intent(context, MainActivity::class.java),
            null
        )
    }

    fun startCreateNewFund() {
        ContextCompat.startActivity(
            context, Intent(context, CreateNewFund::class.java),
            null
        )
    }

    fun startCreateNewEvents() {
        ContextCompat.startActivity(
            context, Intent(context, CreateNewEvents::class.java),
            null
        )
    }
}