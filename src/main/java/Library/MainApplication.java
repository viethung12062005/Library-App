package Library;

import Library.ui.LogInView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {

    // GỌI BACKEND THƯ VIỆN ????

    LogInView.LogInType logInType;

    @Override
    public void start(Stage stage) throws Exception {

        // CỬA SỔ ĐĂNG NHẬP
//        ShowLogInWindow();
        logInType = LogInView.LogInType.USER;

        stage.getIcons().add(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream("icon/icon-512.png"))));
        stage.setResizable(false); // không cho phóng to, thu nhỏ cửa sổ

        // CỬA SỔ CHÍNH
        if (logInType == LogInView.LogInType.USER) {
            ShowUserWindow(stage);
        } else if (logInType == LogInView.LogInType.ADMIN) {
            ShowAdminWindow(stage);
        }

    }

    private void ShowLogInWindow() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/LogInView.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();

    }

    private static void ShowUserWindow(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/UserMainView.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setTitle("Library App - User");
        stage.setScene(scene);

        // KHI ĐÓNG CỬA SỔ
        stage.setOnCloseRequest(windowEvent -> {
//            dict.getHistory().export();
//            dict.getFavorites().export();
//            if (dict instanceof TxtDictionary) {
//                ((TxtDictionary) dict).exportToFiles("src/main/resources/data/demo.txt");
//            }
//            dict.close();
            Platform.exit();
            System.exit(0);
        });

        stage.show();

        // THÔNG BÁO SAU KHI ĐĂNG NHẬP
//        if (dict instanceof DtbDictionary) {
//            WordOfTheDayWindow wordOfTheDayWindow = new WordOfTheDayWindow();
//            wordOfTheDayWindow.display();
//        }
    }

    private static void ShowAdminWindow(Stage stage) throws IOException {
    }


    public static void main(String[] args) {
        launch();
    }

}