package com.example.githubclient.presentation.ui.language

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.githubclient.databinding.FragmentLanguageBinding
import com.example.githubclient.domain.model.settings.Language
import com.example.githubclient.presentation.extension.applyWindowInsets
import org.koin.androidx.viewmodel.ext.android.viewModel

class LanguageFragment : Fragment() {

    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel by viewModel<LanguageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentLanguageBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            appBar.applyWindowInsets()

            when (viewModel.selectedLanguage) {
                Language.EN -> buttonEn
                Language.RU -> buttonRu
            }.isChecked = true

            radioGroup.setOnCheckedChangeListener { _, buttonId ->
                val language = when (buttonId) {
                    buttonEn.id -> Language.EN
                    buttonRu.id -> Language.RU
                    else -> error("incorrect buttonId $buttonId")
                }
                viewModel.selectedLanguage = language

                activity?.recreate()
            }

            toolbar.setupWithNavController(findNavController())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}