package com.srikanth.basu.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.srikanth.basu.databinding.ListItemBinding
import com.srikanth.basu.model.Dummy

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var dummy = mutableListOf<Dummy>()

    inner class UserViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    fun setUserList(dummy: List<Dummy>) {
        this.dummy = dummy.toMutableList()
        notifyDataSetChanged()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.binding.apply {
           // val guest = dummy
            txtName.text = " Name : ${dummy[position].name}"
            txtType.text= " Type : ${dummy[position].type}"
            var adultCount=0
            for (list in dummy[position].guest!!){

                adultCount+= list.adults!!
            }
            txtAdultGuests.text = " Adult Count : $adultCount"
        }
    }

    override fun getItemCount() = dummy.size

}

