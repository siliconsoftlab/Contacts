package tyde.com.contatcs.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class WebServiceResponse(
    var data: List<Data?>?,
    var page: Int?,
    var per_page: Int?,
    var total: Int?,
    var total_pages: Int?
):Parcelable

@Parcelize
data class Data(
    var avatar: String?,
    var first_name: String?,
    var id: Int?,
    var last_name: String?
):Parcelable

