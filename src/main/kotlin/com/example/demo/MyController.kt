package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
@RequestMapping("/")
class MyController {


    @GetMapping("/exception")
    fun index(@RequestParam(required = false, defaultValue = "") num: String): ResponseEntity<*> {
        if (num.isNotEmpty()) {
            try {
                return when (num.toLong()) {
                    500L -> ResponseEntity(
                            "500 ",
                            HttpStatus.INTERNAL_SERVER_ERROR)
                    503L -> ResponseEntity(
                            "503 ",
                            HttpStatus.SERVICE_UNAVAILABLE)
                    507L -> ResponseEntity(
                            "500 ",
                            HttpStatus.INSUFFICIENT_STORAGE)
                    else -> ResponseEntity("Ok", HttpStatus.OK)
                }

            } catch (e: NumberFormatException) {
                return ResponseEntity(
                        "NumberFormatException ",
                        HttpStatus.BAD_REQUEST)

            }
        }
        return ResponseEntity("Ok", HttpStatus.OK)
    }

}