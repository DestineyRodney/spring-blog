package com.codeup.Controllers;

import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao;
//    dependency injection
    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String indexPosts(Model model) {
//        Post newPost1 = new Post("Welcome", "Destiney!");
//        Post newPost2 = new Post("Back", "noah!");
//
//        ArrayList<Post> posts = new ArrayList<>();
//        posts.add(newPost1);
//        posts.add(newPost2);
//        System.out.println(posts);
//        model.addAttribute("posts", posts);

        model.addAttribute("allPosts", postDao.findAll());
        return "post/index";
    }

//    @GetMapping("/posts/show")
//    public String individualPost(Model viewmodel) {
//        Post newPost = new Post("Welcome", "Welcome to codeup Quasar!");
//        viewmodel.addAttribute("post", newPost);
//        return "post/show";
//
//    }
        @GetMapping("/posts/{id}")
        public String individualPost(@PathVariable int id){
        return "post/show";
        }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model){
        Post editPost = postDao.getById(id);
        System.out.println("editPost.getTitle() = " + editPost.getTitle());
        System.out.println("editPost.getBody() = " + editPost.getBody());

        model.addAttribute("postToEdit", editPost);


        return "post/edit";
    }


    @PostMapping("/posts/edit")
    public String saveEditPost(@RequestParam(name="postTitle") String postTitle, @RequestParam(name="postBody") String postBody, @RequestParam(name="postId") long id){

        Post postToEdit = postDao.getById(id);

        postToEdit.setBody(postBody);
        postToEdit.setTitle(postTitle);
        ;

        postDao.save(postToEdit);

        return "redirect:/posts";
    }
    @PostMapping("/posts/delete/{id}")
    public String deletePost (@PathVariable long id){
       long deletePostsId = id;
        postDao.deleteById(deletePostsId);
        return "redirect:/posts";
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

