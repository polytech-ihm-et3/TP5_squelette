Programmation Java @ Et3 \
Polytech Paris-Saclay | 2024-25

---

# TP5

## Consignes

-   Vous ne pouvez pas :
    -   Utiliser d'IA générative (comme ChatGPT, Claude, ...).
    -   Communiquer entre vous (à l'oral, par mail, ...).
-   Vous pouvez utiliser internet pour faire des recherches.

## Sujet

Le but de ce TP est de réaliser un éditeur graphique minimal.

<br><div align="center"><img src="images/interface.jpg" width="500"></img></div><br>

1. Clonez ce projet et configurez votre IDE de la même manière que le TP1, en suivant les instructions sur https://github.com/polytech-ihm-et3/HowToUseJavaFxWithIDE. Le dossier _src_ contient le code minimal pour afficher une fenêtre vierge à partir d'un fichier fxml.

2. Créez une interface, la plus proche possible de la figure ci-dessus. **Vous DEVEZ réaliser cette interface avec _SceneBuilder_ en modifiant le fichier _src/main/resources/application/interface.fxml_**.

> L'interface devra contenir :
>
> -   des [_Label_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/Label.html) pour décrire certaines parties de l'interface.
> -   des [_RadioButton_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/RadioButton.html) correspondant à différentes commandes de l'éditeur : (1) "_Select / Move_", (2) "_Ellipse_", (3) "_Rectangle_" et (4) "_Line_". Ces boutons pourront être regroupés grâce à un [_ToggleGroup_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/ToggleGroup.html) permettant de sélectionner une seule commande à la fois.
> -   des [_Separator_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/Separator.html) pour structurer l'interface.
> -   un [_ColorPicker_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/ColorPicker.html) permettant de sélectionner une couleur dans une palette.
> -   des [_Button_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/Button.html) correspondant à différentes commandes de l'éditeur : (a) "_Delete_" et (b) "_Clone_".
> -   un [_AnchorPane_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/layout/AnchorPane.html) servant de canevas, qui sera la zone de dessin.

> Pour lier votre interface à votre application, vous pourrez, si vous en avez besoin, utiliser la méthode suivante, qui permet de créer le contrôleur du fichier FXML avant son initialisation :
>
> ```Java
> public class Main extends Application
> {
>   @Override
>   public void start(Stage primaryStage)
>   {
>
>     try
>     {
>       //On crée le modèle
>       Model modele = new Model();
>
>       //On crée le contrôleur
>       Controller controlleur = new Controller(modele);
>
>       //On crée la vue, qui aura le contrôle du fichier FXML
>       View vue = new View();
>
>       //On prépare le fichier FXML
>       FXMLLoader loader = new FXMLLoader(getClass().getResource("interface.fxml"));
>
>       //On définit la vue comme contrôleur de ce fichier
>       loader.setController(vue);
>
>       //On charge le fichier FXML, il appellera la méthode *initialize()* de la vue
>       Parent root = loader.load();
>
>       //On crée la scène
>       Scene scene = new Scene(root);
>
>       //On définit cette scène comme étant la scène de notre première fenêtre
>       primaryStage.setScene(scene);
>
>       //On rend cette fenêtre visible
>       primaryStage.show();
>     }
>     catch(Exception e)
>     {
>       e.printStackTrace();
>     }
>   }
>
>   public static void main(String[] args)
>   {
>     launch(args);
>   }
> }
> ```

3. Faites en sorte que, en ayant préalablement sélectionné un des [_RadioButton_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/RadioButton.html), l'utilisateur puisse :

    - (a) Sélectionner une figure en cliquant dessus. Il faudra alors donner à l'utilisateur un retour validant la sélection de la figure (par exemple, grossir la figure, changer son contour, la faire clignoter, ...).

    - (b) Déplacer une figure grâce à un "_drag & drop_" ("_glisser & déposer_"). L'utilisateur devra éventuellement sélectionner la figure au préalable.

    - (c) Créer une [_Ellipse_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Ellipse.html). En cliquant n'importe où sur le canevas, une [_Ellipse_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Ellipse.html) avec une taille pré-configurée se crée. Cette [_Ellipse_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Ellipse.html) devra être de la couleur actuellement sélectionnée dans le [_ColorPicker_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/ColorPicker.html), pour cela, vous pourrez utiliser la méthode [`setFill(Paint value)`](<https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Shape.html#setFill(javafx.scene.paint.Paint)>).

    - (d) Créer un [_Rectangle_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Rectangle.html) similairement à la manière de créer une [_Ellipse_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Ellipse.html).

    - (e) Créer une [_Line_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Line.html) similairement à la manière de créer un rectangle. Plutôt que d'utiliser la méthode [`setFill(Paint value)`](<https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Shape.html#setFill(javafx.scene.paint.Paint)>), vous pourrez utiliser la méthode [`setStroke(Paint value)`](<https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Shape.html#setStroke(javafx.scene.paint.Paint)>).

    - (f) _[Pour aller plus loin ...]_ Si vous avez le temps, modifiez votre code pour que l'utilisateur puisse choisir les dimensions d'une [_Ellipse_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Ellipse.html), d'un [_Rectangle_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Rectangle.html) ou d'une [_Line_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Line.html) grâce à un "_drag & drop_" ("_glisser & déposer_") sur le canevas.

4. Faites en sorte que les [_Button_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/Button.html) (a) "_Delete_" et (b) "_Clone_" soient grisés par défaut. Ces [_Button_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/Button.html) ne pourront être accessible que si une figure est déjà sélectionnée par l'utilisateur.

5. Si une figure (_cf_ [_Shape_](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/shape/Shape.html)) est préalablement sélectionnée par l'utilisateur. Faites en sorte que :

    - (a) en sélectionnant une nouvelle couleur dans le [_ColorPicker_](https://openjfx.io/javadoc/21/javafx.controls/javafx/scene/control/ColorPicker.html), la couleur de la figure change, en accord avec cette nouvelle couleur.

    - (b) en cliquant sur le bouton "_Delete_", la figure soit supprimée du canevas.

    - (c) en cliquant sur le bouton "_Clone_", une nouvelle figure, identique à celle sélectionnée soit créée et ajoutée au canevas, avec un léger décalage par rapport à la position de la première figure.

---

### BARÈME DU TP :

-   Application [1 pt]
    > L'application se lance sans erreur.
-   Interface [5 pts]
    > L'interface ressemble à celle présentée. Les éléments graphiques utilisés sont choisis intelligemment.
-   Fonctionnalités de base [8 pts]
    > Les fonctionnalités énoncées dans le sujet sont implémentées et fonctionnent correctement.
-   Fonctionnalités _[Pour aller plus loin ...]_ [2 pts]
    > Les fonctionnalités avancées sont implémentées et fonctionnent correctement.
-   Modèle - Vue - Contrôleur [2 pts]
    > Les classes créées sont clairement divisées en trois parties selon le pattern [Modèle - Vue - Contrôleur](https://baptiste-wicht.developpez.com/tutoriels/conception/mvc/).
-   Lisibilité [2 pts]
    > Le code est lisible, correctement indenté et commenté.

---

### RENDU DU TP :

Le TP devra être rendu sous la forme d'une archive zippée (.ZIP) contenant les sources (_i.e._ le code du projet) et les ressources (_e.g._ le fichier .FXML) de votre projet. Cette archive sera envoyée à l'adresse [_polytech.ihm.et3@gmail.com_](mailto:polytech.ihm.et3@gmail.com) avec le sujet "[TpNote#2] Prénom NOM".
