import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.maximvs.trackingtravel.ActivityRequest
import com.maximvs.trackingtravel.FirstFragment
import com.maximvs.trackingtravel.R
import com.maximvs.trackingtravel.RequestFragment
import com.maximvs.trackingtravel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initNavigation()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ActivityRequest::class.java)
            startActivity(intent)
        })
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, FirstFragment())
            .addToBackStack(null)
            .commit()


    }

    fun launchRequestFragment() {
        val bundle = Bundle()
        bundle.putParcelable()
        val fragment = RequestFragment()
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }

}
