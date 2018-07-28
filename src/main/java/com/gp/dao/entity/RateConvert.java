package com.gp.dao.entity;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: gaopeng
 * @Date: 2018-07-26
 */
@Data
public class RateConvert {
      private String amount;
      private String rate;
      private String from;
      private String to;
}
