package com.gp.service;

import com.gp.dao.entity.RateConvert;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: gaopeng
 * @Date: 2018-07-26
 */
public interface ExchangeService {
    RateConvert exchangeRate(String amount, String from, String to) throws IOException, URISyntaxException, JSONException;
}
