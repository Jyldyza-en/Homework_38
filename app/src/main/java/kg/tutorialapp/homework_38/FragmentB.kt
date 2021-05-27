package kg.tutorialapp.homework_38

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kg.tutorialapp.homework_38.databinding.FragmentBBinding

class FragmentB: Fragment(R.layout.fragment_b) {

    private var binding: FragmentBBinding? = null

    private lateinit var listener: FragmentBListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentBBinding.bind(view)

        binding!!.button.setOnClickListener {
            val text = binding!!.editText.text.toString()
            listener.setTextToFragmentA(text)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentBListener) listener = context
    }

    fun setNewText(text: String){
        binding!!.textView.text = text
    }

    companion object{
        const val TAG = "fragmentB"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}