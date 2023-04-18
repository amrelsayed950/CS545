//package edu.miu.waa.lab5.controller;
//
//import edu.miu.waa.lab5.domain.User;
//import edu.miu.waa.lab5.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "http://localhost:8080")
//@RestController
//@RequestMapping("/api/v1/user")
//public class UserAuthController {
//
//    @Autowired
//    UserService userService;
//
//    //localhost:8080/api/v1/user?id=dean@miu.edu
//    @GetMapping()
//    public User getByEmail(@RequestParam("id") String id){
//        return userService.findByEmail(id);
//    }
//}
