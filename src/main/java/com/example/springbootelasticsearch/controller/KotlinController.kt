package com.example.springbootelasticsearch.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class KotlinController {

    @RequestMapping("/kotlin")
    @ResponseBody
    fun kotlin() {

        println("Hello Kotlin")
    }

}
