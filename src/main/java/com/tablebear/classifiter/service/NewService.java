package com.tablebear.classifiter.service;

import com.tablebear.classifiter.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tablebear.classifiter.mapper.Newsmapper;
import org.thunlp.text.classifiers.BasicTextClassifier;
import org.thunlp.text.classifiers.ClassifyResult;
import org.thunlp.text.classifiers.LinearBigramChineseTextClassifier;

import java.util.List;

@Service
public class NewService {
    @Autowired
    Newsmapper newsMapper;

    public List<News> getAllNews() {
        List<News> news = newsMapper.getNews();
        return news;
    }

    /**
     * 如果需要读取已经训练好的模型，再用其进行分类，可以按照本函数的代码调用分类器
     */
    public void runLoadModelAndUse() {
        // 新建分类器对象
        BasicTextClassifier classifier = new BasicTextClassifier();
        // 设置分类种类，并读取模型
        classifier.loadCategoryListFromFile("C:\\Users\\23904\\IdeaProjects\\NewsClassifiter\\src\\main\\resources\\news_model\\category");
        classifier.setTextClassifier(new LinearBigramChineseTextClassifier(classifier.getCategorySize()));
        classifier.getTextClassifier().loadModel("C:\\Users\\23904\\IdeaProjects\\NewsClassifiter\\src\\main\\resources\\news_model");
        List<News> list = getAllNews();
        for (News news : list) {
            // 之后就可以使用分类器进行分类
            String text = news.getContent();
            int topN = 1;  // 保留最有可能的3个结果
            ClassifyResult[] result = classifier.classifyText(text, topN);
            for (int i = 0; i < topN; ++i) {
                // 输出分类编号，分类名称，以及概率值。
                System.out.println(result[i].label + "\t" +
                        classifier.getCategoryName(result[i].label) + "\t" +
                        result[i].prob);
                news.setCate(result[i].label);
                newsMapper.updateCate(news);
            }
        }
    }

}
