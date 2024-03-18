package com.kotlin.userblinkit.authFragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.kotlin.userblinkit.R
import com.kotlin.userblinkit.Utils
import com.kotlin.userblinkit.activity.UsersMainActivity
import com.kotlin.userblinkit.databinding.FragmentSplashBinding
import com.kotlin.userblinkit.viewModels.AuthViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentSplashBinding.inflate(layoutInflater)
        changeStatusBarColor()
        Handler(Looper.getMainLooper()).postDelayed({
//            loggedInUser()

            lifecycleScope.launch {
                viewModel.isACurrentUser.collectLatest {
                    if(it){
                        startActivity(Intent(requireActivity(), UsersMainActivity::class.java))
                        requireActivity().finish()
                    }
                    else{
                        findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
                    }
                }
            }
        },3000)
        return binding.root
    }

    private fun changeStatusBarColor() {
        activity?.window?.apply {
            val statusBarColors = ContextCompat.getColor(requireContext(), R.color.yellow)
            statusBarColor = statusBarColors
        }
    }

    private fun loggedInUser(){
        val currentUser = Utils.getAuthInstance().currentUser
        if(currentUser!=null){
            startActivity(Intent(requireActivity(), UsersMainActivity::class.java))
            requireActivity().finish()
        }
    }
}