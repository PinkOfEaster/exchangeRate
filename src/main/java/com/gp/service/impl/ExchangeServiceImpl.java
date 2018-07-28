package com.gp.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.gp.dao.entity.RateConvert;
import com.gp.service.ExchangeService;
import com.gp.util.HttpClient;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: gaopeng
 * @Date: 2018-07-26
 */
@Service
public class ExchangeServiceImpl implements ExchangeService{
    private JsonParser parser=new JsonParser();
    @Override
    public RateConvert exchangeRate(String amount, String from, String to) throws IOException, URISyntaxException, JSONException {
        URIBuilder uriBuilder=new URIBuilder("http://tools.2345.com/frame/sundry/getHuilv");
        uriBuilder.addParameter("from",from);
        uriBuilder.addParameter("to",to);
        uriBuilder.addParameter("total",amount);
        String result=HttpClient.doGet(uriBuilder);
        if(result==null){
            return null;
        }
        JsonObject json=((JsonObject)parser.parse(result)).get("retData").getAsJsonObject();
        String currency=json.get("currency").isJsonNull()?null:(json.get("currency").getAsString());
        String convertedamount=json.get("convertedamount").isJsonNull()?null:json.get("convertedamount").getAsString();
        return new RateConvert().setAmount(convertedamount).setFrom(from).setTo(to).setRate(currency);
    }
}
