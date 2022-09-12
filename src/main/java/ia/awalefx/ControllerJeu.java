package ia.awalefx;

import ia.awalefx.designPattern.Observateur;
import ia.awalefx.modele.Partie;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ControllerJeu implements Observateur {
    //Affichage des cercles/trous
    public Circle c1;
    public Circle c2;
    public Circle c3;
    public Circle c4;
    public Circle c5;
    public Circle c6;

    //Affichage des graines dans les trous.
    public Text nb0;
    public Text nb1;
    public Text nb2;
    public Text nb3;
    public Text nb4;
    public Text nb5;
    public Text nb6;
    public Text nb7;
    public Text nb8;
    public Text nb9;
    public Text nb10;
    public Text nb11;

    //Greniers des joueurs.
    public Text g1;
    public Text g2;

    //Textfield profondeur de l'IA.
    public TextField profIA;

    //Affichage
    public Text affiche;

    private final Partie partie;
    private int profondeur; //Profondeur de l'IA.

    public ControllerJeu(Partie partie) {
        this.partie = partie;
        this.partie.ajouterObservateur(this);
        this.profondeur = 5;
    }

    public void c1Clicked(MouseEvent mouseEvent) {
        this.partie.jouerUnCoup(6);
        this.c1.setFill(new Color(0, 0, 0, 0));
        partie.notifierObservateur();
    }

    public void c2Clicked(MouseEvent mouseEvent) {
        this.partie.jouerUnCoup(7);
        this.c2.setFill(new Color(0, 0, 0, 0));
        partie.notifierObservateur();
    }

    public void c3Clicked(MouseEvent mouseEvent) {
        this.partie.jouerUnCoup(8);
        this.c3.setFill(new Color(0, 0, 0, 0));
        partie.notifierObservateur();
    }

    public void c4Clicked(MouseEvent mouseEvent) {
        this.partie.jouerUnCoup(9);
        this.c4.setFill(new Color(0, 0, 0, 0));
        partie.notifierObservateur();
    }

    public void c5Clicked(MouseEvent mouseEvent) {
        this.partie.jouerUnCoup(10);
        this.c5.setFill(new Color(0, 0, 0, 0));
        partie.notifierObservateur();
    }

    public void c6Clicked(MouseEvent mouseEvent) {
        this.partie.jouerUnCoup(11);
        this.c6.setFill(new Color(0, 0, 0, 0));
        partie.notifierObservateur();
    }

    @Override
    public void reagir() {
        //On maj les grenier des joueurs.
        this.g1.setText(String.valueOf(partie.getJoueur().getGrenier()));
        this.g2.setText(String.valueOf(partie.getIa().getGrenier()));

        //On maj les cases du jeu.
        this.nb0.setText(String.valueOf(this.partie.getPlateau().getNbGraine(0)));
        this.nb1.setText(String.valueOf(this.partie.getPlateau().getNbGraine(1)));
        this.nb2.setText(String.valueOf(this.partie.getPlateau().getNbGraine(2)));
        this.nb3.setText(String.valueOf(this.partie.getPlateau().getNbGraine(3)));
        this.nb4.setText(String.valueOf(this.partie.getPlateau().getNbGraine(4)));
        this.nb5.setText(String.valueOf(this.partie.getPlateau().getNbGraine(5)));
        this.nb6.setText(String.valueOf(this.partie.getPlateau().getNbGraine(6)));
        this.nb7.setText(String.valueOf(this.partie.getPlateau().getNbGraine(7)));
        this.nb8.setText(String.valueOf(this.partie.getPlateau().getNbGraine(8)));
        this.nb9.setText(String.valueOf(this.partie.getPlateau().getNbGraine(9)));
        this.nb10.setText(String.valueOf(this.partie.getPlateau().getNbGraine(10)));
        this.nb11.setText(String.valueOf(this.partie.getPlateau().getNbGraine(11)));

        if (!this.partie.isFinDuJeu()) {
            if (this.partie.isJoueurActuelEstHumain()) {
                this.affiche.setText("C'est le tour du joueur !");

                ArrayList<Integer> coupsCorrects = partie.coupsCorrects();

                if (coupsCorrects.contains(6)) {
                    this.c1.setDisable(false);
                    this.c1.setFill(new Color(0, 1, 0.58, 0.68));
                    this.nb6.setDisable(false);
                } else {
                    this.c1.setDisable(true);
                    this.c1.setFill(new Color(0, 0, 0, 0));
                    this.nb6.setDisable(true);
                }

                if (coupsCorrects.contains(7)) {
                    this.c2.setDisable(false);
                    this.c2.setFill(new Color(0, 1, 0.58, 0.68));
                    this.nb7.setDisable(false);
                } else {
                    this.c2.setDisable(true);
                    this.c2.setFill(new Color(0, 0, 0, 0));
                    this.nb7.setDisable(true);
                }

                if (coupsCorrects.contains(8)) {
                    this.c3.setDisable(false);
                    this.c3.setFill(new Color(0, 1, 0.58, 0.68));
                    this.nb8.setDisable(false);
                } else {
                    this.c3.setDisable(true);
                    this.c3.setFill(new Color(0, 0, 0, 0));
                    this.nb8.setDisable(true);
                }

                if (coupsCorrects.contains(9)) {
                    this.c4.setDisable(false);
                    this.c4.setFill(new Color(0, 1, 0.58, 0.68));
                    this.nb9.setDisable(false);
                } else {
                    this.c4.setDisable(true);
                    this.c4.setFill(new Color(0, 0, 0, 0));
                    this.nb9.setDisable(true);
                }

                if (coupsCorrects.contains(10)) {
                    this.c5.setDisable(false);
                    this.c5.setFill(new Color(0, 1, 0.58, 0.68));
                    this.nb10.setDisable(false);
                } else {
                    this.c5.setDisable(true);
                    this.c5.setFill(new Color(0, 0, 0, 0));
                    this.nb10.setDisable(true);
                }

                if (coupsCorrects.contains(11)) {
                    this.c6.setDisable(false);
                    this.c6.setFill(new Color(0, 1, 0.58, 0.68));
                    this.nb11.setDisable(false);
                } else {
                    this.c6.setDisable(true);
                    this.c6.setFill(new Color(0, 0, 0, 0));
                    this.nb11.setDisable(true);
                }
            } else {
                //On utilise un Thread pour pouvoir mettre le jeu en pause, ce qui permet à l'IA de ne pas jouer instantanément.
                Thread thread = new Thread(() -> {
                    try {
                        this.affiche.setText("C'est le tour de l'IA !");
                        this.disablePlateau();

                        //Pause qui permet au joueur de voir l'IA jouer.
                        Thread.sleep(3000);

                        //On lance l'IA.
                        Partie partieSuivante = partie.getIa().minimax(partie, this.profondeur);
                        if (partieSuivante != null)
                            partie.copierPartie(partieSuivante);
                        else
                            System.out.println("L'IA ne sait pas quoi jouer !");

                        this.partie.notifierObservateur();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
            }
        } else {
            this.affiche.setText(this.partie.getGagnant());
            //On reset les couleurs du joueur.
            this.c1.setFill(new Color(0, 0, 0, 0));
            this.c2.setFill(new Color(0, 0, 0, 0));
            this.c3.setFill(new Color(0, 0, 0, 0));
            this.c4.setFill(new Color(0, 0, 0, 0));
            this.c5.setFill(new Color(0, 0, 0, 0));
            this.c6.setFill(new Color(0, 0, 0, 0));

            //On disable tout le plateau.
            disablePlateau();
        }
    }

    //Fonction qui applique la profondeur de l'IA.
    public void apply(ActionEvent actionEvent) {
        this.profondeur = Integer.parseInt(String.valueOf(this.profIA.getCharacters()));
        System.out.println("La profondeur est à " + this.profondeur);
    }

    public void disablePlateau() {
        this.c1.setDisable(true);
        this.c2.setDisable(true);
        this.c3.setDisable(true);
        this.c4.setDisable(true);
        this.c5.setDisable(true);
        this.c6.setDisable(true);

        this.nb6.setDisable(true);
        this.nb7.setDisable(true);
        this.nb8.setDisable(true);
        this.nb9.setDisable(true);
        this.nb10.setDisable(true);
        this.nb11.setDisable(true);
    }
}