package com.lalulasi.library.resource;

import com.lalulasi.library.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-03-04 20:50
 **/
@Slf4j
@RestController
@RequestMapping("/students")
public class StudentResource {

    @GetMapping("/get")
    public Response getAllStudents(){
        return null;
    }

    @PutMapping("/put/{id}")
    public Response updateStudent(@PathVariable Integer id, @RequestBody Book book){
        return null;
    }

    @PostMapping("/post")
    public Response postStudent(@RequestBody Book book){
        return null;
    }


    @DeleteMapping("/delete/{id}")
    public Response deleteStudent(@PathVariable Integer id){
        return null;
    }

    @GetMapping("/pages")
    public Response pageStudents(@RequestParam Integer currentPage, @RequestParam Integer pageSize){
        return null;
    }
}
