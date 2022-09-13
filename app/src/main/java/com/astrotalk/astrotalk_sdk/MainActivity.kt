package com.astrotalk.astrotalk_sdk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.astrotalk.sdk.api.activities.AstroSplashActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user1.setOnClickListener {
            val intent = Intent(context, AstroSplashActivity::class.java)
            intent.putExtra("type", "sdk_launch")
            intent.putExtra("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJiZDRlMjZjNy0xZWJmLTQ2MjYtOTc5YS0zMGM4OWM5NmYyNDEiLCJpYXQiOjE2NjAxMTE1MzgsImV4cCI6MTY2MDE5NzkzOCwiaXNzIjoid2luem8gZ2FtZXMifQ.ZEP8GqEmLGp6ghaGS1Gs3zkluwHNcrwRKEHZCq8pxBI")
            intent.putExtra("client_id", "winzo_sdk")
            intent.putExtra("client_secret", "YrBFXe9UxBudXLb2")
            intent.putExtra("production", true)
            startActivity(intent)
        }

        user2.setOnClickListener {
            val intent = Intent(context, AstroSplashActivity::class.java)
            intent.putExtra("type", "sdk_launch")
            intent.putExtra("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NGZmZThlYi1lZjFlLTQwNWUtODA2ZS1hZWEzMjRmYjk1NWYiLCJpYXQiOjE2NjAxMTE3NjMsImV4cCI6MTY2MDE5ODE2MywiaXNzIjoid2luem8gZ2FtZXMifQ.VI0fT1wOMpi06qT0rTuV-bHI_xypUMe6MucKBYVCxFo")
            intent.putExtra("client_id", "winzo_sdk")
            intent.putExtra("client_secret", "YrBFXe9UxBudXLb2")
            intent.putExtra("production", true)
            startActivity(intent)
        }

        user3.setOnClickListener {
            val intent = Intent(context, AstroSplashActivity::class.java)
            intent.putExtra("type", "sdk_launch")
            intent.putExtra("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJkMmUzOGY3Zi1mYTA0LTQzODAtYWMzMS1iOTI2NjFkOTUyNGUiLCJpYXQiOjE2NTk5MzgyMTcsImV4cCI6MTY2MDAyNDYxNywiaXNzIjoid2luem8gZ2FtZXMifQ.BC10k3aK3HleVT1c6Jw5gurA3gqnD0Uonc6ncbCubFM")
            intent.putExtra("client_id", "winzo_sdk")
            intent.putExtra("client_secret", "YrBFXe9UxBudXLb2")
            intent.putExtra("production", true)
            startActivity(intent)
        }

//        user3.setOnClickListener {
//            val intent = Intent(context, AstroSplashActivity::class.java)
//            intent.putExtra("type", "sdk_launch")
//            intent.putExtra("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJXaW56b0dhbWVQYXJ0ZXJzQXV0aENsYWltIjoie1wiYWNjZXNzVG9rZW5cIjpudWxsLFwidXNlcklkXCI6XCJFMUZFRTA5NS1EMjkxLTQ5MkItOUQ4NS0xNzQwRkZBMzJCNTZcIixcInJlZGlyZWN0VVJMXCI6bnVsbCxcInNlc3Npb25JZFwiOm51bGwsXCJnYW1lUGFydG5lcklkXCI6XCJcIn0iLCJuYmYiOjE2NTI4NTYzMTMsImV4cCI6MTczOTI1NjMxMywiaWF0IjoxNjUyODU2MzEzLCJpc3MiOiJ3aW56by5jb20iLCJhdWQiOiJ3aW56byBnYW1lIHBhcnRuZXJzIn0.nONrdJ0sODV1dhZiQNN2rvMU7pxZfDU_j0ymdEpd750")
//            intent.putExtra("client_id", "winzo")
//            intent.putExtra("client_secret", "F6bCtBdjeQzP3ZZF")
//            intent.putExtra("production", false)
//            startActivity(intent)
//        }
//
//        user4.setOnClickListener {
//            val intent = Intent(context, AstroSplashActivity::class.java)
//            intent.putExtra("type", "sdk_launch")
//            intent.putExtra("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJXaW56b0dhbWVQYXJ0ZXJzQXV0aENsYWltIjoie1wiYWNjZXNzVG9rZW5cIjpudWxsLFwidXNlcklkXCI6XCIzMzQ0NzdGRC0yQTc5LTQzRDktQkI5Qy1DNzlDNDkzQjNERjFcIixcInJlZGlyZWN0VVJMXCI6bnVsbCxcInNlc3Npb25JZFwiOm51bGwsXCJnYW1lUGFydG5lcklkXCI6XCJcIn0iLCJuYmYiOjE2NTI4NTYzOTQsImV4cCI6MTczOTI1NjM5NCwiaWF0IjoxNjUyODU2Mzk0LCJpc3MiOiJ3aW56by5jb20iLCJhdWQiOiJ3aW56byBnYW1lIHBhcnRuZXJzIn0.pfk3fxABVu_zkoll1OmO_N6X2Y2xJsi4zMuuDLYKpyQ")
//            intent.putExtra("client_id", "winzo")
//            intent.putExtra("client_secret", "F6bCtBdjeQzP3ZZF")
//            intent.putExtra("production", false)
//            startActivity(intent)
//        }
//
//        user5.setOnClickListener {
//            val intent = Intent(context, AstroSplashActivity::class.java)
//            intent.putExtra("type", "sdk_launch")
//            intent.putExtra("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJXaW56b0dhbWVQYXJ0ZXJzQXV0aENsYWltIjoie1wiYWNjZXNzVG9rZW5cIjpudWxsLFwidXNlcklkXCI6XCI3NTVGMDYzMC1EQkQwLTQ2RTQtQjAxMy02OTM1Qjc5QTI5QzBcIixcInJlZGlyZWN0VVJMXCI6bnVsbCxcInNlc3Npb25JZFwiOm51bGwsXCJnYW1lUGFydG5lcklkXCI6XCJcIn0iLCJuYmYiOjE2NTI4NTY0NTUsImV4cCI6MTczOTI1NjQ1NSwiaWF0IjoxNjUyODU2NDU1LCJpc3MiOiJ3aW56by5jb20iLCJhdWQiOiJ3aW56byBnYW1lIHBhcnRuZXJzIn0.NZlPyNinisOwnx91lfzSPMT9qXxfwxuPfZEOqhqsGOc")
//            intent.putExtra("client_id", "winzo")
//            intent.putExtra("client_secret", "F6bCtBdjeQzP3ZZF")
//            intent.putExtra("production", false)
//            startActivity(intent)
//        }
//
//        user6.setOnClickListener {
//            val intent = Intent(context, AstroSplashActivity::class.java)
//            intent.putExtra("type", "sdk_launch")
//            intent.putExtra("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJXaW56b0dhbWVQYXJ0ZXJzQXV0aENsYWltIjoie1wiYWNjZXNzVG9rZW5cIjpudWxsLFwidXNlcklkXCI6XCJGNjA0OUU2RC04RUU2LTRDQTktODFBNy1CODI1MzY2QTJGODJcIixcInJlZGlyZWN0VVJMXCI6bnVsbCxcInNlc3Npb25JZFwiOm51bGwsXCJnYW1lUGFydG5lcklkXCI6XCJcIn0iLCJuYmYiOjE2NTU5Nzk2MjUsImV4cCI6MTc0MjM3OTYyNSwiaWF0IjoxNjU1OTc5NjI1LCJpc3MiOiJ3aW56by5jb20iLCJhdWQiOiJ3aW56byBnYW1lIHBhcnRuZXJzIn0.jIMW6IYRzak3YjS4I69sTUpGOg5sH7s-rpqKioPlBfc")
//            intent.putExtra("client_id", "winzo")
//            intent.putExtra("client_secret", "F6bCtBdjeQzP3ZZF")
//            intent.putExtra("production", false)
//            startActivity(intent)
//        }
//
//        btnClickLive.setOnClickListener {
//            val intent = Intent(context, AstroSplashActivity::class.java)
//            intent.putExtra("type", "sdk_launch")
//            intent.putExtra("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI3RUU3QkI0Mi02MEFGLTRDM0ItQTY4OS1FMzVBRkIwRjMxRDIiLCJpYXQiOjE2NTk2MDI1ODcsImV4cCI6MTY1OTY4ODk4NywiaXNzIjoid2luem8gZ2FtZXMifQ._h2e3CsPimaKXh5pbvyZRIIOXXlE75jYEH-LUaBpbHQ")
//            intent.putExtra("client_id", "winzo_sdk")
//            intent.putExtra("client_secret", "YrBFXe9UxBudXLb2")
//            intent.putExtra("production", true)
//            startActivity(intent)
//        }
    }
}