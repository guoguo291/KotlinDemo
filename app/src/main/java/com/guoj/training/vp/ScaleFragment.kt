package com.guoj.training.vp
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.guoj.training.databinding.FragmentSmileBinding


class ScaleFragment : Fragment() {
    companion object {
        fun newInstance() = ScaleFragment()
    }
    private lateinit var binding:FragmentSmileBinding
    private lateinit var viewModel: ScaleViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSmileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScaleViewModel::class.java)
        binding.imageView.scaleX=viewModel.scaleFactor
        binding.imageView.scaleY=viewModel.scaleFactor
        val objectAnimatorX = ObjectAnimator.ofFloat(binding.imageView, "scaleX", 0f, 1f).apply { duration=500 }
        val objectAnimatorY = ObjectAnimator.ofFloat(binding.imageView, "scaleY", 0f, 1f).apply { duration=500 }
        binding.imageView.setOnClickListener { view: View ->
            objectAnimatorX.setFloatValues(view.scaleX,view.scaleX+0.1f)
            objectAnimatorY.setFloatValues(view.scaleY,view.scaleY+0.1f)
            viewModel.scaleFactor+=0.1f
            objectAnimatorX.start()
            objectAnimatorY.start()
        }
    }

}
