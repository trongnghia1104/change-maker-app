package iuh_ad.phamthanhtrung.msv_19502701.changemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var prices = arrayOf(
            qty20dollars, qty10dollars,
            qty5dollars, qty1dollar,
            qty25cents, qty10cents,
            qty5cents, qty1cent
        )

        var newPrice: String = if (currAmount.text.toString() == "0.00") "" else currAmount.text.toString()

        /* function that return value of button, -1 if it is clear button */
        fun getValue(tv: TextView): Int {
            return when(tv.text.toString()) {
                "1" -> 1
                "2" -> 2
                "3" -> 3
                "4" -> 4
                "5" -> 5
                "6" -> 6
                "7" -> 7
                "8" -> 8
                "9" -> 9
                "0" -> 0
                else -> -1
            }
        }

        /* function that handles when a button is pressed */
        fun onButtonClicked(btn: TextView) {
            val value = getValue(btn)

            /* clear button is pressed */
            if (value == -1) {
                newPrice =""
                currAmount.text = "0.00"
                return
            }

            /* current amount is too big */
            if (newPrice.length > 8) {
                Toast.makeText(this, getString(R.string.alertBigNum), Toast.LENGTH_SHORT).show()
                return
            }

            /* change current price */
            newPrice += value.toString()
            newPrice = newPrice.toInt().toString()
            currAmount.text = (newPrice.toDouble() / 100.0).toString()
        }

        /* array of button */
        arrayOf<TextView>(
            btn1, btn2, btn3,
            btn4, btn5, btn6,
            btn7, btn8, btn9,
            btn0, btnClear
        ).forEach { it -> it.setOnClickListener() {
            onButtonClicked(it as TextView)
        }}
    }

    override fun onSaveInstanceState(outState: Bundle) {
        var currPrice: TextView = currAmount
        outState.putString("currPrice", currPrice.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currAmount.text = savedInstanceState.getString("currPrice")
    }
}
