package kg.tutorialapp.homework_38

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), FragmentAListener, FragmentBListener {

    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()

        val drawer = findViewById<DrawerLayout>(R.id.drawerLayout)

        val navView = findViewById<NavigationView>(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT).show()
                R.id.nav_message -> Toast.makeText(applicationContext, "Clicked Message", Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> Toast.makeText(applicationContext, "Clicked Settings", Toast.LENGTH_SHORT).show()
                R.id.nav_help -> Toast.makeText(applicationContext, "Clicked Help", Toast.LENGTH_SHORT).show()
            }
            true
        }

    }

    private fun setup() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, FragmentA.newInstance(), FragmentA.TAG)
                .add(R.id.container2, FragmentB(), FragmentB.TAG)
                .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setTextToFragmentB(text: String) {
        (supportFragmentManager.findFragmentByTag(FragmentB.TAG) as FragmentB).setNewText(text)
    }

    override fun setTextToFragmentA(text: String) {
        (supportFragmentManager.findFragmentByTag(FragmentA.TAG) as FragmentA).set2NewText(text)
    }

}
