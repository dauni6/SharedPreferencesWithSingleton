package com.dontsu.sharedpreferenceswithsingleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    init {
        //Timber initialize
        Timber.plant(Timber.DebugTree())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //데이터 입력
        inputBtn.setOnClickListener{
            writePreferences("짜장면", "찜뽕", "국밥", "김치찌개")
        }

        //데이터 출력
        outputBtn.setOnClickListener {
            readPreferences()
        }
    }

    private fun writePreferences(food1: String, food2: String, food3: String, food4: String) {
        val prefs = PrefsHelper.getInstance(this@MainActivity)
        prefs!!.putString(PrefsHelper.Food1, food1)
        prefs!!.putString(PrefsHelper.Food2, food2)
        prefs!!.putString(PrefsHelper.Food3, food3)
        prefs!!.putString(PrefsHelper.Food4, food4)
    }

    private fun readPreferences() {
        val prefs = PrefsHelper.getInstance(this@MainActivity)
        val food1 = prefs?.getString(PrefsHelper.Food1, "")
        val food2 = prefs?.getString(PrefsHelper.Food2, "")
        val food3 = prefs?.getString(PrefsHelper.Food3, "")
        val food4 = prefs?.getString(PrefsHelper.Food4, "")
        Timber.d("---메인 : $food1, $food2, $food3, $food4")
        Toast.makeText(this@MainActivity, "$food1, $food2, $food3, $food4", Toast.LENGTH_SHORT).show()
    }

}
