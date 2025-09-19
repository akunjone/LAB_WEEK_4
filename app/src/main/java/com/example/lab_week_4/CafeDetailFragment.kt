package com.example.lab_week_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_TITLE = "arg_title"
private const val ARG_DESC = "arg_desc"

class CafeDetailFragment : Fragment() {

    private var cafeTitle: String? = null
    private var cafeDesc: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cafeTitle = it.getString(ARG_TITLE)
            cafeDesc = it.getString(ARG_DESC)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titleView = view.findViewById<TextView>(R.id.cafe_detail_title)
        val descView = view.findViewById<TextView>(R.id.cafe_detail_desc)

        titleView.text = cafeTitle
        descView.text = cafeDesc
    }

    companion object {
        fun newInstance(title: String, desc: String): CafeDetailFragment {
            val fragment = CafeDetailFragment()
            fragment.arguments = Bundle().apply {
                putString(ARG_TITLE, title)
                putString(ARG_DESC, desc)
            }
            return fragment
        }
    }
}
