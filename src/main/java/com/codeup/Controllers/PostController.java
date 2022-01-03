package com.codeup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String viewAllPosts(){
        return "Here are the post!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewOnePost(@PathVariable int id){
        return "This is one Post " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "Creating a post form!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insertPost(){
        return "create a new post!";
    }
}
