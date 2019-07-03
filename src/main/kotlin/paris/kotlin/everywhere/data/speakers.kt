package paris.kotlin.everywhere.data

data class Speaker(
    val name: String,
    val description: String
)

val speakers = mapOf(
    "sebastien-deleuze" to Speaker(
        name = "Sébastien Deleuze",
        description = "Sébastien est committer Spring Framework chez Pivotal. Il travaille principalement sur le support de Kotlin des différents projets Spring, ainsi que sur les sujets Web et Reactive. Il a créé le project Spring Fu et est également membre de l'équipe qui organise la conférence MiXiT."
    )
)
