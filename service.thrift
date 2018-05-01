namespace java valera.thrift

struct Article {
    1: i32 id;
    2: string title;
    3: Author author;
    4: i32 year;
}

struct Author {
    2: string name;
    3: string surname;
    4: i32 birthYear;
}

service JavaHandbookService {
      bool addArticle(1: Article article);
      bool updArticle(1: Article article);
      bool delArticle(1: Article article);
      list <Article> getArticleList();
}