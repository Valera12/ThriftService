package Service;

import generated.valera.thrift.Article;
import generated.valera.thrift.Author;
import generated.valera.thrift.JavaHandbookService;
import org.apache.thrift.TException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaHandbookServiceImpl implements JavaHandbookService.Iface {
    private List<Article> articles = new ArrayList<>();


    @Override
    public boolean addArticle(Article article) throws TException {
        if (!articles.contains(article)) {
            articles.add(article);
            return true;
        }

        return false;
    }

    @Override
    public boolean updArticle(Article someArticle) throws TException {
        for (Article article : articles) {
            if (someArticle.getId() == article.getId()) {
                article.setTitle(someArticle.getTitle());
                article.setAuthor(someArticle.getAuthor());
                article.setYear(someArticle.getYear());
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean delArticle(Article article) throws TException {
        if (articles.remove(article)) {
            return true;
        }
        return false;
    }


    public  Article getArticle(String articleTitle) throws TException {
        for (Article article : getArticleList()){
            if(article.getTitle().equals(articleTitle)){
                return article;
            }
        }
        return null;
    }

    @Override
    public List<Article> getArticleList() throws TException {
        return articles;
    }
}
