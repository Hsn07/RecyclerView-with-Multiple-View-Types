package com.hbacakk.multirowkotlin.ui

import com.hbacakk.multirowkotlin.Message
import com.hbacakk.multirowkotlin.Title

interface ItemListener {
    //Callbackler
    public fun titleClick(title: Title)
    public fun messageClick(message: Message)
    public fun undefinedClick(text: String)
}