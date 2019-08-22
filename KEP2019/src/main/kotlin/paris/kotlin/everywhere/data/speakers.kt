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
        description = "Let's visualize the world\nGaetan is an enthusiastic father, developer, entrepreneur, paraglider pilot, … Having used lots of languages during its 20 years of IT experience, he believed very early in the promises of kotlin. He started in 2012 to code with it and in 2013 to promote it as a speaker.",
        webSite = "https://data2viz.io/",
        talks = listOf("fullstack")
    ),
    Speaker(
        id = "geoffrey-metais",
        name = "Geoffrey Métais",
        company = "VideoLAN",
        description = "Lead Android developer at VideoLAN and Videolabs.",
        twitter = "geoffreymetais",
        webSite = "https://geoffreymetais.github.io/",
        talks = listOf("workshop-coroutines", "androidx-coroutines")
    ),
    Speaker(
        id = "louis-cad",
        name = "Louis CAD",
        company = "Beepiz",
        description = "Android & Kotlin Dev. Efficiency before performance. Bike commuter, velomobile enthusiast.",
        twitter = "Louis_CAD",
        talks = listOf("workshop-coroutines", "study-lib-coroutines")
    ),
    Speaker(
        id = "mohamed-bennis",
        name = "Mohamed Bennis",
        company = "Octo Technology",
        description = "Développeur mobile chez Octo Technology, travail principalement sur des projets Android/Kotlin et s'intéresse de plus en plus sur le sujet du multiplateforme.",
        talks = listOf("native-lib")
    ),
    Speaker(
        id = "romain-boisselle",
        name = "Romain Boisselle",
        company = "Kodein Koders",
        description = "Je suis un développeur backend depuis 8 ans, principalement en Java + Spring et freelance depuis un an, centré sur les architectures backend. Je suis tombé amoureux de Kotlin il y a 4 ans, et l'utilise réellement en production depuis deux ans dans des projets backend. Java ne sera bientôt plus qu'un souvenir :) Je suis également un père comblé, et adepte du zéro gaspillage.",
        talks = listOf("workshop-cloud")
    ),
    Speaker(
        id = "salomon-brys",
        name = "Salomon Brys",
        company = "Kodein Koders",
        description = "Passionné de Kotlin depuis que Kotlin il y a, Salomon est le fondateur de Kodein Koders et du Kodein Framework. Fortement implanté dans la philosophie Open-Source, il se dédie à la création de librairie et d'outils pour rendre la programmation plus facile, sure, et fun. Il est aussi addict aux jeux de sociétés, et adore piloter des avions de loisir.",
        twitter = "salomonbrys",
        webSite = "https://kodein.net",
        talks = listOf("workshop-multiplatform", "react")
    ),
    Speaker(
        id = "sebastien-deleuze",
        name = "Sébastien Deleuze",
        company = "Pivotal",
        description = "Sébastien est committer Spring Framework chez Pivotal. Il travaille principalement sur le support de Kotlin des différents projets Spring, ainsi que sur les sujets Web et Reactive. Il a créé le project Spring Fu et est également membre de l'équipe qui organise la conférence MiXiT.",
        twitter = "sdeleuze",
        webSite = "https://spring.io/team/sdeleuze",
        talks = listOf("spring"),
        featured = true
    ),
    Speaker(
        id = "yacine-rezgui",
        name = "Yacine Rezgui",
        company = "Google",
        description = "Yacine is working as an Android Developer Advocate at Google, helping to make Android the best mobile platform for developers. His focus is the developer experience across the whole ecosystem, from the expert to the beginner. He worked previously at IBM as a developer advocate and as full stack developer in several startups. He's currently living in London, UK.",
        twitter = "yrezgui",
        webSite = "https://yrezgui.com",
        talks = listOf("declarative-ui"),
        featured = true
    )

).associateBy { it.id }
