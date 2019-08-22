package paris.kotlin.everywhere.data

data class Talk(
    val id: String,
    val title: String,
    val description: String,
    val speakers: List<String>,
    val isWorkshop: Boolean = false
)

val talks = listOf(
    Talk(
        id = "androidx-coroutines",
        title = "AndroidX + coroutines = <3",
        description = """
        """.trimIndent(),
        speakers = listOf("geoffrey-metais"),
        isWorkshop = true
    ),
    Talk(
        id = "declarative-ui",
        title = "Be aware, Declarative UI are taking over!",
        description = """
            D'Android à iOS, en passant par le web, l'interface utilisateur s'écrit de plus en plus de manière déclarative à la place de fichiers XML ou de code impératif.
            Petit tour d'horizon sur cette nouvelle tendance sur toutes les plateformes de développement avec un focus sur Jetpack Compose.
        """.trimIndent(),
        speakers = listOf("yacine-rezgui")
    ),
    Talk(
        id = "fullstack",
        title = "Kotlin Fullstack",
        description = """
            Dès le départ, Kotlin a été conçu pour être déployable dans divers contextes et plateformes: back et front, JVM, JS et natif.
            Dans un de nos derniers projets web, nous avons profité de cette caractéristique pour utiliser Kotlin au maximum, dans toutes les couches de notre application.
            Nous détaillerons l'architecture de ce projet lors de cette présentation, et comment nous avons utilisé des librairies multiplateformes pour partager du code entre le serveur et le navigateur.
            
            Les librairies et projets utilisés sont:
                - xodus-dnq, pour définir le modèle de données et accéder à la base xodus,
                - Ktor comme framework web,
                - Kotlinx.hmtl pour le templating html, serveur et client,
                - Kotlinx.serialization pour le partage d’état entre le serveur et le client,
                - Kotlin/JS et une implémentation interne de Redux pour le code client.
        """.trimIndent(),
        speakers = listOf("gaetan-zoritchak")
    ),
    Talk(
        id = "multiplatform-kotlin13",
        title = "Multiplatform Programming in Kotlin 1.3",
        description = """
            Kotlin Multiplatform is a language feature which provides the ability to share and re-use common code across different platforms. The very first iteration was announced in Kotlin 1.2, and since then, multiplatform technology has greatly evolved.
            In this talk, we'll give a consistent, cumulative overview of the most recent features and changes in multiplatform projects support in Kotlin. Also, we'll explain why these changes were made and what new opportunities they unlock.
            The talk is well-suited both for beginners who want to get an introduction into technology, and for advanced users who want to hear latest news and insights about multiplatform programming in Kotlin.
        """.trimIndent(),
        speakers = listOf("dmitry-savvinov")
    ),
    Talk(
        id = "native-lib",
        title = "Créer une bibliothèque pour Android et iOS avec Kotlin/Native",
        description = """
            Le partage de code entre différentes plateformes est devenu une pratique de plus en plus utilisée dans le monde du développement mobile.
            Grace à Kotlin/Native nous pouvons mutualiser notre code d'une manière différente et le réutiliser afin de gagner en temps de développement.
            A travers mon POC "Convertisseur de devise" et un mini live coding nous apprendrons ensemble :
                * comment configurer un projet avec Kotlin/Native
                * comment mutualiser les différentes parties d'une application mobile
                * comment organiser son code avec une variante de la clean architecture et le tester
        """.trimIndent(),
        speakers = listOf("mohamed-bennis")
    ),
    Talk(
        id = "ouverture",
        title = "Ouverture",
        description = """
            Venez rencontrer le staff de la conférence et découvrir les dernières tendances Kotlin!
        """.trimIndent(),
        speakers = emptyList()
    ),
    Talk(
        id = "react",
        title = "Un site entièrement en Kotlin avec Kotlin-React",
        description = """
            Savez vous qu'il est possible d'écrire un site web entièrement en Kotlin ? Pas de HTML, pas de CSS, pas de JS. Que du Kotlin. Et en declarative UI, s'il vous plaît !
            Dans cette présentation, nous plongerons dans le code du site web de la conférence, site static hébergé sur Github.
            Nous verrons comment utiliser React en Kotlin, comment générer la page HTML hôte, comment intégrer du CSS directement dans les composants, et même comment accélérer le chargement en utilisant React-SSR (Server-Side Rendering).
        """.trimIndent(),
        speakers = listOf("salomon-brys")
    ),
    Talk(
        id = "spring",
        title = "Quoi de neuf sur le support de Kotlin dans Spring ?",
        description = """
            La première partie de cette conférence donnera un aperçu de l'état de l'art du développement d'applications Spring Boot 2.2 avec Kotlin:
                - Data classes immutables avec @ConfigurationProperties
                - Tests avec JUnit 5 et Mockk
                - La nouvelle DSL “router” pour Spring MVC
                - Le support des Coroutines sur WebFlux, RSocket et Spring Data
                - Les exemples de code en Kotlin dans la documentation de référence
                - La DSL MockMvc
                - Un rappel des bonnes pratiques (extensions, injection de dépendances via constructeur)
            La seconde partie sera un live coding d'une application Spring Boot configurée avec Kofu, la DSL Kotlin actuellement développée dans l'incubateur Spring Fu que j'ai créé il y a quelques mois. Il s'agit d'une alternative à l'auto-configuration Spring Boot conçue pour configurer votre application de manière explicite en utilisant l'auto-complétion et des "slices" de configuration tout en supportant la plupart des fonctionnalités de Spring Boot.
        """.trimIndent(),
        speakers = listOf("sebastien-deleuze")
    ),
    Talk(
        id = "study-lib-coroutines",
        title = "Étude d'une bibliothèque à base de coroutines",
        description = """
            Dans cette session, je vais vous montrer avec mon IDE comment j'ai pu faire une API super simple en partant d'une API type callback hell, et comment vous aussi vous pouvez vous libérer des complexités d'une API une bonne fois pour toutes grâce aux coroutines.
            
            Nous étudieront la bibliothèque BleGattCoroutines pour Android qui permet de se connecter à un appareil Bluetooth Low Energy tel qu'un beacon, et de communiquer avec.
            
            Petite histoire :
            Les beacons sont des balises de localisation d'intérieur utilisant le Bluetooth Low Energy.
            Il y a 2 ans, j'ai eu besoin d'en configurer par programmation afin de semi-automatiser leur réglage et enregistrement.
            Le fournisseur de beacons fournissait un SDK non open-source, qu'il était tout de même possible de décompiler facilement car fait en Java et non obfusqué. Cela ne fut cependant pas nécessaire, j'ai déchanté dès que j'ai vu le code du sample où il y avait littéralement un warning toutes les 2 lignes, et une API dont la conception me repoussait.
            J'ai alors fouillé dans la spécification open-source du protocole Eddystone utilisé par nos beacons, ai vu une lueur d'espoir, mais j'allais avoir besoin de l'API Bluetooth GATT d'Android, qui est un callback hell. C'était au moment où je débutais dans les coroutines. En une semaine, j'ai appris les Channel de kotlinx.coroutines et ai mis au point BleGattCoroutines, qui nous avons rendu open-source (Apache 2). La semaine d'après, j'ai programmé les beacons sur cette base et suis devenu fan des coroutines depuis.
        """.trimIndent(),
        speakers = listOf("louis-cad")
    ),
    Talk(
        id = "workshop-coroutines",
        title = "Les coroutines en détail",
        description = """
            Les coroutines sont la fonctionalité la plus importante introduite dans Kotlin depuis sa création. Vous avez probablement entendu dire que les coroutines facilitent l'asynchronicité et qu'elles permettent d'écrire ce type de code de manière impérative. Saviez vous que Kotlin fournit une implémentation bas niveau des coroutines très différente de la plupart des autres langages de programmation ?
            Dans ce workshop, nous vous proposons de découvrir les coroutines de Kotlin et d'approfondir sur leur spécificité et leurs possibilités. Nous commencerons par comprendre ce que sont exactement les coroutines et leurs utilisations synchrones et asynchrones. Nous verrons ensuite comment les utiliser dans un contexte multi-thread en fonction de nos besoins, et finirons par explorer des patterns architecturaux avancés comme le Reactive Functional Programming et l'Actor Based Programming, simplifé par les librairies haut-niveau (notamment kotlinx.coroutines).
            À travers cette matinée, nous créerons ensemble une petite application qui nous permettra de mettre en pratique notre progression dans l'univers des coroutines. Cette application pourra être à votre choix en ligne de commande ou sur Android. Le seul prérequis est de connaître au choix le langage Java ou le langage Kotlin.
        """.trimIndent(),
        speakers = listOf("geoffrey-metais", "louis-cad"),
        isWorkshop = true
    ),
    Talk(
        id = "workshop-multiplatform",
        title = "Kotlin multi platformes mobiles",
        description = """
            Grâce au langage Kotlin et à son outillage, nous pouvons créer des applications qui pour Android, iOS et le Web.
            Dans ce workshop nous verrons comment utiliser Kotlin pour réutiliser notre code métier à travers multiple platformes. Nous verrons comment définir l'architecture de notre applications, créer les abstractions nécéssaires pour obtenir un code réutilisables, comment tester ce code sur toutes ces platformes, et enfin comment le déployer.
            Grâce à une série d'exercices simples, nous créerons ensemble une application qui pourra être déployée sur chaque platforme, chacune conservant sa propre couche de présentation.
            Notez que bien qu'un MacBook est recommandé si vous souhaitez déployer sur iOS ; un PC sous linux ou windows vous permettra d'utiliser Kotlin/JVM, Kotlin/JS et Kotlin/Native.
        """.trimIndent(),
        speakers = listOf("salomon-brys"),
        isWorkshop = true
    ),
    Talk(
        id = "workshop-cloud",
        title = "Cloud moderne en Kotlin",
        description = """
            Dans ce workshop, nous verrons une nouvelle manière de coder des serveurs en Kotlin, grâce à une librarie développée par Jetbrains : Ktor, un framework permettant de créer un serveur entièrement asynchrone grâce à la puissance du langage Kotlin et de ses coroutines.
            Nous commencerons par présenter Ktor et ses utilisations les plus simples pour créer, en quelques lignes, un serveur simple permettant de servir une API et du contenu statique. Nous verrons ensuite comment utiliser certaines des fonctionalités plus avancées, notemment liées à la sécurité et aux systèmes complexes.
            Enfin, nous verrons comment intégrer d'autres librairies utilisant Kotlin et permettant d'architecturer notre code et facilitant grandement la gestion de notre base de données. En 3h30, vous aurez un serveur léger, puissant, lisible et sécurisé !
        """.trimIndent(),
        speakers = listOf("romain-boisselle"),
        isWorkshop = true
    )
).associateBy { it.id }
