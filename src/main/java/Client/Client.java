package Client;

import generated.valera.thrift.Article;
import generated.valera.thrift.Author;
import generated.valera.thrift.JavaHandbookService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.List;

public class Client {

    private TTransport transport;
    private TProtocol protocol;
    private JavaHandbookService.Client client;

    Client() {
        transport = null;
        protocol = null;
        client = null;
    }

    public void connect(String host, int port) {
        try {
            transport = new TSocket(host, port);
            transport.open();

            protocol = new TBinaryProtocol(transport);
            client = new JavaHandbookService.Client(protocol);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public void addArticle(Article article){
        try {
            client.addArticle(article);
        }catch (TException e ){
            e.printStackTrace();
        }
    }

    public  void editArticle(Article article){
        try {
            client.updArticle(article);
        }catch (TException e ){
            e.printStackTrace();
        }
    }

    public void removeArticle(Article article){
        try {
            client.delArticle(article);
        }catch (TException e ){
            e.printStackTrace();
        }
    }

    public List<Article> getArticle(){
        try {
            return client.getArticleList();
        }catch (TException e ){
            e.printStackTrace();
        }
        return null;
    }

}