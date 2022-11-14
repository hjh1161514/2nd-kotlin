package com.second.kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.second.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isPreview = false
    private var preNumber: Long = 0
    private var preNumberDouble = 0.0
    private var nowNumber = ""
    private var recentOperator = ""
    private var isDouble = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initBtnClickListener()

        setContentView(binding.root)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initBtnClickListener() {
        with(binding) {
            btnOne.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("1")
                        btnOne.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnOne.textSize = 30F
                    }
                }
                true
            }
            btnTwo.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("2")
                        btnTwo.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnTwo.textSize = 30F
                    }
                }
                true
            }
            btnThree.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("3")
                        btnThree.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnThree.textSize = 30F
                    }
                }
                true
            }
            btnFour.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("4")
                        btnFour.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnFour.textSize = 30F
                    }
                }
                true
            }
            btnFive.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("5")
                        btnFive.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnFive.textSize = 30F
                    }
                }
                true
            }
            btnSix.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("6")
                        btnSix.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnSix.textSize = 30F
                    }
                }
                true
            }
            btnSeven.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("7")
                        btnSeven.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnSeven.textSize = 30F
                    }
                }
                true
            }
            btnEight.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("8")
                        btnEight.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnEight.textSize = 30F
                    }
                }
                true
            }
            btnNine.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("9")
                        btnNine.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnNine.textSize = 30F
                    }
                }
                true
            }
            btnZero.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addNumber("0")
                        btnZero.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnZero.textSize = 30F
                    }
                }
                true
            }

            // 연산자
            btnRemainder.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addOperator("%")
                        btnRemainder.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnRemainder.textSize = 30F
                    }
                }
                true
            }
            btnDivision.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addOperator("÷")
                        btnDivision.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnDivision.textSize = 30F
                    }
                }
                true
            }
            btnMultiplication.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addOperator("×")
                        btnMultiplication.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnMultiplication.textSize = 30F
                    }
                }
                true
            }
            btnMinus.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addOperator("-")
                        btnMinus.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnMinus.textSize = 30F
                    }
                }
                true
            }
            btnPlus.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        addOperator("+")
                        btnPlus.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnPlus.textSize = 30F
                    }
                }
                true
            }

            // 부호 버튼
            btnSymbol.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        initSymbolBtnClickListener()
                        btnSymbol.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnSymbol.textSize = 30F
                    }
                }
                true
            }

            // = 버튼
            btnEqual.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        initEqualBtnClickListener()
                        btnEqual.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnEqual.textSize = 30F
                    }
                }
                true
            }

            // 지우기 버튼
            ivDelete.setOnClickListener {
                tvInput.text = tvInput.text.dropLast(1)
                tvResult.text = ""
                nowNumber = ""
            }

            // AC 버튼
            btnAc.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        initACBtnClickListener()
                        btnAc.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnAc.textSize = 30F
                    }
                }
                true
            }

            // . 버튼
            btnPoint.setOnTouchListener { _: View, event: MotionEvent ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        initPointClickListener()
                        btnPoint.textSize = 20F
                    }
                    MotionEvent.ACTION_UP -> {
                        btnPoint.textSize = 30F
                    }
                }
                true
            }
        }
    }

    private fun addNumber(str: String) {
        binding.btnAc.text = "C"
        if (binding.tvInput.text.length > 15) {
            Toast.makeText(this, "15자리까지 입력할 수 있어요", Toast.LENGTH_SHORT).show()
        } else if (isPreview) {
            when (recentOperator) {
                "+" -> {
                    nowNumber += str
                    if (isDouble) {
                        if (preNumber.plus(nowNumber.toDouble()).toString().length > 15) {
                            limitResultLength()
                        } else {
                            binding.tvResult.text = preNumberDouble.plus(nowNumber.toDouble()).toString()
                            binding.tvInput.append(str)
                        }
                    } else {
                        if (preNumber.plus(nowNumber.toLong()).toString().length > 15) {
                            limitResultLength()
                        } else {
                            binding.tvResult.text = preNumber.plus(nowNumber.toLong()).toString()
                            binding.tvInput.append(str)
                        }
                    }
                }
                "-" -> {
                    nowNumber += str
                    if (isDouble) {
                        if (preNumber.minus(nowNumber.toDouble()).toString().length > 15) {
                            limitResultLength()
                        } else {
                            binding.tvResult.text = preNumberDouble.minus(nowNumber.toDouble()).toString()
                            binding.tvInput.append(str)
                        }
                    } else {
                        if (preNumber.minus(nowNumber.toLong()).toString().length > 15) {
                            limitResultLength()
                        } else {
                            binding.tvResult.text = preNumber.minus(nowNumber.toLong()).toString()
                            binding.tvInput.append(str)
                        }
                    }
                }
                "×" -> {
                    nowNumber += str
                    var result = ""
                    if (isDouble) {
                        result = preNumber.times(preNumberDouble.toDouble()).toString()
                    } else {
                        result = preNumber.times(nowNumber.toLong()).toString()
                    }
                    if (result.length > 15) {
                        limitResultLength()
                    } else {
                        binding.tvResult.text = result
                        binding.tvInput.append(str)
                    }
                }
                "÷" -> {
                    if (str == "0") {
                        Toast.makeText(this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show()
                    } else {
                        nowNumber += str
                        var result = ""
                        if (isDouble) {
                            result = preNumberDouble.div(nowNumber.toDouble()).toString()
                        } else {
                            result = preNumber.div(nowNumber.toLong()).toString()
                        }
                        if (result.length > 15) {
                            limitResultLength()
                        } else {
                            binding.tvResult.text = result
                            binding.tvInput.append(str)
                        }
                    }
                }
                "%" -> {
                    if (str == "0") {
                        Toast.makeText(this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show()
                    } else {
                        nowNumber += str
                        var result = ""
                        if (isDouble) {
                            result = preNumberDouble.rem(nowNumber.toDouble()).toString()
                        } else {
                            result = preNumber.rem(nowNumber.toLong()).toString()
                        }
                        if (result.length > 15) {
                            limitResultLength()
                        } else {
                            binding.tvResult.text = result
                            binding.tvInput.append(str)
                        }
                    }
                }
            }
        } else {
            binding.tvInput.append(str)
        }
    }

    private fun limitResultLength() {
        Toast.makeText(this, "15자리까지만 계산 가능합니다.", Toast.LENGTH_SHORT).show()
        nowNumber = nowNumber.dropLast(1)
    }

    private fun addOperator(str: String) {
        if (binding.tvInput.text.isEmpty()) {
            Toast.makeText(this, "완성되지 않은 수식입니다.", Toast.LENGTH_SHORT).show()
        } else {
            if (isPreview) {
                if (nowNumber.isEmpty()) {
                    recentOperator = str
                    binding.tvInput.text = binding.tvInput.text.dropLast(1).toString().plus(recentOperator)
                } else {
                    if (isDouble) {
                        preNumberDouble = binding.tvResult.text.toString().toDouble()
                    } else {
                        preNumber = binding.tvResult.text.toString().toLong()
                    }
                    binding.tvInput.append(str)
                    recentOperator = str
                    nowNumber = ""
                }
            } else {
                if (binding.tvInput.text.contains(".")) {
                    preNumberDouble = binding.tvInput.text.toString().toDouble()
                } else {
                    preNumber = binding.tvInput.text.toString().toLong()
                }
                binding.tvInput.append(str)
                isPreview = true
                recentOperator = str
                nowNumber = ""
            }
        }
    }

    private fun initSymbolBtnClickListener() {
        with(binding) {
            if (tvInput.text.isEmpty()) {
                Toast.makeText(this@MainActivity, "완성되지 않은 수식입니다.", Toast.LENGTH_SHORT).show()
            } else {
                if (isPreview) {
                    // Log.d("###", tvInput.text.substring(0, tvInput.text.length-nowNumber.length))
                    nowNumber = (nowNumber.toLong() * -1).toString()
                } else {
                    tvInput.text = (tvInput.text.toString().toLong() * -1).toString()
                }
            }
        }
    }

    private fun initEqualBtnClickListener() {
        with(binding) {
            tvInput.text = tvResult.text
            tvResult.text = ""
            preNumber = 0
            nowNumber = ""
            isPreview = false
            btnAc.text = "AC"
            isDouble = false
            preNumberDouble = 0.0
        }
    }

    private fun initACBtnClickListener() {
        with(binding) {
            tvInput.text = ""
            tvResult.text = ""
            preNumber = 0
            nowNumber = ""
            isPreview = false
            btnAc.text = "AC"
            isDouble = false
            preNumberDouble = 0.0
        }
    }

    private fun initPointClickListener() {
        with(binding) {
            if (isPreview) {
                if (nowNumber.isEmpty()) {
                    Toast.makeText(this@MainActivity, "잘못된 입력값입니다.", Toast.LENGTH_SHORT).show()
                } else {
                    if (nowNumber.contains(".")) {
                        Toast.makeText(this@MainActivity, "더이상 .을 추가할 수 없습니다", Toast.LENGTH_SHORT).show()
                    } else {
                        nowNumber += "."
                        tvInput.append(".")
                        isDouble = true
                    }
                }
            } else {
                if (tvInput.text.isEmpty()) {
                    Toast.makeText(this@MainActivity, "잘못된 입력값입니다.", Toast.LENGTH_SHORT).show()
                } else {
                    if (tvInput.text.contains(".")) {
                        Toast.makeText(this@MainActivity, "더이상 .을 추가할 수 없습니다", Toast.LENGTH_SHORT).show()
                    } else {
                        tvInput.append(".")
                        isDouble = true
                    }
                }
            }
        }
    }
}
