package com.maxxxwk.hometaskl18

import android.graphics.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import com.maxxxwk.hometaskl18.databinding.BitmapFragmentBinding
import java.io.ByteArrayOutputStream

class BitmapFragment : Fragment() {

    private lateinit var binding: BitmapFragmentBinding

    companion object {
        fun newInstance() = BitmapFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BitmapFragmentBinding.inflate(inflater, container, false)
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.btnDraw.setOnClickListener {
            val bitmap = binding.ivBitmap.drawToBitmap()
            drawBorders(Canvas(bitmap))
            setImageFromByteArray(convertToByteArray(bitmap))
        }
    }

    private fun drawBorders(canvas: Canvas) {
        canvas.apply {
            val p = Paint()
            p.color = Color.GREEN
            p.strokeWidth = 40f
            drawLine(
                0f, 0f, 0f,
                binding.ivBitmap.height.toFloat(), p
            )
            drawLine(0f, 0f, binding.ivBitmap.width.toFloat(), 0f, p)
            drawLine(
                0f,
                binding.ivBitmap.height.toFloat(),
                binding.ivBitmap.height.toFloat(),
                binding.ivBitmap.width.toFloat(),
                p
            )
            drawLine(
                binding.ivBitmap.width.toFloat(), 0f, binding.ivBitmap.width.toFloat(),
                binding.ivBitmap.height.toFloat(), p
            )
        }
    }

    private fun convertToByteArray(bitmap: Bitmap): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        return byteArrayOutputStream.toByteArray()
    }

    private fun setImageFromByteArray(byteArray: ByteArray) {
        binding.ivBitmap.setImageBitmap(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size))
    }
}