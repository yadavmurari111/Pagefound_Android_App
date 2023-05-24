package com.example.pagefound

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials

class MainActivity : AppCompatActivity() {

    private lateinit var account: Auth0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        account = Auth0(
            "J4JEhNbqteVvsr05Y5L53kisO8OQoxIk",
            "dev-ejxjd42cogat3qdz.us.auth0.com"
        )

        val btnLogin = findViewById<Button>(R.id.btn_show_universal_login)
        btnLogin.setOnClickListener { loginWithBrowser() }
    }

    private fun loginWithBrowser() {
        // Setup the WebAuthProvider, using the custom scheme and scope.

        WebAuthProvider.login(account)
            .withScheme("demo")
            .withScope("openid profile email")
            // Launch the authentication passing the callback where the results will be received
            .start(this, object : Callback<Credentials, AuthenticationException> {
                // Called when there is an authentication failure
                override fun onFailure(exception: AuthenticationException) {
                    // Something went wrong!
                }

                // Called when authentication completed successfully
                override fun onSuccess(credentials: Credentials) {
                    // Get the access token from the credentials object.
                    // This can be used to call APIs
                    val accessToken = credentials.accessToken
                }
            })
    }

}