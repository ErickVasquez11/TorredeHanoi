package com.vasquez.torredehanoi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //Data
    private var next = 0
    private var previous = 0

    //Views
    private lateinit var nextAndpreviousTextView : TextView
    private lateinit var action_next : Button
    private lateinit var action_previous : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")
        bind()
        AddListeners()
    }

    // Function SaveInstanceState
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(KEY_PASS_NEXT, next)
        outState.putInt(KEY_PASS_PREVIOUS, previous)
        Log.d(TAG, "onSaveInstance")
    }

    //Functions
    private fun AddListeners() {
        action_next.setOnClickListener {
            next++
            updateVisualPass(nextAndpreviousTextView, next)
        }
        action_previous.setOnClickListener {
            previous--
            updateVisualPass(nextAndpreviousTextView, previous)
        }
    }

    //Function Diferent Position
    private fun updateVisualPass(view: TextView, pass: Int)
    {
        view.text = pass.toString()
    }

    private fun setupPass(savedInstanceState: Bundle?) {
        savedInstanceState?.let { bundle ->
            next = bundle.getInt(KEY_PASS_NEXT, 0)
            previous = bundle.getInt(KEY_PASS_PREVIOUS, 0)
        }
        updateVisualPass(nextAndpreviousTextView, next)
        updateVisualPass(nextAndpreviousTextView, previous)
    }

    // Function Pass Configuration
    private fun bind() {
        //Next
            nextAndpreviousTextView = findViewById(R.id.Pass)
            action_next = findViewById(R.id.action_next)

        //Previous
            nextAndpreviousTextView = findViewById(R.id.Pass)
            action_previous = findViewById(R.id.action_previous)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }
    companion object {
        private val TAG = MainActivity::class.simpleName
        private const val KEY_PASS_NEXT = "Next"
        private const val KEY_PASS_PREVIOUS = "Previous"
    }
}