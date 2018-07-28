package com.gp.controller;

import com.gp.dao.entity.RateConvert;
import com.gp.dto.ResultVo;
import com.gp.service.ExchangeService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: gaopeng
 * @Date: 2018-07-26
 */
@RestController
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    /**
     * 汇率转换
     *
     * @param from
     * @param to
     * @param amount
     * @return
     */
    @GetMapping("/convert/{from}/{to}")
    public ResultVo<RateConvert> exchangeRate(@PathVariable String from,
                                              @PathVariable String to,
                                              @RequestParam(value = "amount") String amount) throws IOException, URISyntaxException, JSONException {
           //TODO 要对from和to进行验证
           RateConvert rateConvert=exchangeService.exchangeRate(amount, from, to);
           if(rateConvert==null){
                return new ResultVo<RateConvert>().setResult("FAIL");
           }
           else{
               return new ResultVo<>(rateConvert);
           }
    }
}
