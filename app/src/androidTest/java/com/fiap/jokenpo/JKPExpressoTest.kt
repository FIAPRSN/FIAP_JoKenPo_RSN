package com.fiap.jokenpo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test

class JKPExpressoTest {

    @Test
    fun shouldTie(){
        ActivityScenario.launch(JKPGame::class.java)
        onView(withId(R.id.playerPaper)).perform(ViewActions.click())
        onView(withId(R.id.player_score)).check(matches(withText(0.toString())))
    }

    @Test
    fun deviceWin(){
        ActivityScenario.launch(JKPGame::class.java)
        onView(withId(R.id.playerRock)).perform(ViewActions.click())
        onView(withId(R.id.device_score)).check(matches(withText(1.toString())))
    }

    @Test
    fun playerWin(){
        ActivityScenario.launch(JKPGame::class.java)
        onView(withId(R.id.playerRock)).perform(ViewActions.click())
        onView(withId(R.id.player_score)).check(matches(withText(1.toString())))
    }
}
