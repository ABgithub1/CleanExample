package com.example.githubclient.presentation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import coil.load
import com.example.githubclient.R
import com.example.githubclient.databinding.FragmentUserDetailsBinding
import com.example.githubclient.presentation.extension.applyWindowInsets
import com.example.githubclient.presentation.model.LceState
import com.example.githubclient.presentation.model.onContent
import com.example.githubclient.presentation.model.onError
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserDetailsFragment : Fragment() {

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val args: UserDetailsFragmentArgs by navArgs()

    private val viewModel by viewModel<UserDetailsViewModel> {
        parametersOf(args.login)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserDetailsBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            toolbar.setupWithNavController(findNavController())
            toolbar.title = args.login
            appBar.applyWindowInsets()

            viewModel
                .userDetailsFlow
                .onEach { lceState ->
                    progress.isVisible = lceState == LceState.Loading
                    lceState
                        .onContent { userDetails ->
                            avatar.load(userDetails.avatarUrl)
                            login.text = userDetails.login
                            followers.text =
                                getString(R.string.user_details_followers, userDetails.followers)
                            following.text =
                                getString(R.string.user_details_following, userDetails.following)
                        }
                        .onError { throwable ->
                            Snackbar.make(
                                root,
                                throwable.localizedMessage ?: getString(R.string.general_error),
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                }
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}