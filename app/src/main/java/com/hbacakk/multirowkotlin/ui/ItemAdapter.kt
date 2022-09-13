package com.hbacakk.multirowkotlin.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hbacakk.multirowkotlin.Message
import com.hbacakk.multirowkotlin.Title
import com.hbacakk.multirowkotlin.databinding.ItemMessageBinding
import com.hbacakk.multirowkotlin.databinding.ItemTitleBinding
import com.hbacakk.multirowkotlin.databinding.ItemUndefinedBinding
import com.hbacakk.multirowkotlin.models.Item

class ItemAdapter(val itemList: ArrayList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        val KEY_TITLE = 1
        val KEY_MESSAGE = 2
    }

    lateinit var listener: ItemListener

    fun addListener(listener: ItemListener) {
        this.listener = listener
    }

    //Type değişkenine göre satır düzenini ayarlanıyor
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            KEY_MESSAGE -> return viewHolderMessage(
                ItemMessageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            KEY_TITLE -> return viewHolderTitle(
                ItemTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> return viewHolderDefault(
                ItemUndefinedBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            KEY_TITLE -> {
                (holder as viewHolderTitle).setData(itemList[position].item as Title)
            }
            KEY_MESSAGE -> {
                (holder as viewHolderMessage).setData(itemList[position].item as Message)
            }
        }
    }

    override fun getItemCount() = itemList.size

    override fun getItemViewType(position: Int): Int {

        if (itemList[position].type == null)
            return -1

        return itemList[position].type
    }


    inner class viewHolderTitle(val binding: ItemTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(title: Title) {
            binding.title = title.title

            binding.textViewTitle.setOnClickListener { view -> listener.titleClick(title) }

            binding.executePendingBindings()


        }
    }

    inner class viewHolderMessage(val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(message: Message) {
            binding.message = message.message

            binding.textViewMessage.setOnClickListener { view -> listener.messageClick(message) }

            binding.executePendingBindings()


            //listener?.messageClick(message)
            /*if (listener!=null){
                listener.messageClick(message)
            }*/

        }
    }

    inner class viewHolderDefault(val binding: ItemUndefinedBinding) :
        RecyclerView.ViewHolder(binding.root)
}