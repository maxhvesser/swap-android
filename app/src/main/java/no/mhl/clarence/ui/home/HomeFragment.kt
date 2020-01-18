package no.mhl.clarence.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import no.mhl.clarence.R
import no.mhl.clarence.ui.views.currencydisplay.CurrencyDisplay
import no.mhl.clarence.ui.views.keypad.KeypadKey
import no.mhl.clarence.ui.views.keypad.KeypadView
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    // region Properties
    private val homeViewModel: HomeViewModel by viewModel()
    // endregion

    // region View Properties
    private lateinit var keypadView: KeypadView
    private lateinit var currencyDisplayPrimary: CurrencyDisplay
    // endregion

    // region Initialisation
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        setupView(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.requestApplyInsets(view)
    }
    // endregion

    // region View Setup
    private fun setupView(view: View) {
        keypadView = view.findViewById(R.id.home_keypad_view)
        currencyDisplayPrimary = view.findViewById(R.id.home_currency_display_primary)

        setupViewInsets(view.findViewById(R.id.home_keypad_parent))
        setupKeypadView(keypadView)
    }

    private fun setupViewInsets(keypadParent: ConstraintLayout) {
        ViewCompat.setOnApplyWindowInsetsListener(keypadParent) { v, insets ->
            v.updatePadding(bottom = insets.systemWindowInsetBottom)
            insets
        }
    }
    // endregion

    // region Keypad View Setup
    private fun setupKeypadView(keypadView: KeypadView) {
        keypadView.keypadClickEvent.observe(viewLifecycleOwner, Observer { key ->
            when (key) {
                KeypadKey.ZERO -> currencyDisplayPrimary.appendValue("0")
                KeypadKey.ONE -> currencyDisplayPrimary.appendValue("1")
                KeypadKey.TWO -> currencyDisplayPrimary.appendValue("2")
                KeypadKey.THREE -> currencyDisplayPrimary.appendValue("3")
                KeypadKey.FOUR -> currencyDisplayPrimary.appendValue("4")
                KeypadKey.FIVE -> currencyDisplayPrimary.appendValue("5")
                KeypadKey.SIX -> currencyDisplayPrimary.appendValue("6")
                KeypadKey.SEVEN -> currencyDisplayPrimary.appendValue("7")
                KeypadKey.EIGHT -> currencyDisplayPrimary.appendValue("8")
                KeypadKey.NINE -> currencyDisplayPrimary.appendValue("9")
                KeypadKey.DECIMAL -> currencyDisplayPrimary.appendValue(".")
                KeypadKey.BACKSPACE -> currencyDisplayPrimary.backspaceValue()
                KeypadKey.CLEAR -> currencyDisplayPrimary.clearValue()
                else -> { }
            }
        })
    }
    // endregion

    // region Currency Display Setup

    // endregion

}