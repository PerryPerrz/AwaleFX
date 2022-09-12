package ia.awalefx;

import ia.awalefx.modele.IA;
import ia.awalefx.modele.Joueur;
import ia.awalefx.modele.Partie;
import ia.awalefx.modele.Plateau;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Partie partie = new Partie(new Plateau(), new Joueur(1), new IA(0));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("awale.fxml"));

        ControllerJeu controllerJeu = new ControllerJeu(partie);

        fxmlLoader.setControllerFactory(ic -> {
            if (ic.equals(ControllerJeu.class)) return controllerJeu;
            return null;
        });

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Awalé by Hugo Iopeti");
        stage.setScene(scene);
        stage.show();
        partie.notifierObservateur(); //Mise à jour de l'interface.
    }

    public static void main(String[] args) {
        launch();
    }
}