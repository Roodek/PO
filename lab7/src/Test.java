import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class Test extends Application {
    private TreeView<String> a;
    @Override
    public void start(Stage primaryStage) {
        a = new TreeView<String>();
        BorderPane b = new BorderPane();
        Button c = new Button("Load Folder");
        c.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DirectoryChooser dc = new DirectoryChooser();
                //dc.setInitialDirectory(new File(System.getProperty("user.home")));
                File choice = dc.showDialog(primaryStage);

                if(choice == null || ! choice.isDirectory()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Could not open directory");
                    alert.setContentText("The file is invalid.");

                    alert.showAndWait();
                } else {
                    a.setRoot(getNodesForDirectory(choice));

                }

            }
        });



        b.setTop(c);
        b.setLeft(a);

        /*EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
            File file = new File(onPress(event));
        };

        a.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
        */

        primaryStage.setScene(new Scene(b, 600, 400));
        primaryStage.setTitle("Folder View");
        primaryStage.show();
    }
    /*
    private String onPress(MouseEvent event) {
        Node node = event.getPickResult().getIntersectedNode();
        String name = new String();
        // Accept clicks only on node cells, and not on empty spaces of the TreeView
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            name = (String) ((TreeItem)a.getSelectionModel().getSelectedItem()).getValue();

            System.out.println("Node click: " + name);
        }
        return name;
    }*/

    public static void main(String[] args) {
        launch(args);
    }

    public TreeItem<String> getNodesForDirectory(File directory) { //Returns a TreeItem representation of the specified directory
        TreeItem<String> root = new TreeItem<String>(directory.getName());
        for(File f : directory.listFiles()) {
            System.out.println("Loading " + f.getName());
            if(f.isDirectory()) { //Then we call the function recursively
                root.getChildren().add(getNodesForDirectory(f));
            } else {
                root.getChildren().add(new TreeItem<String>(f.getName()));
            }
        }
        return root;
    }
}