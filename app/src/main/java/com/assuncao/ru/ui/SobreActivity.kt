package com.assuncao.ru.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assuncao.ru.R
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class SobreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        // set Arrow Back to Menu
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.arrow_back)

        sobreInstituto()
        sobreAutores()
    }

    private fun sobreInstituto(){
        val imageSlider = findViewById<ImageSlider>(R.id.imageSliderIcet)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.icet))
        imageList.add(SlideModel(R.drawable.icet_um))
        imageList.add(SlideModel(R.drawable.icet_dois))
        imageList.add(SlideModel(R.drawable.icet_tres))

        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
    }

    private fun sobreAutores() {
        val imageSlider = findViewById<ImageSlider>(R.id.imageSliderAutores)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.vandermir, "  Professor Dr. Vandermir Silva"))
        imageList.add(SlideModel(R.drawable.assuncao, "  Felipe Assunção | Developer"))
        imageList.add(SlideModel(R.drawable.filipe, "  Filipe Dias | Scrum Master"))
        imageList.add(SlideModel(R.drawable.thiago, "  Thiago Rodrigues | Documentation"))
        imageList.add(SlideModel(R.drawable.joao, "  João Victor | Designer and Documentation"))
        imageList.add(SlideModel(R.drawable.daniel, "  Carlos Daniel | Suporte"))

        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
    }
}