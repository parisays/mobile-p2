package com.example.myapplication


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import android.view.MotionEvent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.HomeFragmentBinding
import com.example.myapplication.BookEntity
import com.example.myapplication.home.BooksListAdapter
//import com.example.myapplication.HomeViewModel

class HomeFragment : Fragment(), OnItemClickListener {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    var adapter: BooksListAdapter? = null

    lateinit var homeBinding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.home_fragment, container, false)
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return homeBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homeBinding.bookListRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = BooksListAdapter(this@HomeFragment)
        }

        adapter = homeBinding.bookListRecyclerView.adapter as BooksListAdapter

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.books.observe(viewLifecycleOwner, { books ->
            adapter?.reload(books)
        })

    }

    override fun onItemClicked(bookEntity: BookEntity) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(bookEntity.id))
    }
}