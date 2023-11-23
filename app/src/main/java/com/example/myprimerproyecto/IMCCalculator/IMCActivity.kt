package com.example.myprimerproyecto.IMCCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.myprimerproyecto.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCActivity : AppCompatActivity() {

    //DECLARACION DE LAS VARIABLES 1.1
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 10
    private var currentHeight: Int = 180

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    //ARRIBA DECLARACION DE LOS COMPONENTES
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tViewHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)
        initComponents()
        initListeners()
        initUI()
    }

    //SE DECLARA EN UNO DE LOS METODOS
    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tViewHeight = findViewById(R.id.tViewHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tViewHeight.text = "$currentHeight cm"
        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
             calculateIMC()

        }

    }
    private fun calculateIMC(){
        val df = DecimalFormat("#.##")
        val imc = currentWeight/(currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        val result= df.format(imc).toDouble()
        Log.i("jonaApp", "Peso actual: $currentWeight, Altura actual: $currentHeight, IMC: $result")

    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    //LLAMAR A LA FUNCION "changeGender desde el "initListener"
    //y tiene que estar antes del "setGenderColor"
    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    //COMO "setGeneratorColor" ESTA PIDIENDO UN PARAMETRO
    //DECLARAMOS DOS VARIABLES ARRIBA 1.0
    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }


    //ESTA FUNCION OBTIENE LA REFERENCIA AL COLOR "R."
    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReferences = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        //LLAMA AL COLOR (contextCompat)
        return ContextCompat.getColor(this, colorReferences)
    }

    //CREAR OTRA FUNCION LLAMADA "initUI" Y LLAMARLA DESDE EL "onCreate" PARA
    //EJECUTAR A "setGenderColor"

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
        calculateIMC()
    }


}