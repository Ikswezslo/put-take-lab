/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web;

import ejb.NewsItem;
import ejb.NewsItemFacadeLocal;
import jakarta.annotation.Resource;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.TextMessage;
import java.util.List;

/**
 *
 * @author mateu
 */
@Named(value = "newsBean")
@RequestScoped
public class NewsBean {

    @Inject
    private NewsItemFacadeLocal facade;

    @Inject
    private JMSContext context;
    @Resource(lookup = "jms/NewsQueue")
    private jakarta.jms.Queue queue;

    private String headingText;
    private String bodyText;

    /**
     * Creates a new instance of NewsBean
     */
    public NewsBean() {
    }

    public String getHeadingText() {
        return headingText;
    }

    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String submitNews() {
        sendNewsItem(headingText, bodyText);
        return "news";
    }

    void sendNewsItem(String heading, String body) {
        TextMessage message = context.createTextMessage(String.format("%s|%s", heading, body));
        context.createProducer().send(queue, message);
    }

    public List<NewsItem> getNewsItems() {
        return facade.getAllNewsItems();
    }

}
