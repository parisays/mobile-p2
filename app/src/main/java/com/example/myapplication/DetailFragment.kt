package com.example.myapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.DetailFragmentBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_fragment.view.*

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    lateinit var detailBinding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailBinding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)
        return detailBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)


        val bookId = DetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel.getBook(bookId)

        viewModel.book.observe(viewLifecycleOwner, {
            try {
                Picasso.get().load(it.image?.toUri()).into(detailBinding.bookImage)
            } catch (e: Exception) {
                // TODO: load a default image
            }
            detailBinding.bookName.text = it.name
            detailBinding.bookWriter.text = it.writer
            detailBinding.bookGenre.text = it.genres
            detailBinding.bookPageCount.text = it.page_count.toString() + " pages"

        })
    }

}