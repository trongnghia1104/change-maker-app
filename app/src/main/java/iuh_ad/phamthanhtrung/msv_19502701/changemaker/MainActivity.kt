package iuh_ad.phamthanhtrung.msv_19502701.changemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        onClickKeypad()
    }

    private fun onClickKeypad() {
        var newPrice: String = if (currAmount.text.toString() == "0.00") "" else currAmount.text.toString()

        btn1.setOnClickListener {
            newPrice += "1"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btn2.setOnClickListener {
            newPrice += "2"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btn3.setOnClickListener {
            newPrice += "3"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btn4.setOnClickListener {
            newPrice += "4"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btn5.setOnClickListener {
            newPrice += "5"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btn6.setOnClickListener {
            newPrice += "6"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btn7.setOnClickListener {
            newPrice += "7"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btn8.setOnClickListener {
            newPrice += "8"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btn9.setOnClickListener {
            newPrice += "9"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btn0.setOnClickListener {
            newPrice += "0"
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        btnClear.setOnClickListener {
            newPrice = ""
            currAmount.text = "0.00"
        }
//        btn1.setOnClickListener {
//            Toast.makeText(this, txtPrice, Toast.LENGTH_SHORT).show()
//            currAmount.text = onChange(1, txtPrice)
//        }
    }

//    private fun onChange(num: Int, txtPrice: String): String {
//        if (num == -1) {
//            return "0.00"
//        }
//        var newPrice: String = txtPrice
//        newPrice += num.toString()
//        newPrice = newPrice.toInt().toString()
//
//        return (newPrice.toDouble() / 100.0).toString()
//    }
}
