package edu.quinnipiac.ser210.fourinarow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputEditText

class SplashScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)
        val startButton = view.findViewById<Button>(R.id.start)

        startButton.setOnClickListener{
            val input: EditText = requireView().findViewById(R.id.userInput)
            val userInput = input.text.toString()
            val action = SplashScreenDirections.actionSplashScreenToGameScreen(userInput)
            view.findNavController().navigate(action)
        }


        return view
    }

}