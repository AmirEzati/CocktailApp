package info.yazdan.cocktail

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import info.yazdan.cocktail.ui.host.HostActivity
import org.junit.Rule
import org.junit.Test

class HostActivityTest {

    @Rule
    @JvmField
    public var mActivityTestRule = ActivityTestRule<HostActivity>(HostActivity::class.java)

    @Test
    fun search_editText_test() {
        Espresso.onView(withId(R.id.search_edit_text)).perform(typeText("Gin"))
        Espresso.closeSoftKeyboard()
    }

}