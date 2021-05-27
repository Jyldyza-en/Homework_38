package kg.tutorialapp.homework_38

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kg.tutorialapp.homework_38.databinding.FragmentABinding

class FragmentA: Fragment(R.layout.fragment_a) {

    private var binding: FragmentABinding? = null

    private lateinit var listener: FragmentAListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentABinding.bind(view)

        val textFromArguments = arguments?.getString("String")

        binding!!.textView.text = textFromArguments

        binding!!.button.setOnClickListener {
            val text = binding!!.editText.text.toString()

            listener.setTextToFragmentB(text)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is FragmentAListener) listener = context
    }
    companion object{
        const val TAG = "fragmentA"

        fun newInstance(): FragmentA{
            val fragmentA = FragmentA()
            val args = Bundle()
            args.putString("String", "Hello")
            fragmentA.arguments = args

            return fragmentA
        }
    }

    fun set2NewText(text: String){
        binding!!.textView.text = text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
