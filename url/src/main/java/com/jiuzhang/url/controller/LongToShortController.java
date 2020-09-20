package com.jiuzhang.url.controller;

import com.jiuzhang.url.annotation.Limit;
import com.jiuzhang.url.common.LimitType;
import com.jiuzhang.url.entity.LongToShort;
import com.jiuzhang.url.service.LongToShortService;
import com.jiuzhang.url.vo.UrlVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther: WZ
 * @Date: 2020/9/7 14:59
 * @Description:
 */
@RestController
@RequestMapping("/url")
@Api
@CrossOrigin
public class LongToShortController {

    @Autowired
    private LongToShortService longToShortService;

    @GetMapping("/list/{id}")
    public LongToShort searchLong(@PathVariable String id){
        LongToShort longToShort = longToShortService.getById(id);
        return longToShort;
    }

    @PostMapping("/transfer")
    public UrlVo longTransfer(@RequestBody UrlVo urlVo, HttpServletRequest request){
        String Url = urlVo.getUrl();
        UrlVo longToShort = longToShortService.transFer(Url,request);
        return longToShort;
    }

}