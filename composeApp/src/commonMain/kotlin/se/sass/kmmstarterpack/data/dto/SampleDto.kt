package se.sass.kmmstarterpack.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import se.sass.kmmstarterpack.domain.model.SampleModel
import se.sass.kmmstarterpack.domain.model.util.Domain

@Serializable
data class SampleDto (
    @SerialName("userId")
    var userId : Int?    = null,
    @SerialName("id")
    var id     : Int?    = null,
    @SerialName("title")
    var title  : String? = null,
    @SerialName("body")
    var body   : String? = null
): Domain<SampleModel> {
    override fun cast(): SampleModel =
        SampleModel(
            userId, id, title, body
        )

}