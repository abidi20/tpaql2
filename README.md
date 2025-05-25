# tpaql2

# TP2 – Tests Unitaires avec Mockups (JUnit 5 & Mockito)

## Objectifs
- Comprendre les **tests unitaires** et l’isolation des composants.
- Utiliser **Mockito** pour créer des objets simulés (mock).
- Distinguer les **tests d’état** et **tests d’interaction**.
- Tester des cas simples, des services externes mockés, et des scénarios conditionnels.

---

## Prérequis Techniques
- Java 8+
- IntelliJ IDEA
- JUnit 5
- Mockito

---

## Exercices

### Exercice 1 – Calculatrice

**Classe testée : `Calculatrice`**

- **Test d’interaction** : vérifie que `additionner(2, 3)` est bien appelé.
- **Test d’état** impossible ici car la classe est mockée.
-  Pour tester l’état (`result`), on doit utiliser une **instance réelle** (pas un mock).

---

###  Exercice 2 – Service utilisateur avec API

**Classe testée : `UserService` + `UtilisateurApi`**

- Création d’un utilisateur simulée via une interface `UtilisateurApi`.
- Utilisation de `doNothing().when(...).creerUtilisateur(...)` pour simuler l’appel.
- Vérification que l’appel à l’API a bien été effectué.
 Test de type **interaction**

---

### Exercice 3 – Scénarios avancés API

**Scénarios testés :**

1. **Exception levée**
   - Vérifie qu’une `ServiceException` est bien levée.
2. **Erreur de validation**
   - Utilise `verify(..., never())` pour vérifier l'absence d'appel.
3. **Retour d’ID utilisateur**
   - Hypothétique : impossible sans modification de l'interface `creerUtilisateur()` (elle est `void`).
4. **Capture d’argument**
   - Utilisation de `ArgumentCaptor` pour vérifier les arguments passés à l'API.

---

###  Exercice 4 – Jeu du 7

#### Objets à mocker

- `Banque`, `Joueur`, `De` sont tous mockés.
- Raison : pour isoler la logique du **Jeu**, sans dépendre des implémentations réelles.

#### Scénarios (Classes d’équivalence) à tester

| Cas | Description |
|-----|-------------|
| 1   | Jeu fermé → lève une exception `JeuFermeException` |
| 2   | Joueur insolvable → `DebitImpossibleException` levée, aucun appel aux dés |
| 3   | Somme dés ≠ 7 → joueur perd mise, banque garde mise |
| 4   | Somme dés = 7 et banque solvable → joueur gagne 2× la mise |
| 5   | Somme dés = 7 et banque **insolvable** → joueur gagne, puis le jeu se ferme |

#### Type de tests

- **Jeu fermé** → test **d’état** (vérifie que `estOuvert() == false`)
- **Joueur insolvable** → test **d’interaction** (vérifie que `lancer()` des dés n’est **pas** appelé)

#### Test intégration réel

- Une fois les tests unitaires passés, réécrire un test **d’intégration** avec une vraie `BanqueImpl`.

---

##  Exemple de dépendances Maven

```xml
<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.7.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
