package io.dreamdreamdevelopers.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtOne.setOnClickListener { setText("1", true) }
        txtTwo.setOnClickListener { setText("2", true) }
        txtThree.setOnClickListener { setText("3", true) }
        txtFour.setOnClickListener { setText("4", true) }
        txtFive.setOnClickListener { setText("5", true) }
        txtSix.setOnClickListener { setText("6", true) }
        txtSeven.setOnClickListener { setText("7", true) }
        txtEight.setOnClickListener { setText("8", true) }
        txtNine.setOnClickListener { setText("9", true) }
        txtZero.setOnClickListener { setText("0", true) }
        txtDot.setOnClickListener { setText(".", true) }

        txtPlus.setOnClickListener { setText("+",false) }
        txtMutiply.setOnClickListener { setText("*",false) }
        txtMinus.setOnClickListener { setText("-",false) }
        txtDivide.setOnClickListener { setText("/",false) }
        txtOpenBracket.setOnClickListener { setText("(",false) }
        txtCloseBracket.setOnClickListener { setText(")",false) }

        txtClear.setOnClickListener {
            txtDisplay.text = ""
            txtResult.text = ""
        }

        imgBackBtn.setOnClickListener {
            val string = txtDisplay.text.toString()
            if(string.isNotEmpty()){
                txtDisplay.text = string.substring(0,string.length-1)
            }
            txtResult.text = ""
        }

        txtEqual.setOnClickListener {
            try{
                val expression = ExpressionBuilder(txtDisplay.text.toString()).build()
                val result = expression.evaluate()
                txtResult.text = result.toString()
            }catch (e:Exception){
                Toast.makeText(this,"Error Message :"+e.message,Toast.LENGTH_LONG).show()

            }
        }

    }

    fun setText(string: String, check: Boolean) {
        if (check) {
            txtResult.text = ""
            txtDisplay.append(string)
        } else {
            txtDisplay.append(txtResult.text)
            txtDisplay.append(string)
            txtResult.text = ""
        }

        if (txtResult.text.isNotEmpty()) {
            txtDisplay.text = ""
        }
    }
}