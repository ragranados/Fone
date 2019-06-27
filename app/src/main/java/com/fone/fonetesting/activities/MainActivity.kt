package com.fone.fonetesting.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.fone.fonetesting.R
import com.fone.fonetesting.Settings
import com.fone.fonetesting.fragments.FirstLevelFragment
import com.fone.fonetesting.fragments.SecondLevelFragment
import com.fone.fonetesting.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SecondLevelFragment.SearchNewGameListener,
        SettingsFragment.OnFragmentInteractionListener, FirstLevelFragment.SearchInformationListener {


    var setting = Settings.instance
    override fun GameDislexia() {
        var mIntent = Intent(this, GameDislexia::class.java)
        mIntent.putExtra("key_level", "hola")
        this.startActivity(mIntent)
    }

    override fun dislexia() {
        var mIntent = Intent(this, Information::class.java)
        val texto1 =
                "La dislexia se puede evidenciar ya que las personas manifiestan dificultades para recitar el alfabeto, denominar letras, realizar rimas simples y para analizar o clasificar los sonidos."
        val texto2 =
<<<<<<< HEAD
            "Es necesario aclarar un punto muy importante, las personas diagnosticadas con dislexia no es por problemas en la visión, ya que muchas personas creen que por el hecho de invertir las letras o escribirlas revés es debido a eso."
        val texto3 =
            "A las personas con dislexia el proceso de aprendizaje es mucho más complicado ya que casi todo se basa en lectura y escritura, pero esto no significa que no puedan llevar a cabo sus estudios, ya que existen profesionales que ayudan con métodos de enseñanza, el primero en usar fue un enfoque llamado Orton-Gillingham (O-G)."
=======
                "Es necesario aclarar un punto muy importante, las personas diagnosticadas con dislexia no es por problemas en la vision, ya que muchas personas creen que por el hecho de invertir las letras o escribirlas revés es debido a eso."
        val texto3 =
                "A las personas con dislexia el proceso de aprendizaje es mucho más complicado ya que casi todo se basa en lectura y escritura, pero esto no significa que no puedan llevar a cabo sus studios, ya que existen profesionales que ayudan con métodos de enseñanza, el primero en usar fue un enfoque llamado Orton-Gillingham (O-G)."
>>>>>>> f2b2abbe659f66985b462db3b0c266760f1532df
        val texto4 =
                "Una de las cosas en que se enfoca esta instrucción es en la conciencia fonológica. Se trata de una habilidad del lenguaje que se desarrolla tempranamente y es clave para leer. Los especialistas en lectura y los patólogos del habla y el lenguaje pueden ayudar a los chicos a desarrollar esta habilidad. También pueden ayudar con la decodificación, el reconocimiento de palabras, la ortografía y la fluidez en la lectura."
        mIntent.putExtra("key_texto1", texto1)
        mIntent.putExtra("key_texto2", texto2)
        mIntent.putExtra("key_texto3", texto3)
        mIntent.putExtra("key_texto4", texto4)


        this.startActivity(mIntent)
    }

    override fun sintomas() {
        var mIntent = Intent(this, Information::class.java)
        val texto1 =
<<<<<<< HEAD
            "Es muy importante conocer los síntomas  de la dislexia, ya que es algo que se presenta desde temprana edad, por ende, se puede confundir con errores comunes al momento en que se comienza a leer y a escribir. \n\n Algunos síntomas son: "
=======
                "Es muy importante conocer los sintomas de la dislexia, ya que es algo que se presenta desde temprana edad, por ende, se puede confundir con errores comunes al momento en que se comienza a leer y a escribir. \n Algunos sintomas son: "
>>>>>>> f2b2abbe659f66985b462db3b0c266760f1532df
        val texto2 =
                "En Preescolar tienen dificultad para aprender palabras nuevas y reconocer las letras y hacerlas coincidir con el sonido que producen. "
        val texto3 =
                "En Primaria olvidan rápidamente cómo escribir muchas de las palabras que estudian, a menudo no pueden reconocer palabras familiares a simple vista y se confunden con los problemas matemáticos de lógica."
        val texto4 =
                "En la escuela media: Cometen muchos errores de ortografía, frecuentemente tienen que releer oraciones y párrafos y leen a un nivel académico inferior a como hablan"
        mIntent.putExtra("key_texto1", texto1)
        mIntent.putExtra("key_texto2", texto2)
        mIntent.putExtra("key_texto3", texto3)
        mIntent.putExtra("key_texto4", texto4)


        this.startActivity(mIntent)

    }

    override fun causas() {
        var mIntent = Intent(this, Information::class.java)
        val texto1 = "Ampliando el por que de los sintomas: "
        val texto2 =
                "-Genes y herencia: A menudo la dislexia se presenta en miembros de la misma familia. Cerca del 40% de los hermanos de chicos con dislexia tienen las mismas dificultades con la lectura. El 49% de los padres/madres de chicos con dislexia también las tienen. Los científicos también han encontrado un grupo de genes relacionados con las dificultades para leer y con el procesamiento del lenguaje."
        val texto3 =
                "-Anatomía y actividad cerebral: Los estudios de imágenes del cerebro han mostrado diferencias entre las personas con y sin dislexia. Esas diferencias ocurren en áreas del cerebro relacionadas con habilidades para leer que son importantes. Esas destrezas son conocer cómo los sonidos son representados en palabras y reconocer cómo lucen las palabras escritas."
        val texto4 = ""
        mIntent.putExtra("key_texto1", texto1)
        mIntent.putExtra("key_texto2", texto2)
        mIntent.putExtra("key_texto3", texto3)
        mIntent.putExtra("key_texto4", texto4)


        this.startActivity(mIntent)

    }

    override fun setSettings(speed: Float, pitch: Float) {
        var localSpeed = speed
        var localPitch = pitch

        if (speed <= 0) {
            localSpeed = 0.1f
        }

        if (pitch <= 0) {
            localPitch = 0.1f
        }

        setting.speed = localSpeed
        setting.pitch = localPitch

    }

    override fun logOutF() {
        logOut()
    }

    override fun JuegoUnirPalabras() {
        startActivity(Intent(this, WordMatchWordLevelActivity::class.java))
    }

    override fun Game1() {
        var mIntent = Intent(this, Game1::class.java)

        mIntent.putExtra("key_level", "hola")

        this.startActivity(mIntent)
    }

    private var mAuth: FirebaseAuth? = null


    //var pagerAdapter: PageAdapter?=null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragment(FirstLevelFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_play -> {
                replaceFragment(SecondLevelFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_settings -> {
                replaceFragment(SettingsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        /*pagerAdapter = PageAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(FirstLevelFragment(), "First Level")
        pagerAdapter!!.addFragments(SecondLevelFragment(), "Second Level")

        vp_container.adapter = pagerAdapter*/

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            val fragment = SecondLevelFragment()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.vp_container, fragment, fragment.javaClass.simpleName)
                    .commit()
        }

    }

    fun logOut() {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.vp_container, fragment)
        fragmentTransaction.commit()
    }
}
