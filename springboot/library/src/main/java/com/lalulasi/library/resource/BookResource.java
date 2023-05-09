package com.lalulasi.library.resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lalulasi.library.model.Book;
import com.lalulasi.library.resource.utils.R;
import com.lalulasi.library.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.*;
import java.util.Date;
import java.util.UUID;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-02-28 10:34
 **/
@Slf4j
@RestController
@Path("/books")
public class BookResource {

    @Autowired
    private IBookService bookService;

    @GET
    public R getAll(){
        log.info("BookResource.getAll() start params");
        return new R(true, bookService.list());
    }

    @POST
    public R save(@RequestBody Book book){
        log.info("BookResource.save() start params; Book={}", book);
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        book.setId(id);
        return new R(bookService.save(book));
    }

    @PUT
    @Path("/{id}")
    public R updateById(@PathParam("id") String id, Book book){
        log.info("BookResource.updateById() start params; id=[{}], Book={}", id, book);
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.eq("id", id);
        return new R(bookService.update(book, qw));
    }

    @DELETE
    @Path("/{id}")
    public R deleteById(@PathParam("id") String id){
        log.info("BookResource.deleteById() start params; id=[{}]", id);
        return new R(bookService.removeById(id));
    }

    @GET
    @Path("/{id}")
    public R getBookById(@PathParam("id") String id){
        log.info("BookResource.getBookById() start params; id=[{}]", id);
        return new R(true, bookService.getById(id));
    }

    @GET
    @Path("/pages")
    public R getPage(@QueryParam("currentPage") Integer currentPage,
                     @QueryParam("pageSize") Integer pageSize,
                     @QueryParam("category") String category,
                     @QueryParam("name") String name,
                     @QueryParam("description") String description){
        log.info("BookResource.getPage() start params; currentPage=[{}],pageSize=[{}],type=[{}], name=[{}], description=[{}]",
                currentPage, pageSize, category, name, description);
        Book book = new Book(category, name, description);
        IPage<Book> page = bookService.getBookPage(currentPage, pageSize, book);
        if(currentPage > page.getPages()){
            page = bookService.getBookPage((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}
