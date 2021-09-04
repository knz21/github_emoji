package com.knz21.github_emoji.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.knz21.github_emoji.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.grid.adapter = MainAdapter()
        binding.grid.layoutManager = GridLayoutManager(this, 3)
        viewModel.emojis.observe(this) {
            (binding.grid.adapter as MainAdapter).submitList(it)
        }
    }
}