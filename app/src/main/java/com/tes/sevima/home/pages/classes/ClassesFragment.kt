package com.tes.sevima.home.pages.classes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tes.sevima.R

/**
 * A simple [Fragment] subclass.
 * Use the [ClassesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClassesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classes, container, false)
    }
}