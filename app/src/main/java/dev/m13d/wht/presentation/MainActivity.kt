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
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity
constructor(
    private val someString: String
) : AppCompatActivity() {

    private val TAG: String = "AppDebug"

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        supportFragmentManager.fragmentFactory = fragmentFactory
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, MainFragment::class.java, null)
            .commit()
    }
}