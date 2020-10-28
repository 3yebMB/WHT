package dev.m13d.wht.framework.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.m13d.wht.R
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