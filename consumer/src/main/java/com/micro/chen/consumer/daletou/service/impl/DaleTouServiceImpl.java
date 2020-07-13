package com.micro.chen.consumer.daletou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micro.chen.consumer.daletou.mapper.DaleTouMapper;
import com.micro.chen.consumer.daletou.service.DaleTouService;
import com.micro.chen.entity.DaLeTou;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DaleTouServiceImpl extends ServiceImpl<DaleTouMapper, DaLeTou> implements DaleTouService {


    @Override
    public void batchProcess(String result) {
        Document document = Jsoup.parse(result);
        Elements elements = document.select("tbody");
        List<DaLeTou> daLeTouList = new ArrayList<>();
        for (Element element : elements) {
            Elements trElement = element.select("tr");
            for (int i = 0; i < trElement.size(); i++) {
                Elements tdElement = trElement.get(i).select("td");
                DaLeTou daLeTou = new DaLeTou();
                daLeTou.setFirstBall(tdElement.get(1).text());
                daLeTou.setSecondBall(tdElement.get(2).text());
                daLeTou.setThirdBall(tdElement.get(3).text());
                daLeTou.setFourthBall(tdElement.get(4).text());
                daLeTou.setFifthBall(tdElement.get(5).text());
                daLeTou.setBlueFirstBall(tdElement.get(6).text());
                daLeTou.setBlueSecondBall(tdElement.get(7).text());
                daLeTouList.add(daLeTou);
            }
        }
        this.saveBatch(daLeTouList);
    }
}
