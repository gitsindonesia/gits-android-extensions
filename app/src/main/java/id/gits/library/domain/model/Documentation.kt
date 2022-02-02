package id.gits.library.domain.model

data class Documentation(
    val extensionName: String? = "",
    val examples: List<Example>? = emptyList(),
)