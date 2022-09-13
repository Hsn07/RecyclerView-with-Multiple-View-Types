package com.hbacakk.multirowkotlin.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hbacakk.multirowkotlin.Message
import com.hbacakk.multirowkotlin.R
import com.hbacakk.multirowkotlin.Title
import com.hbacakk.multirowkotlin.databinding.FragmentBottomBinding
import com.hbacakk.multirowkotlin.models.Item
import com.hbacakk.multirowkotlin.ui.ItemAdapter
import com.hbacakk.multirowkotlin.ui.ItemListener

class BottomFragment(var itemList:ArrayList<Item>) : BottomSheetDialogFragment(),ItemListener {

    lateinit var binding : FragmentBottomBinding
    //public var itemList: ArrayList<Item> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBottomBinding.inflate(layoutInflater)


        val itemAdapter= ItemAdapter(itemList)
        //itemAdapter.addListener(this)//BottomFragment calbackler tetiklenir
        itemAdapter.addListener(activity as ItemListener)//mainactivity calbackler tetiklenir
        binding.recyclerViewItems.adapter = itemAdapter

        return binding.root
    }
    override fun titleClick(title: Title) {
        Log.d("TAG", "titleClick: ")
        Toast.makeText(activity,"Fragment Title:${title.title} ", Toast.LENGTH_SHORT).show()
    }

    override fun messageClick(message: Message) {
        Log.d("TAG", "messageClick: ")
        Toast.makeText(activity,"Fragment message: ${message.message}",Toast.LENGTH_SHORT).show()
    }

    override fun undefinedClick(text: String) {
        Toast.makeText(activity,"Fragment Undefined: $text",Toast.LENGTH_SHORT).show()
    }

}