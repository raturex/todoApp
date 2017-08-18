package com.arolitec.todo.web;


import geb.*
import geb.junit4.*
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.openqa.selenium.Keys

@RunWith(JUnit4)
class TaskerTest extends GebReportingTest {
    @Test
    void theTaskerHomepage() {
        to TaskerHomepage

        $("form").name = 'Write functional tests'
        $("form").name << Keys.ENTER

        waitFor { at TaskerInsert }
    }
}
