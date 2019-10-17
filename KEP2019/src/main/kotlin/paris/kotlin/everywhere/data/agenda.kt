package paris.kotlin.everywhere.data

data class Entry(val talkId: String, val where: String)

sealed class Slot {
    abstract val time: String
    data class Break(override val time: String, val title: String): Slot()
    data class Talks(override val time: String, val talks: List<Entry>): Slot()
}

val agenda = listOf(
    Slot.Break("8h20", "Accueil des workshopeurs & petit déjeuner"),
    Slot.Talks("9h00", listOf(
        Entry("workshop-coroutines", "Salle Workshop"),
        Entry("workshop-multiplatform", "Salle Workshop"),
        Entry("workshop-cloud", "Salle Workshop")
    )),
    Slot.Break("12h30", "Accueil & buffet repas"),
    Slot.Talks("13h30", listOf(
        Entry("ouverture", "Amphithéâtre")
    )),
    Slot.Talks("14h00", listOf(
        Entry("spring", "Amphithéâtre"),
        Entry("native-lib", "2e étage")
    )),
    Slot.Break("15h00", "Pause & rafraichissements"),
    Slot.Talks("15h20", listOf(
        Entry("declarative-ui", "Amphithéâtre"),
        Entry("workflows", "2e étage"),
        Entry("codelab-arrow", "Salle Codelab")
    )),
    Slot.Talks("16h20", listOf(
        Entry("androidx-coroutines", "Amphithéâtre"),
        Entry("react", "2e étage")
    )),
    Slot.Break("16h50", "Pause & rafraichissements"),
    Slot.Talks("17h10", listOf(
        Entry("fullstack", "Amphithéâtre"),
        Entry("multiplatform-kotlin13", "2e étage"),
        Entry("codelab-spring", "Salle Codelab")
    )),
    Slot.Talks("18h10", listOf(
        Entry("gradle-dsl", "Amphithéâtre"),
        Entry("study-lib-coroutines", "2e étage")
    )),
    Slot.Talks("18h40", listOf(
        Entry("cloture", "Amphithéâtre")
    )),
    Slot.Break("19h00", "Buffet & bières !")
)
