package com.hbacakk.multirowkotlin.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hbacakk.multirowkotlin.Message
import com.hbacakk.multirowkotlin.Title
import com.hbacakk.multirowkotlin.databinding.ActivityMainBinding
import com.hbacakk.multirowkotlin.models.Item
import com.hbacakk.multirowkotlin.ui.fragments.BottomFragment

class MainActivity : AppCompatActivity(), ItemListener {
    lateinit var binding: ActivityMainBinding

    private val itemList: ArrayList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        itemList.add(Item(1, Title("Başlık")))
        itemList.add(
            Item(
                2,
                Message("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
            )
        )
        itemList.add(
            Item(
                2,
                Message("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
            )
        )
        itemList.add(Item(5, Message("")))
        itemList.add(Item(1, Title("Başlık 2")))
        itemList.add(
            Item(
                2,
                Message("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
            )
        )

        itemList.add(Item(1, Title("Başlık")))
        itemList.add(
            Item(
                2,
                Message("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
            )
        )
        itemList.add(
            Item(
                2,
                Message("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
            )
        )
        itemList.add(Item(5, Message("")))
        itemList.add(Item(1, Title("Başlık 2")))
        itemList.add(
            Item(
                2,
                Message("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
            )
        )
        itemList.add(Item(10, 10))
        itemList.add(Item(10, "10"))
        itemList.add(Item(10, true))
        itemList.add(Item(10, 1f))
        val itemAdapter = ItemAdapter(itemList)
        itemAdapter.addListener(this)
        binding.recyclerViewItems.adapter = itemAdapter


    }

    fun openBottomSheet() {

        BottomFragment(itemList).apply {
            show(supportFragmentManager, "BottomFragment")
        }

    }

    override fun titleClick(title: Title) {
        Log.d("TAG", "titleClick: ")
        Toast.makeText(this, "Title:${title.title} ", Toast.LENGTH_SHORT).show()
        openBottomSheet()
    }

    override fun messageClick(message: Message) {
        Log.d("TAG", "messageClick: ")
        Toast.makeText(this, "message: ${message.message}", Toast.LENGTH_SHORT).show()
    }

    override fun undefinedClick(text: String) {
        Toast.makeText(this, "Undefined: $text", Toast.LENGTH_SHORT).show()
    }
}