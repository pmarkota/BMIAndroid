package hr.algebra.bodymassindex

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import hr.algebra.bodymassindex.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var validationFields: List<EditText>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValidation()
        setupListeners()
    }

    private fun initValidation() {
        validationFields= listOf(
            binding.etHeight,
            binding.etWeight
        )
    }

    private fun setupListeners() {
        binding.btnCalculate.setOnClickListener {
            if(formValid()) {
                val result: Double? = calculate(
                    binding.etWeight.text.toString().toDouble(),
                    binding.etHeight.text.toString().toDouble()
                )
                showResult(result)
            }
        }
    }

    private fun formValid(): Boolean {
        validationFields.forEach{
            if (it.text.toString().isBlank()){
                it.error= getString(R.string.please_insert_value)
                it.requestFocus()
                return false
            }
        }
        return true

    }

    private fun calculate(weight: Double, height: Double): Double? {
        if(weight <=0 || height <=0){
            return null
        }
        else{
            val heightFinal = if(height>3) height/100 else height
            return weight/heightFinal.pow(2)
        }
    }

    private fun showResult(result: Double?)=when {
        result==null->{

        }result<=20->{

        }else->{

        }
    }
}