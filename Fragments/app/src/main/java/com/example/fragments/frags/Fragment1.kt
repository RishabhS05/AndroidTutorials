package com.example.fragments.frags

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.persistableBundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fragments.MainActivity
import com.example.fragments.R
import com.example.viewModels.MainViewModel

class Fragment1 : Fragment(R.layout.layout_fragment_one) {

    /** Life cycle Logs
    D/Fragment1: FragmentLifeCycle : $INITIALIZED   Fragment CallBack : onAttach Called
    D/Fragment1: FragmentLifeCycle : $INITIALIZED   Fragment CallBack : OnCreate Called
    D/Fragment1: FragmentLifeCycle : $CREATED   Fragment CallBack : onCreateView Called
    D/Fragment1: FragmentLifeCycle : $CREATED   Fragment CallBack : onViewCreated Called  Fragment View Lifecycle : INITIALIZED
    D/Fragment1: FragmentLifeCycle : $CREATED   Fragment CallBack : onViewStateRestored Called  Fragment View Lifecycle : INITIALIZED
    D/Fragment1: FragmentLifeCycle : $CREATED   Fragment CallBack : onStart Called  Fragment View Lifecycle : CREATED
    D/Fragment1: FragmentLifeCycle : $STARTED   Fragment CallBack : onResume Called  Fragment View Lifecycle : STARTED
    D/Fragment1: FragmentLifeCycle : $STARTED   Fragment CallBack : onPause Called  Fragment View Lifecycle : STARTED
    D/Fragment1: FragmentLifeCycle : $CREATED   Fragment CallBack : onStop Called  Fragment View Lifecycle : CREATED
    D/Fragment1: FragmentLifeCycle : $CREATED   Fragment CallBack : onDestroyedView Called  Fragment View Lifecycle : DESTROYED
    D/Fragment1: FragmentLifeCycle : $DESTROYED   Fragment CallBack : onDestroy Called
    D/Fragment1: FragmentLifeCycle : $DESTROYED   Fragment CallBack : onDetach Called
     */
    override fun onAttach(context: Context) {
        printFragmentStatus("onAttach Called", isViewAdded = false)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        printFragmentStatus("OnCreate Called", isViewAdded = false)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        printFragmentStatus("onCreateView Called", isViewAdded = false)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        printFragmentStatus("onViewCreated Called")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        printFragmentStatus("onViewStateRestored Called")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        printFragmentStatus("onStart Called")
        super.onStart()
    }

    override fun onResume() {
        printFragmentStatus("onResume Called")
        super.onResume()
    }

    override fun onPause() {
        printFragmentStatus("onPause Called")
        super.onPause()
    }

    override fun onStop() {
        printFragmentStatus("onStop Called")
        super.onStop()
    }

    override fun onDestroyView() {
        printFragmentStatus("onDestroyedView Called")
        super.onDestroyView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        printFragmentStatus("onSaveInstanceState Called")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        printFragmentStatus("onDestroy Called", isViewAdded = false)
        super.onDestroy()
    }

    override fun onDetach() {
        printFragmentStatus(
            "onDetach Called",
            isViewAdded = false
        )
        super.onDetach()
    }

    fun printFragmentStatus(fragmentCallBack: String, isViewAdded: Boolean = true) {

        val log: String = "Fragment LifeCycle : $${lifecycle.currentState.name}\nFragment CallBack : $fragmentCallBack${
            if (isViewAdded) {
                "\nFragment View Lifecycle : ${viewLifecycleOwner.lifecycle.currentState.name}"
            } else ""
        } "
        (activity as MainActivity).printActivityState(log,isViewAdded)
        Log.d(TAG, log)
    }

    companion object {
        var TAG: String = Fragment1::class.java.simpleName
    }
}