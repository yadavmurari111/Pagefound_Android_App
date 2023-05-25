package com.example.pagefound

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials

class UserloginFragment : Fragment() {

    private lateinit var account: Auth0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.user_login_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        account = Auth0(
            "J4JEhNbqteVvsr05Y5L53kisO8OQoxIk",
            "dev-ejxjd42cogat3qdz.us.auth0.com"
        )

        val btnLogin = view.findViewById<Button>(R.id.btn_show_universal_login)
        btnLogin.setOnClickListener { loginWithBrowser() }

    }

    private fun navigateToHomeFragment() {
        val fm: FragmentManager = requireActivity().supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.fragment_container_view_tag, UserHomeFragment())
        ft.addToBackStack(null);
        ft.commit();
    }

    private fun loginWithBrowser() {
         //Setup the WebAuthProvider, using the custom scheme and scope.

        WebAuthProvider.login(account)
            .withScheme("demo")
            .withScope("openid profile email")
            // Launch the authentication passing the callback where the results will be received
            .start(requireContext(), object : Callback<Credentials, AuthenticationException> {
                // Called when there is an authentication failure
                override fun onFailure(exception: AuthenticationException) {
                    // Something went wrong!
                }

                // Called when authentication completed successfully
                override fun onSuccess(credentials: Credentials) {
                    // Get the access token from the credentials object.
                    // This can be used to call APIs
                    val accessToken = credentials.accessToken
                    if (accessToken.length>0) {
                        navigateToHomeFragment()
                    }
                }
            })
    }
}