package ia.awalefx.modele;

import java.util.ArrayList;

/**
 * Classe IA.
 */
public class IA extends Joueur {
    /**
     * Constructeur de la classe IA.
     *
     * @param id id de l'IA
     */
    public IA(int id) {
        super(id);
    }

    /**
     * Constructeur de la classe IA.
     *
     * @param iaACopier ia à copier
     */
    public IA(IA iaACopier) {
        super(iaACopier);
    }

    //Fonction qui retourne le meilleur coup à jouer pour l'IA.
    public Partie minimax(Partie e, int c) {
        ArrayList<Partie> S = new ArrayList<>();
        float score, scoreMax;

        ArrayList<Integer> coups = e.coupsCorrects();
        //On instancie tous les successeurs possibles, pour ensuite les évaluer.
        for (Integer i : coups) {
            Partie partieACopier = new Partie(e);
            partieACopier.jouerUnCoup(i);
            S.add(partieACopier);
        }

        scoreMax = Integer.MIN_VALUE;
        Partie eSortie = null;

        //J'applique la fonction evaluationAlphaBeta sur tous les successeurs stockés precedement, on prend celle qui possède le score max.
        for (Partie s : S) {
            score = evaluationAlphaBeta(c, s, Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.println("Le score d'un des coups possibles de l'IA est " + score);
            //Il commence toujours à droite pck comme c'est un >=, à chaque fois que l'on croise un score équivalent, on remplace la variable et comme on parcourt de 0 à 5, tjr ceux à la fin du parcourt, si ils ont la même valeurs, sont pris en priorité. (pour commencer à gauche, suffit de mettre >)
            if (score >= scoreMax) {
                eSortie = s;
                scoreMax = score;
            }
        }
        System.out.println("----------------------------------------");
        return eSortie;
    }

    //S : liste de successeurs, e : l'état actuel (partie).
    public float evaluationAlphaBeta(int c, Partie e, float alpha, float beta) {
        ArrayList<Partie> S = new ArrayList<>();
        float scoreMax, scoreMin;

        if (e.isFinDuJeu()) {
            return (e.isJoueurAGagne() ? Integer.MIN_VALUE : (e.isIaAGagne()) ? Integer.MAX_VALUE : 0);
        }
        if (c == 0) {
            return e.eval0();
        }
        ArrayList<Integer> coups = e.coupsCorrects();
        for (Integer i : coups) {
            Partie partieACopier = new Partie(e);
            partieACopier.jouerUnCoup(i);
            S.add(partieACopier);
        }
        if (!e.isJoueurActuelEstHumain()) {
            scoreMax = Integer.MIN_VALUE;
            for (Partie s : S) {
                scoreMax = Math.max(scoreMax, evaluationAlphaBeta(c - 1, s, alpha, beta));
                if (scoreMax >= beta) {
                    return scoreMax;
                }
                alpha = Math.max(alpha, scoreMax);
            }
            return scoreMax;
        } else {
            scoreMin = Integer.MAX_VALUE;
            for (Partie s : S) {
                scoreMin = Math.min(scoreMin, evaluationAlphaBeta(c - 1, s, alpha, beta));
                if (scoreMin <= alpha) {
                    return scoreMin;
                }
                beta = Math.max(beta, scoreMin);
            }
            return scoreMin;
        }
    }
}
