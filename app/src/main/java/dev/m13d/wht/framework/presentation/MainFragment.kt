package dev.m13d.wht.framework.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dev.m13d.wht.R
import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.business.domain.state.DataState
import dev.m13d.wht.framework.presentation.MainStateEvent.*
import dev.m13d.wht.databinding.FragmentMainBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor(
    private val someString: String
): Fragment(R.layout.fragment_main) {

    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        viewModel.setStateEvent(GetHolydaysEvent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
        if(message != null) binding.textV.text = message else binding.textV.text = getString(R.string.unknown_error)
    }

    private fun appendHolydayTitles(holydays: List<Holyday>){
        val sb = StringBuilder()
        for(holyday in holydays){
            sb.append(holyday.date + "\n")
            sb.append("\t ${holyday.localName} \n")
        }
        binding.textV.text = sb.toString()
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        binding.progressBar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }
}