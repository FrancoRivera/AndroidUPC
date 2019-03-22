package pe.edu.upc.navsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var host = NavHostFragment.create(R.navigation.sample_nav_graph)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, host)
            .setPrimaryNavigationFragment(host)
            .commit()
    }
}
