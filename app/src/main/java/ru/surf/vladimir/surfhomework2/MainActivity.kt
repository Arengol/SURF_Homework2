package ru.surf.vladimir.surfhomework2

import android.opengl.Visibility
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val launches = listOf(
        LaunchDTO(
            name = "Starlink 2",
            site = "CCAES SLC 40",
            date = "16-12-2014",
            picture = R.drawable.falconsat01
        ),
        LaunchDTO(
            name = "DemoSat",
            site = "AAAES SLC 40",
            date = "06-07-2018",
            picture = R.drawable.falcon9
        ),
        LaunchDTO(
            name = "Falcon 9 Test",
            site = "CCAES SEC 40",
            date = "18-03-2019",
            picture = R.drawable.demosat02
        ),
        LaunchDTO(
            name = "CRS - 2",
            site = "CAAES SLC 40",
            date = "18-12-2019",
            picture = R.drawable.crs
        )
    )
    private val rockets = listOf(
        RocketDTO(
            name = "Falcon 1",
            status = false,
            picture = R.drawable.falconsat01
        ),
        RocketDTO(
            name = "Falcon 9",
            status = true,
            picture = R.drawable.falcon09
        ),
        RocketDTO(
            name = "Big Falcon Rocket",
            status = false,
            picture = R.drawable.demosat02
        )
    )
    private val launchRecyclerAdapter = LaunchRecyclerAdapter(launches)
    private val rocketRecyclerAdapter = RocketRecyclerAdapter(rockets)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.upcoming_button).setOnClickListener {
            findViewById<Button>(R.id.upcoming_button).setTextColor(
                ContextCompat.getColor(this, R.color.red)
            )
            findViewById<Button>(R.id.launches_button).setTextColor(
                ContextCompat.getColor(this, R.color.gray)
            )
            findViewById<Button>(R.id.rockets_button).setTextColor(
                ContextCompat.getColor(this, R.color.gray)
            )
            setVisibleInfo(true)
        }
        findViewById<Button>(R.id.launches_button).setOnClickListener {
            findViewById<Button>(R.id.upcoming_button).setTextColor(
                ContextCompat.getColor(this, R.color.gray)
            )
            findViewById<Button>(R.id.launches_button).setTextColor(
                ContextCompat.getColor(this, R.color.red)
            )
            findViewById<Button>(R.id.rockets_button).setTextColor(
                ContextCompat.getColor(this, R.color.gray)
            )
            setVisibleInfo(false)
            recyclerView.adapter = launchRecyclerAdapter
        }
        findViewById<Button>(R.id.rockets_button).setOnClickListener {
            findViewById<Button>(R.id.upcoming_button).setTextColor(
                ContextCompat.getColor(this, R.color.gray)
            )
            findViewById<Button>(R.id.launches_button).setTextColor(
                ContextCompat.getColor(this, R.color.gray)
            )
            findViewById<Button>(R.id.rockets_button).setTextColor(
                ContextCompat.getColor(this, R.color.red)
            )
            setVisibleInfo(false)
            recyclerView.adapter = rocketRecyclerAdapter
        }
    }
private fun setVisibleInfo(visibility: Boolean){
    findViewById<CardView>(R.id.upcoming_info).isVisible = visibility
    findViewById<TextView>(R.id.launch_date).isVisible = visibility
    findViewById<TextView>(R.id.launch_date_data).isVisible = visibility
    findViewById<TextView>(R.id.launch_site).isVisible = visibility
    findViewById<TextView>(R.id.launch_site_data).isVisible = visibility
    findViewById<TextView>(R.id.launch_date_data).isVisible = visibility
    findViewById<TextView>(R.id.count_down).isVisible = visibility
    findViewById<TextView>(R.id.count_down_data).isVisible = visibility
    findViewById<RecyclerView>(R.id.recycler).isVisible = !visibility
}
}

