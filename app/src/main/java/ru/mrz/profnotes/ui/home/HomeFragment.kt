package ru.mrz.profnotes.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.mrz.profnotes.data.model.MyNote
import ru.mrz.profnotes.data.model.NewNote
import ru.mrz.profnotes.data.model.util.ResponseWrapper
import ru.mrz.profnotes.databinding.FragmentHomeBinding
import ru.mrz.profnotes.ui.core.BaseFragment
import ru.mrz.profnotes.ui.home.adapter.MyNotesAdapter
import ru.mrz.profnotes.ui.home.adapter.NewNotesAdapter
import ru.mrz.profnotes.viewmodel.HomeViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override val viewModel by viewModels<HomeViewModel>()

    private val viewPagerAdapter by lazy { NewNotesAdapter() }
    private val myNotesAdapter by lazy { MyNotesAdapter() }

    override fun setupViews() {
        lifecycleScope.launchWhenStarted {
            viewModel.note.collect {
                when (it) {
                    is ResponseWrapper.Idle -> {}
                    is ResponseWrapper.Error -> {
                        Log.e("Error", "${it.code}")
                    }
                    is ResponseWrapper.Success -> {
                        Log.e("Success", "${it.body}")
                    }
                }
            }
        }
        viewModel.getNote()
        setupPager()
        setupMyNotes()
    }

    private fun setupMyNotes() {
        with(binding) {
            rvMyNotes.adapter = myNotesAdapter
            rvMyNotes.layoutManager = object : LinearLayoutManager(requireContext()) {
                override fun canScrollVertically() = false
            }

            myNotesAdapter.setItems(listOf(
                MyNote(
                    id = 1,
                    title = "Test",
                    date = "Today",
                    status = "New",
                    description = "Test"
                )
            ))
        }
    }

    private fun setupPager() {
        with(binding) {
            viewPagerAdapter.setItems(listOf(
                NewNote(
                    id = 1,
                    title = "Sample title",
                    date = "today",
                    description = "Start learning"
                )
            ))

            vpNewNotes.adapter = viewPagerAdapter
        }
    }
}