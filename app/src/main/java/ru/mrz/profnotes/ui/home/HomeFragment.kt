package ru.mrz.profnotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.MarginPageTransformer
import dagger.hilt.android.AndroidEntryPoint
import ru.mrz.profnotes.data.model.MyNote
import ru.mrz.profnotes.data.model.NewNote
import ru.mrz.profnotes.databinding.FragmentHomeBinding
import ru.mrz.profnotes.ui.home.adapter.MyNotesAdapter
import ru.mrz.profnotes.ui.home.adapter.NewNotesAdapter

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewPagerAdapter by lazy { NewNotesAdapter() }
    private val myNotesAdapter by lazy { MyNotesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}