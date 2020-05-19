package com.guoj.training.vp
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.guoj.training.databinding.FragmentSmileBinding
import kotlin.random.Random


class TranslationFragment : Fragment() {
    companion object {
        fun newInstance() = TranslationFragment()
    }
    private lateinit var binding:FragmentSmileBinding
    private lateinit var viewModel: TranslationViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSmileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TranslationViewModel::class.java)
        val objectAnimator = ObjectAnimator.ofFloat(binding.imageView, "x", 0f, 0f).apply { duration=500 }
        binding.imageView.x+=viewModel.dx
        binding.imageView.setOnClickListener { view ->
            if (!objectAnimator.isRunning){
                var dx:Float= Random.nextInt(-100,100).toFloat()
                objectAnimator.setFloatValues(view.x,view.x+ dx)
                viewModel.dx+=dx
                objectAnimator.start()
            }
        }
    }

}
