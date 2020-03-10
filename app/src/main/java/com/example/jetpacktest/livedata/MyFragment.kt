package com.example.jetpacktest.livedata;

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/3/9
 */
public class MyFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Exception().printStackTrace()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Exception().printStackTrace()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Exception().printStackTrace()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Exception().printStackTrace()
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Exception().printStackTrace()
        super.onStart()
    }

    override fun onResume() {
        Exception().printStackTrace()
        super.onResume()
    }

    override fun onPause() {
        Exception().printStackTrace()
        super.onPause()
    }

    override fun onStop() {
        Exception().printStackTrace()
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Exception().printStackTrace()
    }

    override fun onDestroy() {
        Exception().printStackTrace()
        super.onDestroy()
    }

    override fun onDetach() {
        Exception().printStackTrace()
        super.onDetach()
    }

}
