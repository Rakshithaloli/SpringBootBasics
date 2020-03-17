package com.softeck.udemy.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordControler {
    @GetMapping("/helloword-bean")
    public HelloWordBean HelloWordBean()
    {
        return new HelloWordBean("Hello World");
    }

    @GetMapping("/helloword-bean/{name}")
    public HelloWordBean HelloWordBeanName(@PathVariable String name)
    {
        return new HelloWordBean(String.format("Hello world, %s",name));
    }
}
