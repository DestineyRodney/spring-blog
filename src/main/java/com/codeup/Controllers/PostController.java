package com.codeup.Controllers;

import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String indexPosts(Model model) {
        Post newPost1 = new Post("Welcome", "Destiney!");
        Post newPost2 = new Post("Back", "noah!");

        ArrayList<Post> posts = new ArrayList<>();
        posts.add(newPost1);
        posts.add(newPost2);
        System.out.println(posts);
        model.addAttribute("posts", posts);

        return "post/index";
    }

    @GetMapping("/posts/show")
    public String individualPost(Model viewmodel) {
        Post newPost = new Post("Welcome", "Welcome to codeup Quasar!");
        viewmodel.addAttribute("post", newPost);
        return "post/show";

    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewAllPost(){
        return "Placeholder for create post form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
        public String createPost(){
        return "";
    }
}

