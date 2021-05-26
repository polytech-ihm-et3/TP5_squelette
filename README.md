Programmation Java @ Et3
<br>
Polytech Paris-Saclay | 2020-21

___

# TP5

Le but de ce TP est de réaliser un éditeur graphique minimal.

<br><div align="center"><img src="images/interface.jpg" width="500"></img></div><br>

1. Créez un projet javaFX.

> Dans Eclipse, allez dans *File* > *New* > *Project...* et selectionnez *JavaFX Project*, dans le répertoire "JavaFX".

> Dans IntelliJ, allez dans *File* > *New* > *Project...* et selectionnez *JavaFX Application*, dans l'onglet "JavaFX".

2. Créez une interface, la plus proche possible de la figure ci-dessus. **Vous DEVEZ réaliser cette interface avec *SceneBuilder***.

> L'interface devra contenir :
> 
>   - des [*Label*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html) pour décrire certaines parties de l'interface.
>   - des [*RadioButton*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/RadioButton.html) correspondant à différentes commandes de l'éditeur : (1) "*Select / Move*", (2) "*Ellipse*", (3) "*Rectangle*" et (4) "*Line*". Ces boutons pourront être regroupés grâce à un [*ToggleGroup*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ToggleGroup.html) permettant de sélectionner une seule commande à la fois.
>   - des [*Separator*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Separator.html) pour structurer l'interface.
>   - un [*ColorPicker*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html) permettant de sélectionner une couleur dans une palette.
>   - des [*Button*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html) correspondant à différentes commandes de l'éditeur : (a) "*Delete*" et (b) "*Clone*".
>   - un [*AnchorPane*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/AnchorPane.html) servant de canvas, qui sera la zone de dessin.

> Pour lier votre interface à votre application, vous pourrez, si vous en avez besoin, utiliser la méthode suivante, qui permet de créer le contrôleur du fichier FXML avant son initialisation : 
> ```Java
> public class Main extends Application
> {
>   @Override
>   public void start(Stage primaryStage)
>   {
>     //On crée le modèle
>     Model modele = new Model();
>     
>     //On crée le contrôleur
>     Controller controlleur = new Controller();
>     
>     //On crée la vue, qui aura le contrôle du fichier FXML
>     View vue = new View();
>     
>     try
>     {
>       //On prépare le fichier FXML
>       FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
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

3. Faites en sorte que, en ayant préalablement sélectionné un des [*RadioButton*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/RadioButton.html), l'utilisateur puisse :

  - (1) sélectionner une figure en cliquant dessus. Il faudra alors donner à l'utilisateur un retour validant la sélection de la figure (par exemple, grossir la fichure, changer son contour, la faire clignoter, ...).

  - (1) déplacer une figure grâce à un "*drag & drop*" ("*glisser & déposer*"). L'utilisateur pourra éventuellement avoir à sélectionner la figure clairemenet au préalable.

  - (2) créer une [*Ellipse*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Ellipse.html). En cliquant n'importe où sur le canvas, une [*Ellipse*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Ellipse.html) avec une taille pré-configurée se créée. Cette [*Ellipse*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Ellipse.html) devra être de la couleur actuellement sélectionnée dans le [*ColorPicker*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html), pour cela, vous pourrez utiliser la méthode [`setFill(Paint value)`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Shape.html#setFill-javafx.scene.paint.Paint-). *[Pour aller plus loin ...]* Si vous avez le temps, modifiez votre code pour que l'utilisateur puisse choisir les dimensions de l'[*Ellipse*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Ellipse.html) grâce à un "*drag & drop*" ("*glisser & déposer*") sur le canvas.

  - (3) créer un [*Rectangle*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html). En cliquant n'importe où sur le canvas, un [*Rectangle*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html) avec une taille pré-configurée se créé. Ce [*Rectangle*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html) devra être de la couleur actuellement sélectionnée dans le [*ColorPicker*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html), pour cela, vous pourrez utiliser la méthode [`setFill(Paint value)`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Shape.html#setFill-javafx.scene.paint.Paint-). *[Pour aller plus loin ...]* Si vous avez le temps, modifiez votre code pour que l'utilisateur puisse choisir les dimensions du [*Rectangle*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html) grâce à un "*drag & drop*" ("*glisser & déposer*") sur le canvas.

  - (4) créer une [*Line*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Line.html). En cliquant n'importe où sur le canvas, une [*Line*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Line.html) avec une taille pré-configurée se créée. Cette [*Line*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Line.html) devra être de la couleur actuellement sélectionnée dans le [*ColorPicker*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html), pour cela, vous pourrez utiliser la méthode [`setStroke(Paint value)`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Shape.html#setStroke-javafx.scene.paint.Paint-). *[Pour aller plus loin ...]* Si vous avez le temps, modifiez votre code pour que l'utilisateur puisse choisir les le point de départ et le point d'arrivée de la [*Line*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Line.html) grâce à un "*drag & drop*" ("*glisser & déposer*") sur le canvas.

4. Faites en sorte que les [*Button*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html) (a) "*Delete*" et (b) "*Clone*" soit grisés par défaut. Ces [*Button*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html) ne pourront être accessible, que si une figure est déjà sélectionnée par l'utilisateur.

5. Si une figure (*cf* [*Shape*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Shape.html)) est préalablement sélectionnée par l'utilisateur. Faites en sorte que :

  - en sélectionnant une nouvelle couleur dans le [*ColorPicker*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html), la couleur de la figure change, en accord avec cette nouvelle couleur.
  
  - (a) en cliquant sur le bouton "*Delete*", la figure soit supprimée du canvas.
  
  - (b) en cliquant sur le bouton "*Clone*", une nouvelle figure, identique à celle sélectionnée soit créée et ajoutée au canvas, avec un léger offset par rapport à la position de la première figure.

___

**BARÈME DU TP :**

- Application [1 pt]
> L'application se lance sans erreurs.
- Interface [5 pts]
> L'interface ressemble à celle présentée. Les éléments graphiques utilisez sont choisis intelligemment.
- Fonctionnalités de base [8 pts]
> Les fonctionnalités énoncées dans le sujets sont implmementées et fonctionnent correctements.
- Fonctionnalités *[Pour aller plus loin ...]* [2 pts]
> Les fonctionnalités avancées sont implmementées et fonctionnent correctements.
- Modèle - Vue - Contrôleur [2 pts]
> Les classes créers sont clairement divisées en trois parties selon le pettern [Modèle - Vue - Contrôleur](https://baptiste-wicht.developpez.com/tutoriels/conception/mvc/).
- Lisibilité [2 pts]
> Le code est lisible, correctement indenté et commenté.

___

**RENDU DU TP :**

Le TP devra être rendu sous la forme d'une archive zippée (.ZIP) contenant les sources (*i.e.* le code du projet) et les ressources (*e.g.* le fichier .FXML) de votre projet. Cette archive sera envoyée à l'adresse [*polytech.ihm.et3@gmail.com*](mailto:polytech.ihm.et3@gmail.com) avec le sujet "[TpNote#2] Prénom NOM".
