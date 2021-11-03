package com.example.tipcal

import android.R.anim
import android.animation.ArgbEvaluator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.DecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.animation.AnimationUtils


class HomeActivity : AppCompatActivity() {
    private lateinit var tvBase: TextView
    private lateinit var etBase: EditText
    private lateinit var seekBarTipPercentage: SeekBar
    private lateinit var tvTipAmount: TextView
    private lateinit var tvTotalAmount: TextView
    private lateinit var tvTipPercentage: TextView
    private lateinit var tvTipCommenter: TextView
    private lateinit var tvTipCommenterMoving: TextView //textview only for the moving text

    private var commentFlag: String = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        etBase = findViewById(R.id.etBase)
        tvBase = findViewById(R.id.tvBase)
        tvTipPercentage = findViewById(R.id.tvTipPercentage)
        seekBarTipPercentage = findViewById(R.id.seekBarTipPercentage)
        tvTipAmount = findViewById(R.id.tvTipAmount)
        tvTotalAmount = findViewById(R.id.tvTotalAmount)
        tvTipCommenter = findViewById(R.id.tvTipCommenter)
        tvTipCommenterMoving= findViewById(R.id.tvTipCommenterMoving)

        tvTipCommenterMoving.text = " "
        seekBarTipPercentage.progress = 15 //Initial Value for the SeekBar
        tvTipPercentage.text = "15%"       //Initial Value for the SeekBar tv

        seekBarTipPercentage.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                commentFlag = "STOP"
                Log.i("MainActivity", "$commentFlag")
            }
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.i("MainActivity", "$progress")
                tvTipPercentage.text = "$progress%"
                if (seekBar != null && !etBase.text.isEmpty()) {
                    tipCommenter(seekBar.progress)
                }
                calculateTipTotal()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                commentFlag = "START"
                Log.i("MainActivity", "$commentFlag")
            }
        })
        etBase.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateTipTotal()
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i("MainActivity", "etBase change $s")
            }
        })

    }
    //    val animShake:Animation = AnimationUtils.loadAnimation(this, R.anim.shake)
//    btn_done = (Button) findViewById(R.id.btn_act_confirm_done)
//    btn_done.startAnimation(animShake)
    private fun tipCommenter(tipPercent: Int) {
        tvTipCommenter.setTextSize(14F)
        when (tipPercent) {
            in 2..5 -> {
                tvTipCommenterMoving.text = " "
                tvTipCommenter.text = "Superb"
                animate(tvTipCommenter)
            }

            in 6..10 -> {
                tvTipCommenterMoving.text = " "
                tvTipCommenter.text = "Mega Superb"
                animate(tvTipCommenter)
            }

            in 10..15 -> {
                tvTipCommenterMoving.text = " "
                tvTipCommenter.text = "Super Duper Tipbilicious"
                animate(tvTipCommenter)
            }

            in 16..20 -> {
                tvTipCommenterMoving.text = " "
                tvTipCommenter.text = "Humongous TipDOCIOUS"
                animate(tvTipCommenter)
            }

            in 21..23 -> {
                tvTipCommenterMoving.text = " "
                tvTipCommenter.text = "OMNIPOTENT UNIVERSE TIP"
                animate(tvTipCommenter)
            }

            in 24..27 -> {
                tvTipCommenterMoving.text = " "
                tvTipCommenter.text = "POGGERS!"
                tvTipCommenter.setTextSize(22F)
                animate(tvTipCommenter)
            }

            in 28..30 -> {
                tvTipCommenter.text = " "
                tvTipCommenterMoving.setTextSize(22F)
                tvTipCommenterMoving.text = "DIVINE TIP"
                tvTipCommenterMoving.animate().apply {
                    duration = 1000
                    rotationYBy(720f)
                }
                animate(tvTipCommenterMoving)
            }
            else -> {
                tvTipCommenter.text = " "
                tvTipCommenterMoving.text = " "
            }

        }
        val color = ArgbEvaluator().evaluate(
                tipPercent.toFloat() / 30,
                ContextCompat.getColor(this, R.color.lowest_tip),
                ContextCompat.getColor(this, R.color.highest_tip)
        ) as Int
        tvTipCommenter.setTextColor(color)

    }

    private fun calculateTipTotal() {
        if (!etBase.text.isNullOrEmpty()){
            val baseAmount = etBase.text.toString().toDouble() //get cost of meal
            val tipPercent = seekBarTipPercentage.progress     //get percentage of tip
            val tipAmount = tipPercent*baseAmount/100          //get amount of tip
            val totalAmount = tipAmount + baseAmount           //get the total

            tvTipAmount.text = "%.2f".format(tipAmount)
            tvTotalAmount.text = "%.2f".format(totalAmount)

            if (baseAmount > 99999){
                Toast.makeText(this, "You sure you can afford that?", Toast.LENGTH_SHORT).show() //snarky comment
            }

        }
        else{
            tvTipAmount.text = ""
            tvTotalAmount.text = ""
        }

    }

    private fun animate(tvTipCommenter: TextView){

        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.startOffset = 1000
        fadeOut.duration = 1000
        fadeOut.fillAfter = true
        tvTipCommenter.startAnimation(fadeOut)
    }
}