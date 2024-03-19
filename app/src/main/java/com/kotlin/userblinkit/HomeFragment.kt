package com.kotlin.userblinkit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.kotlin.userblinkit.activity.AuthMainActivity
import com.kotlin.userblinkit.adapters.CategoryAdapter
import com.kotlin.userblinkit.databinding.FragmentHomeBinding
import com.kotlin.userblinkit.models.CategoryModel
import com.kotlin.userblinkit.viewModels.AuthViewModel
import java.util.Locale.Category

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        changeStatusBarColor()
        setAllCategories()
        clickOnBtnLogout()
        return binding.root
    }

    private fun setAllCategories() {
        val categoryList = ArrayList<CategoryModel>()
        val len = Constants.arrayProductCategoryIcon.size
            for( i in 0 until len){
                categoryList.add(CategoryModel(Constants.allProductCategory[i],Constants.arrayProductCategoryIcon[i]))
            }

        binding.rvCategories.adapter = CategoryAdapter(categoryList)

    }

    private fun clickOnBtnLogout() {
        binding.btnLogout.setOnClickListener {
        if(viewModel.logoutCurrentUse()){
            startActivity(Intent(requireActivity(), AuthMainActivity::class.java))
            requireActivity().finish()
            }
        }
    }

    private fun changeStatusBarColor() {
        activity?.window?.apply {
            val statusBarColors = ContextCompat.getColor(requireContext(), R.color.orange)
            statusBarColor = statusBarColors
        }
    }
}