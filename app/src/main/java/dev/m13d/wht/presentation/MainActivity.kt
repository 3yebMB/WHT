package dev.m13d.wht.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dev.m13d.wht.R
import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.business.domain.state.DataState
import dev.m13d.wht.presentation.MainStateEvent.*

@AndroidEntryPoint
class MainActivity
constructor(
    private val someString: String
) : AppCompatActivity() {

    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        subscribeObservers()
        viewModel.setStateEvent(GetHolydaysEvent)

        Log.d(TAG, "someString: ${someString}")
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when(dataState) {
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
//        if(message != null) text.text = message else text.text = "Unknown error."
    }

    private fun appendHolydayTitles(holydays: List<Holyday>){
        val sb = StringBuilder()
//        for(holyday in holydays){
//            sb.append(holyday.title + "\n")
//        }
//        text.text = sb.toString()
    }

    private fun displayProgressBar(isDisplayed: Boolean){
//        progress_bar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }
}