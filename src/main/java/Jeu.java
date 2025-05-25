public class Jeu {
    private Banque banque;
    private boolean ouvert = true;

    public Jeu(Banque banque) {
        this.banque = banque;
    }

    public void fermer() {
        ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException, DebitImpossibleException {
        if (!ouvert) throw new JeuFermeException();

        int mise = joueur.mise();
        joueur.debiter(mise);
        banque.crediter(mise);

        int somme = de1.lancer() + de2.lancer();
        if (somme == 7) {
            joueur.crediter(mise * 2);
            banque.debiter(mise * 2);
            if (!banque.est_solvable()) fermer();
        }
    }
}
