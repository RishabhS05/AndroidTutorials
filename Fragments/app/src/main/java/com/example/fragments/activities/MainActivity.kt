package com.example.fragments.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.adapters.LogPrinterRVAdapter
import com.example.fragments.R
import com.example.fragments.frags.Fragment1
import com.example.fragments.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {
    companion object

    val TAG = MainActivity::class.java.simpleName
    val logRecyclerView: RecyclerView by lazy {
        findViewById(R.id.logsPrinter)
    }
    var stackEnabled: Boolean = false

    val viewModel: MainViewModel by viewModels()
    val fragmentLogs = ArrayList<String>()
    lateinit var adapter: LogPrinterRVAdapter
    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        printActivityState("onCreateView Callback", logsonly = true)
        return super.onCreateView(name, context, attrs)
    }

    override fun onPause() {
        super.onPause()
        printActivityState("onPause Callback")
    }

    override fun onDestroy() {
        printActivityState("onDestroy Callback")
        super.onDestroy()

    }

    override fun onRestart() {
        super.onRestart()
        printActivityState("onRestart Callback")
    }

    override fun onStop() {
        printActivityState("onStop Callback")
        super.onStop()

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        printActivityState("onSaveInstanceState Callback")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        printActivityState("onSaveInstanceState(outState: Bundle) Callback")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        printActivityState("onRestoreInstanceState Callback")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        printActivityState("onCreate Callback")
        val stackEnabledUI = findViewById<Switch>(R.id.stackSwitch)
        val addFrag = findViewById<Button>(R.id.addFragment)
        val replaceFrag = findViewById<Button>(R.id.replaceFragment)
        val clearLogs = findViewById<ImageView>(R.id.clearLogs)

        stackEnabledUI.setOnCheckedChangeListener { compoundButton, b ->
            stackEnabled = b
        }
        addFrag.setOnClickListener { addFragment() }

        replaceFrag.setOnClickListener { replaceFragment() }
        adapter = LogPrinterRVAdapter(fragmentLogs)
        logRecyclerView.adapter = adapter
        logRecyclerView.layoutManager = LinearLayoutManager(this)
//        supportFragmentManager.addFragmentOnAttachListener { fragmentManager, fragment ->
//            fragmentLogs.addAll((fragment as Fragment1).getLogs())
//            logRecyclerView.adapter?.notifyDataSetChanged()
//        }
        clearLogs.setOnClickListener {
            viewModel.clearLogs()
            fragmentLogs.clear()
            logRecyclerView.adapter?.notifyDataSetChanged()
        }
        logRecyclerView.adapter?.notifyDataSetChanged()
        viewModel.logLiveData.observe(this, {
            logRecyclerView.adapter?.notifyDataSetChanged()
        })

    }

    fun addFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)  // when performing FragmentTransaction it optimizes state changes of the fragment. So the transition and animation work correctly.
            if (stackEnabled) addToBackStack("Add Frag")
            add<Fragment1>(R.id.fragmentContainer)
        }

    }


    fun replaceFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)  // when performing FragmentTransaction it optimizes state changes of the fragment. So the transition and animation work correctly.
            if (stackEnabled) addToBackStack("Replace Frag")
            val bundle = Bundle()
            bundle.putString("color", "red")
            replace<Fragment1>(R.id.fragmentContainer, args = bundle)
        }

    }

    fun removeFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            supportFragmentManager.findFragmentById(R.id.fragment1)?.let { remove(it) }
        }
    }


    override fun onStart() {
        super.onStart()
        printActivityState("onStart Callback")
    }


    override fun onResume() {
        super.onResume()
        printActivityState("onResume Callback")
        // if we put into the on Create it show error
        // because the fragment is not yet added to the host fragmentManager
        //  supportFragmentManager.fragments[0]
    }

    fun printActivityState(callback: String, logsonly: Boolean = false) {
        Log.d(TAG, callback)
        if (!logsonly) {
            viewModel.setLog(callback)
            fragmentLogs.add(callback)
            logRecyclerView.adapter?.notifyDataSetChanged()
        }
    }

//    fun initilization() {
//        viewModel.logLiveData.observe(this, {
//            if (it != null) {
//                fragmentLogs.addAll(it)
//                logRecyclerView.adapter?.notifyDataSetChanged()
//            }
//        })
//    }
}
