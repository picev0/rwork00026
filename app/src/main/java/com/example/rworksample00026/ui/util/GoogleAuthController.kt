package com.example.rworksample00026.ui.util

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.rworksample00026.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class GoogleAuthController(private val activity: AppCompatActivity) {

    // FirebaseAuthの生成
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    // GoogleSignInClient のオプション、今回は特に設定が必要ないのでデフォルト値的なものを利用する
    private val googleSignInOptions: GoogleSignInOptions by lazy {
        val signInOption = GoogleSignInOptions.DEFAULT_SIGN_IN
        val idToken = activity.getString(R.string.default_web_client_id)
        GoogleSignInOptions.Builder(signInOption).requestIdToken(idToken).requestEmail().build()
    }

    // GoogleSignInClientの生成
    private val googleSignInClient: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(activity, googleSignInOptions)
    }

    private var completed: (FirebaseUser) -> (Unit) = {}

    val currentUser: FirebaseUser? get() = firebaseAuth.currentUser


    fun startSignIn(completed: (FirebaseUser) -> (Unit)) {
        this.completed = completed
        //アカウントの選択
        val signInIntent = googleSignInClient.signInIntent
        activity.startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    fun startSignOut() {
        firebaseAuth.signOut()
        googleSignInClient.signOut()
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != RC_SIGN_IN) {
            return
        }

        val clazz = ApiException::class.java
        val account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(clazz)
        if (account == null) {
            return
        }

        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(activity) { task ->
            if (!task.isSuccessful) {
                return@addOnCompleteListener
            }

            if (firebaseAuth.currentUser == null) {
                return@addOnCompleteListener
            }

            completed(firebaseAuth.currentUser!!)
        }
    }

    companion object {
        private const val RC_SIGN_IN = 100
    }

}