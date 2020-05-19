package com.guoj.training.vp
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.guoj.training.databinding.FragmentSmileBinding


class RotateFragment : Fragment() {
    companion object {
        fun newInstance() = RotateFragment()
    }
    private lateinit var binding:FragmentSmileBinding
    private lateinit var viewModel: RotateViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSmileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RotateViewModel::class.java)
        binding.imageView.rotation = viewModel.rotationPosition
        val animation:ObjectAnimator=ObjectAnimator.ofFloat(binding.imageView,"rotation",0f,0f).apply { duration=500 }
        binding.imageView.setOnClickListener { view: View? ->
           if (!animation.isRunning){
               animation.setFloatValues(binding.imageView.rotation,binding.imageView.rotation+100)
               viewModel.rotationPosition=binding.imageView.rotation+100
               animation.start()
           }
        }
    }

}
