package tyde.com.contatcs.model

data class WebServiceResponse(
    var data: List<Data?>?,
    var page: Int?,
    var per_page: Int?,
    var total: Int?,
    var total_pages: Int?
)

data class Data(
    var avatar: String?,
    var first_name: String?,
    var id: Int?,
    var last_name: String?
)

