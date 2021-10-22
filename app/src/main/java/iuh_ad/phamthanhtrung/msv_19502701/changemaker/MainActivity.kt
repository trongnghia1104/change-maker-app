package iuh_ad.phamthanhtrung.msv_19502701.changemaker

import android.icu.util.UniversalTimeScale.toBigDecimal
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    private val MAX_PRICE: Double = 20 * 9999.0
    private val magicNumber: Int = 6
    private lateinit var prices: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prices = arrayOf(
            qty20dollars, qty10dollars,
            qty5dollars, qty1dollar,
            qty25cents, qty10cents,
            qty5cents, qty1cent
        )

        var newPrice: String = if (
            currAmount.text.toString() == "0.00"
        ) "" else currAmount.text.toString()

        /* function that return value of button, -1 if it is clear button */
        fun getValue(btn: TextView): Int {
            return when(btn.text.toString()) {
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
                newPrice = ""
                currAmount.text = "0.00"
                prices.forEach { it -> it.text = "0" }
                return
            }

            /* current amount is too big */
            if (newPrice.length > magicNumber) {
                Toast.makeText(this, getString(R.string.alertBigNum), Toast.LENGTH_SHORT).show()
                return
            }

            /* change current price */
            newPrice += value.toString()
            newPrice = newPrice.toInt().toString()

            var parsedNumber = newPrice.toDouble() / 100.0
            currAmount.text = parsedNumber.toString()

            val listPrices = arrayOf(20.0, 10.0, 5.0, 1.0, 0.25, 0.1, 0.05, 0.01)
            for (i in listPrices.indices) {
                var amounts = (parsedNumber / listPrices[i]).toInt()
                prices[i].text = amounts.toString()
                parsedNumber -= amounts.toDouble() * listPrices[i]
                parsedNumber = parsedNumber.toBigDecimal().setScale(magicNumber, RoundingMode.UP).toDouble()
            }
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
        super.onSaveInstanceState(outState)
        var currPrice: TextView = currAmount
        var oldPrices: ArrayList<String> = ArrayList()

        for (i in prices) {
            oldPrices.add(i.text.toString())
        }

        outState.putString("currPrice", currPrice.text.toString())
        outState.putStringArrayList("oldPrices", oldPrices)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currAmount.text = savedInstanceState.getString("currPrice")
        var oldPrices = savedInstanceState.getStringArrayList("oldPrices")

        for (i in prices.indices) {
            prices[i].text = oldPrices?.get(i) ?: "0"
        }
    }
}
