package Server;

import Service.JavaHandbookServiceImpl;
import generated.valera.thrift.Article;
import generated.valera.thrift.Author;
import generated.valera.thrift.JavaHandbookService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;



public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private void start() {

        try {

            TServerTransport serverTransport = new TServerSocket(9090);

            System.out.println("Starting the server...");
            TSimpleServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(
                    new JavaHandbookService.Processor<>(new JavaHandbookServiceImpl())));
            System.out.println("Server created, serving...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
