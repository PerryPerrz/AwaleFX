package ia.awalefx.designPattern;

import java.util.ArrayList;

/**
 * Classe SujetObserve.
 */
public class SujetObserve {
    private final transient ArrayList<Observateur> observateurs;

    public SujetObserve() {
        observateurs = new ArrayList<>(10);
    }

    /**
     * Fonction qui ajoute un observateur.
     *
     * @param obs l'observateur à ajouter
     */
    public void ajouterObservateur(Observateur obs) {
        observateurs.add(obs);
    }

    /**
     * Procédure qui notifie l'observateur.
     */
    public void notifierObservateur() {
        for (Observateur obs : observateurs)
            obs.reagir();
    }
}
