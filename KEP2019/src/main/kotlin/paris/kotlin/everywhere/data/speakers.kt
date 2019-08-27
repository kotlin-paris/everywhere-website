package paris.kotlin.everywhere.data

data class Speaker(
    val id: String,
    val name: String,
    val company: String? = null,
    val description: String,
    val twitter: String? = null,
    val webSite: String? = null,
    val talks: List<String> = emptyList(),
    val featured: Boolean = false
)

val speakers = listOf(
    Speaker(
        id = "dmitry-savvinov",
        name = "Dmitry Savvinov",
        company = "JetBrains",
        description = """
            I've made my first acquaintance with Kotlin Team in 2016 during "JetBrains Summer Internship", where I was a part of the team responsible for implementing a translator from Kotlin to LLVM and then using it to deploy simple Kotlin program onto Raspberry Pi controller. Sometimes  One could say that was one of the very first Kotlin/Native programs :) (though the translator itself was terrible, obviously). 
            From 2016 to 2017 I was writing a Master thesis together with Kotlin team, which results were used later as foundation for a language feature known now as Kotlin Contracts. In Kotlin Team, my main field of interest is compiler's frontend: code analysis, type inference, etc. Currently I'm actively working on improving multiplatform projects support in the compiler and IDE.            
        """.trimIndent(),
        twitter = "dsavvinov",
        talks = listOf("multiplatform-kotlin13"),
        featured = true
    ),
    Speaker(
        id = "gaetan-zoritchak",
        name = "Gaetan Zoritchak",
        company = "Data2Viz",
        description = """
            Let's visualize the world.
            Gaetan is an enthusiastic father, developer, entrepreneur, paraglider pilot, …
            Having used lots of languages during its 20 years of IT experience, he believed very early in the promises of kotlin. He started in 2012 to code with it and in 2013 to promote it as a speaker.
        """.trimIndent(),
        webSite = "https://data2viz.io/",
        talks = listOf("fullstack")
    ),
    Speaker(
        id = "geoffrey-metais",
        name = "Geoffrey Métais",
        company = "VideoLAN",
        description = """
            Lead Android developer at VideoLAN and Videolabs.
        """.trimIndent(),
        twitter = "geoffreymetais",
        webSite = "https://geoffreymetais.github.io/",
        talks = listOf("workshop-coroutines", "androidx-coroutines")
    ),
    Speaker(
        id = "louis-cad",
        name = "Louis CAD",
        company = "Beepiz",
        description = """
            Android & Kotlin Dev. Efficiency before performance. Bike commuter, velomobile enthusiast.
        """.trimIndent(),
        twitter = "Louis_CAD",
        talks = listOf("workshop-coroutines", "study-lib-coroutines")
    ),
    Speaker(
        id = "lucien-guimaraes",
        name = "Lucien Guimaraes",
        company = "Kapten",
        description = """
            Android Developer at Kapten. I’m currently improving our users’ life, working on the “Kapten Rider” application. I have been working as a mobile developer since 2013.
        """.trimIndent(),
        talks = listOf("gradle-dsl")
    ),
    Speaker(
        id = "martin-bonnin",
        name = "Martin Bonnin",
        company = "Dailymotion",
        description = """
            Martin est Engineering Manager chez Dailymotion. Baignant dans le monde Android depuis 2009, il est très heureux de pouvoir maintenant écrire du Kotlin et espère bientôt en écrire pour toutes les plateformes !
            En dehors du Kotlin, Martin aime les randonnées dans les Pyrénées et faire une petite partie de Hearthstone.
        """.trimIndent(),
        twitter = "martinbonnin",
        webSite = "https://mbonnin.net",
        talks = listOf("workflows")
    ),
    Speaker(
        id = "mohamed-bennis",
        name = "Mohamed Bennis",
        company = "Octo Technology",
        description = """
            Développeur mobile chez Octo Technology, travail principalement sur des projets Android/Kotlin et s'intéresse de plus en plus sur le sujet du multiplateforme.
        """.trimIndent(),
        talks = listOf("native-lib")
    ),
    Speaker(
        id = "romain-boisselle",
        name = "Romain Boisselle",
        company = "Kodein Koders",
        description = """
            Je suis un développeur backend depuis 8 ans, principalement en Java + Spring et freelance depuis un an, centré sur les architectures backend.
            Je suis tombé amoureux de Kotlin il y a 4 ans, et l'utilise réellement en production depuis deux ans dans des projets backend. Java ne sera bientôt plus qu'un souvenir :)
            Je suis également un père comblé, et adepte du zéro gaspillage.
        """.trimIndent(),
        talks = listOf("workshop-cloud")
    ),
    Speaker(
        id = "riadh-mnasri",
        name = "Riadh Mnasri",
        company = "Enedis",
        description = """
            Passionate Developer, Clean Code Lover, Geek, Permanent Learner, Freelance, Happy Husband & Father #Java #Kotlin #CleanCode #FunctionalProgramming #TDD #BDD #DDD
        """.trimIndent(),
        twitter = "riadhmnasri",
        webSite = "https://www.linkedin.com/in/riadhmnasri/",
        talks = listOf("codelab-arrow")
    ),
    Speaker(
        id = "salomon-brys",
        name = "Salomon Brys",
        company = "Kodein Koders",
        description = """
            Passionné de Kotlin depuis que Kotlin il y a, Salomon est le fondateur de Kodein Koders et du Kodein Framework. Fortement implanté dans la philosophie Open-Source, il se dédie à la création de librairie et d'outils pour rendre la programmation plus facile, sure, et fun.
            Il est aussi addict aux jeux de sociétés, et adore piloter des avions de loisir.
        """.trimIndent(),
        twitter = "salomonbrys",
        webSite = "https://kodein.net",
        talks = listOf("workshop-multiplatform", "react")
    ),
    Speaker(
        id = "sebastien-deleuze",
        name = "Sébastien Deleuze",
        company = "Pivotal",
        description = """
            Sébastien est committer Spring Framework chez Pivotal. Il travaille principalement sur le support de Kotlin des différents projets Spring, ainsi que sur les sujets Web et Reactive.
            Il a créé le project Spring Fu et est également membre de l'équipe qui organise la conférence MiXiT.
        """.trimIndent(),
        twitter = "sdeleuze",
        webSite = "https://spring.io/team/sdeleuze",
        talks = listOf("spring"),
        featured = true
    ),
    Speaker(
        id = "yacine-rezgui",
        name = "Yacine Rezgui",
        company = "Google",
        description = """
            Yacine est \"Android Developer Advocate\" à Google, travaillant à faire d'Android la meilleure plateforme mobile pour les développeurs. Il se concentre sur l'expérience de développement à travers tout l'écosystème, de l'expert au débutant.
            Il a été \"Developer Advocate\" chez IBM et \"Full Stack Developer\" dans différentes startups. Il habite actuellement à Londres, Royaume Uni.
        """.trimIndent(),
        twitter = "yrezgui",
        webSite = "https://yrezgui.com",
        talks = listOf("declarative-ui"),
        featured = true
    )

).associateBy { it.id }
