package com.srikanth.basu.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.srikanth.basu.databinding.ActivityMainBinding
import com.srikanth.basu.ui.adapter.UserAdapter
import com.srikanth.basu.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val viewModel: UserViewModel by viewModels()
    private val TAG:String ="CHECK_RESPONSE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
        setupUserData()
    }

    private fun setView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupUserData() {
        userAdapter = UserAdapter()
        binding.recyclerView.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
        viewModel.responseUsers.observe(this) { response ->
            if (response != null) {
                Log.i(TAG,"onResponse: ${response.dummy}")
                userAdapter.setUserList((response.dummy!!))
            }
        }
    }
}