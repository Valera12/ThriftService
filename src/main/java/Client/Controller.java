package Client;


import java.util.List;

import generated.valera.thrift.Article;
import generated.valera.thrift.Author;
import generated.valera.thrift.JavaHandbookService;


public class Controller {
    private Client client;

    Controller(){
        this.client = new Client();
    }

    public boolean connect(String host, int port){
        client.connect(host, port);
        return true;
    }

    public void add(Article article){
        client.addArticle(article);
    }

    public void remove(Article article){
        client.removeArticle(article);
    }

    public void edit(Article article){
        client.editArticle(article);
    }

    public List<Article> getArticle(){
        return client.getArticle();
    }

}
