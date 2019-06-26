package com.fone.fonetesting.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fone.fonetesting.R
import com.fone.fonetesting.fragments.Complete_words
import com.fone.fonetesting.fragments.Dislexia_game
import kotlinx.android.synthetic.main.fragment_complete_words.*
import kotlinx.android.synthetic.main.fragment_dislexia_game.*

class GameDislexia : AppCompatActivity(), Dislexia_game.SearchGameDislexiaListener {
    override fun nextWord() {
        val numero1 = tv_nivel.getText().toString()
        val aux=numero1.toInt()

        val te= btn_verificar.getText().toString()
        tv_palabra.text=lista[aux].toString()
        tv_palabra1.text=listaopc[aux].toString()
        tv_palabra2.text=listaopc1[aux].toString()
        tv_palabra3.text=listaopc2[aux].toString()

        if(te.equals("Iniciar")){
            btn_verificar.text="Verificar"
        }

        if(te.equals("Salir") ){
            tv_nivel.text=(0).toString()



            tv_palabra.text="Fin del juego"
            tv_palabra1.text=""
            tv_palabra2.text=""
            tv_palabra3.text=""
            startActivity(Intent(this, MainActivity::class.java))

        }
        else{

            if(aux<lista.size-1){


                val palabra= tv_palabra_verificacion.getText().toString()

                var comprobando: Boolean=false

                comprobando= verification(palabra as String,aux)

                if(comprobando){
                    tv_nivel.text=((aux+1)).toString()

                    /*viewModel.updateLevel(aux+1)*/



                    tv_palabra.text=lista[aux+1]
                    tv_palabra3.text=listaopc2[aux+1].toString()
                    tv_palabra1.text=listaopc[aux+1].toString()
                    tv_palabra2.text=listaopc1[aux+1].toString()

                    Toast.makeText(this, "¡Excelente! Vamos con la siguiente palabra", Toast.LENGTH_SHORT).show()

                }
                else{
                    //tv_word.text=listaaux[aux]

                    //Toast.makeText(this, "¡Tu puedes!", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                tv_palabra.text="Fin del juego"
                //viewModel.updateLevel(0)
                opc1.text=""
                opc2.text=""
                Toast.makeText(this, "¡Lo hiciste muy bien!", Toast.LENGTH_SHORT).show()
                btn_verificar.text="Salir"

            }

        }


    }

    fun verification(texto:String, posicion:Int):Boolean{

        if(texto==lista[posicion]){
            return true
        }
        else{
            return false
        }

    }

    override fun option1() {
        val nopcion = tv_palabra1.getText().toString()
        Toast.makeText(this, nopcion, Toast.LENGTH_SHORT).show()
        tv_palabra_verificacion.text=nopcion
    }

    override fun option2() {
        val nopcion = tv_palabra2.getText().toString()
        Toast.makeText(this, nopcion, Toast.LENGTH_SHORT).show()
        tv_palabra_verificacion.text=nopcion
    }

    override fun option3() {
        val nopcion = tv_palabra3.getText().toString()
        Toast.makeText(this, nopcion, Toast.LENGTH_SHORT).show()
        tv_palabra_verificacion.text=nopcion
    }

    val lista = arrayOf("p", "q", "E", "b", "d", "3", "dra", "tra", "pra")
    val listaopc2= arrayOf("g", "q", "3", "b", "d", "3", "dra", "dra", "tra")
    val listaopc=  arrayOf("q", "p", "E", "p", "p", "F", "dar", "bra", "pra")
    val listaopc1= arrayOf("p", "g", "F", "d", "b", "E", "bra", "tra", "par")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dislexia)

        val fDetalles= Dislexia_game()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().replace(R.id.container_game_dislexia,fDetalles).commit()
    }
}
