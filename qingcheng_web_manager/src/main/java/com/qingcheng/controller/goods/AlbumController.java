package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Album;
import com.qingcheng.service.goods.AlbumService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/album")
@Api(tags = "品牌图片")
public class AlbumController {

    @Reference
    private AlbumService albumService;

    @GetMapping("/findAll")
    @ApiOperation(value = "获取品牌图片列表",notes ="查询所有品牌图片列表")
    public List<Album> findAll(){
        return albumService.findAll();
    }

    @GetMapping("/findPage")
    @ApiOperation(value = "带分页功能的获取品牌图片列表",notes = "带分页功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "int", example = "1"),
            @ApiImplicitParam(name = "size", value = "页容量", dataType = "int", example = "5")
    })
    public PageResult<Album> findPage( int page, int size){
        return albumService.findPage(page, size);
    }

    @PostMapping("/findList")
    @ApiOperation(value = "带条件功能查询的获取品牌图片列表",notes = "带条件功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchMap", value = "条件集合", dataType = "map")
    })
    public List<Album> findList(@RequestBody Map<String,Object> searchMap){
        return albumService.findList(searchMap);
    }

    @PostMapping("/findPage")
    @ApiOperation(value = "带条件和分页功能的获取品牌图片列表",notes = "带条件和分页功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchMap", value = "条件集合", dataType = "map"),
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "int", example = "1"),
            @ApiImplicitParam(name = "size", value = "页容量", dataType = "int", example = "5")
    })
    public PageResult<Album> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  albumService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    @ApiOperation(value = "获取单个品牌图片",notes = "查询单个品牌图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "品牌id", dataType = "int", example = "1")
    })
    public Album findById(Long id){
        return albumService.findById(id);
    }


    @PostMapping("/add")
    @ApiOperation(value = "添加品牌图片",notes = "添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "album", value = "品牌对象", dataType ="Album",example = "Album.class")
    })
    @ApiResponse(code = 0,message = "执行成功")
    public Result add(@RequestBody Album album){
        albumService.add(album);
        return new Result();
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改品牌图片",notes = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "album", value = "品牌对象", dataType ="Album",example = "Album.class")
    })
    @ApiResponse(code = 0,message = "执行成功")
    public Result update(@RequestBody Album album){
        albumService.update(album);
        return new Result();
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除品牌图片",notes = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType ="int",example = "1")
    })
    @ApiResponse(code = 0,message = "执行成功")
    public Result delete(Long id){
        albumService.delete(id);
        return new Result();
    }

}
