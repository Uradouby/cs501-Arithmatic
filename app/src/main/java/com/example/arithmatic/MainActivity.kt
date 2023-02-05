package com.example.arithmatic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import androidx.activity.viewModels
import com.example.arithmatic.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: ArithViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.caculatebutton.setOnClickListener{ view: View ->
            when (model.checkStatus()) {
                0->{
                    binding.answer.setText(model.getAnswer().toString())
                }
                -1->{
                    Snackbar.make(
                        this,
                        view,
                        "Please select an operator!",
                        BaseTransientBottomBar.LENGTH_SHORT).show()
                        binding.answer.setText(R.string.Answer)
                        binding.radiogroup.clearCheck()
                        model.setop(0)
                    }
                -2->{
                    Snackbar.make(
                        this,
                        view,
                        "Please make sure all operands are not empty!",
                        BaseTransientBottomBar.LENGTH_SHORT).show()
                    binding.answer.setText(getString(R.string.Answer))
                    binding.radiogroup.clearCheck()
                    model.setop(0)
                }
                -3->{
                    Snackbar.make(
                        this,
                        view,
                        "Divide by 0 is not allowed!",
                        BaseTransientBottomBar.LENGTH_SHORT).show()
                        binding.answer.setText(getString(R.string.Answer))
                        binding.radiogroup.clearCheck()
                        model.setop(0)
                    }
                }

        }

        binding.operand1.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(editable: Editable) {
                model.setop1(editable.toString())
            }
        })


        binding.operand2.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(editable: Editable) {
                model.setop2(editable.toString())
            }
        })

        binding.radiogroup.setOnCheckedChangeListener{
                group:RadioGroup,checkedID:Int->
                when (checkedID) {
                    R.id.radiobutton1-> model.setop(1)
                    R.id.radiobutton2-> model.setop(2)
                    R.id.radiobutton3-> model.setop(3)
                    R.id.radiobutton4-> model.setop(4)
                    R.id.radiobutton5-> model.setop(5)
                }
        }

        updateView()
        setContentView(binding.root)

    }
    private fun updateView()
    {
        binding.operand1.setText(model.getop1())
        binding.operand2.setText(model.getop2())
        if (model.checkStatus()==0) binding.answer.setText(model.getAnswer().toString())
    }


}