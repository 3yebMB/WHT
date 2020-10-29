package dev.m13d.wht.framework.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dev.m13d.wht.R
import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.business.domain.state.DataState
import dev.m13d.wht.databinding.FragmentMainBinding
import java.lang.StringBuilder
import dev.m13d.wht.framework.presentation.MainStateEvent.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor(
    private val someString: String
): Fragment(R.layout.fragment_main) {

    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        viewModel.setStateEvent(GetHolydaysEvent)

        Log.d(TAG, "someString: ${someString}")
    }

    private fun subscribeObservers(){
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<List<Holyday>> -> {
                    displayProgressBar(false)
                    appendHolydayTitles(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?){
        if(message != null) binding.text.text = message else binding.text.text = "Unknown error."
    }

    private fun appendHolydayTitles(holydays: List<Holyday>){
        val sb = StringBuilder()
        for(holyday in holydays){
            sb.append(holyday.localName + "\n")
        }
        binding.text.text = sb.toString()
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        binding.progressBar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }
}