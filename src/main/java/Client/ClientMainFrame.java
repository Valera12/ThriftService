package Client;



import generated.valera.thrift.Article;
import generated.valera.thrift.Author;
import generated.valera.thrift.JavaHandbookService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.util.List;
import java.util.Optional;

public class ClientMainFrame extends Application {
    private Controller handler = new Controller();

    private HBox buttonBox;
    private ObservableList<Article> booksList = FXCollections.observableArrayList();
    private TableView<Article> table = new TableView<>(booksList);

    private Optional<Article> showAddDialog() {
        Dialog<Article> dialog = new Dialog<>();
        dialog.setTitle("Добавить");
        dialog.setHeaderText("Добавить книгу");

        ButtonType addButtonType = new ButtonType("Добавить", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Отмена", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, cancelButtonType);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField bookID = new TextField();
        TextField bookName = new TextField();
        TextField year = new TextField();
        TextField authorFirstName = new TextField();
        TextField authorLastName = new TextField();
        TextField authorBirthday = new TextField();

        grid.add(new Label("Идентификатор:"), 0, 0);
        grid.add(bookID, 1, 0);
        grid.add(new Label("Название:"), 0, 1);
        grid.add(bookName, 1, 1);
        grid.add(new Label("Год издания:"), 0, 2);
        grid.add(year, 1, 2);
        grid.add(new Label("Имя автора:"), 0, 3);
        grid.add(authorFirstName, 1, 3);
        grid.add(new Label("Фамилия автора:"), 0, 4);
        grid.add(authorLastName, 1, 4);
        grid.add(new Label("Год рождения автора:"), 0, 5);
        grid.add(authorBirthday, 1, 5);

        Node addButton = dialog.getDialogPane().lookupButton(addButtonType);
        addButton.setDisable(true);

        BooleanBinding idInvalid = Bindings.createBooleanBinding(() ->
                        bookID.getText().trim().isEmpty() || !bookID.getText().chars().allMatch(Character::isDigit),
                bookID.textProperty()
        );
        BooleanBinding bookNameInvalid = Bindings.createBooleanBinding(() ->
                        bookName.getText().trim().isEmpty(),
                bookName.textProperty()
        );
        BooleanBinding yearInvalid = Bindings.createBooleanBinding(() ->
                        year.getText().trim().isEmpty() || !year.getText().chars().allMatch(Character::isDigit),
                year.textProperty()
        );
        BooleanBinding authorFirstNameInvalid = Bindings.createBooleanBinding(() ->
                        authorFirstName.getText().trim().isEmpty(),
                authorFirstName.textProperty()
        );
        BooleanBinding authorLastNameInvalid = Bindings.createBooleanBinding(() ->
                        authorLastName.getText().trim().isEmpty(),
                authorLastName.textProperty()
        );
        BooleanBinding authorBirthdayInvalid = Bindings.createBooleanBinding(() ->
                        authorBirthday.getText().trim().isEmpty() || !authorBirthday.getText().chars().allMatch(Character::isDigit),
                authorBirthday.textProperty()
        );

        addButton.disableProperty().bind(
                idInvalid
                        .or(bookNameInvalid)
                        .or(yearInvalid)
                        .or(authorFirstNameInvalid)
                        .or(authorLastNameInvalid)
                        .or(authorBirthdayInvalid));

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(bookID::requestFocus);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                return new Article(
                        Integer.valueOf(bookID.getText()),
                        bookName.getText(),
                        new Author(
                                authorFirstName.getText(),
                                authorLastName.getText(),
                                Integer.valueOf(authorBirthday.getText())),
                        Integer.valueOf(year.getText())
                );
            }
            return null;
        });

        return dialog.showAndWait();
    }

    private void setupButtons() {
        Button addButton = new Button("Добавить книгу");
        addButton.setOnAction(e -> {
            Optional<Article> bookInfo = showAddDialog();
            bookInfo.ifPresent(book -> handler.add(book));
            updateTable();
        });

        Button exitButton = new Button("Выход");
        exitButton.setOnAction(e -> {
            Platform.exit();
        });

        buttonBox = new HBox();
        buttonBox.setSpacing(5);
        buttonBox.setPadding(new Insets(5, 0, 0, 0));
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().addAll(addButton, exitButton);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Библиотечный справочник");
        Scene scene = new Scene(new VBox());
        scene.setFill(Color.LIGHTGRAY);

        setupButtons();
        setupTable();

        ((VBox) scene.getRoot()).setPadding(new Insets(5, 5, 5, 5));
        ((VBox) scene.getRoot()).getChildren().addAll(table, buttonBox);

        ((VBox) scene.getRoot()).setVgrow(table, Priority.ALWAYS);
        handler.connect("localhost", 9090);
        updateTable();

        //stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void setupTable() {
        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Article, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(50);
        idColumn.setMaxWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setSortType(TableColumn.SortType.ASCENDING);

        TableColumn<Article, String> nameColumn = new TableColumn<>("Название");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(t -> {
            Article book = (t.getTableView().getItems().get(t.getTablePosition().getRow()));
            book.setTitle(t.getNewValue());
            handler.edit(book);
        });

        TableColumn<Article, Integer> yearColumn = new TableColumn<>("Год издания");
        yearColumn.setMinWidth(80);
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        yearColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        yearColumn.setOnEditCommit(t -> {
            Article book = t.getRowValue();
            book.setYear(t.getNewValue());
            handler.edit(book);
        });


        TableColumn authorColumn = new TableColumn("Автор");
        authorColumn.setMinWidth(275);

        TableColumn<Article, String> authorFirstNameColumn = new TableColumn<>("Имя");
        authorFirstNameColumn.setMinWidth(100);
        authorFirstNameColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getAuthor().getName()));
        authorFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        authorFirstNameColumn.setOnEditCommit(t -> {
            Article book = t.getRowValue();
            book.getAuthor().setName(t.getNewValue());
            handler.edit(book);
        });

        TableColumn<Article, String> authorLastNameColumn = new TableColumn<>("Фамилия");
        authorLastNameColumn.setMinWidth(100);
        authorLastNameColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getAuthor().getSurname()));
        authorLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        authorLastNameColumn.setOnEditCommit(t -> {
            Article book = t.getRowValue();
            book.getAuthor().setSurname(t.getNewValue());
            handler.edit(book);
        });

        TableColumn<Article, Integer> authorBirthdayColumn = new TableColumn<>("Год рождения");
        authorBirthdayColumn.setMinWidth(90);
        authorBirthdayColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getAuthor().getBirthYear()).asObject());
        authorBirthdayColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        authorBirthdayColumn.setOnEditCommit(t -> {
            Article book = t.getRowValue();
            book.getAuthor().setBirthYear(t.getNewValue());
            handler.edit(book);
        });

        authorColumn.getColumns().addAll(authorFirstNameColumn, authorLastNameColumn, authorBirthdayColumn);
        table.getColumns().addAll(idColumn, nameColumn, yearColumn, authorColumn);

        BooksContextMenu ctxMenu = new BooksContextMenu(table);
        table.setContextMenu(ctxMenu);
    }

    private void updateTable() {
        booksList.clear();
        List<Article> books = handler.getArticle();
        booksList.addAll(books);
    }

    private class BooksContextMenu extends ContextMenu {
        BooksContextMenu(TableView<Article> table) {
            MenuItem removeItem = new MenuItem("Удалить");
            MenuItem refreshItem = new MenuItem("Обновить");

            removeItem.setOnAction(e -> {
                if (table.getSelectionModel().getSelectedItem() == null) {
                    return;
                }
                handler.remove(table.getSelectionModel().getSelectedItem());
                updateTable();

                e.consume();
            });

            refreshItem.setOnAction(e -> {
                updateTable();
                e.consume();
            });

            getItems().addAll(removeItem, refreshItem);

        }
    }
}