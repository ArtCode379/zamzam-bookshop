package shop.zamzambookshop.app.data.model

import androidx.annotation.StringRes
import shop.zamzambookshop.app.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    FICTION(R.string.category_fiction),
    NON_FICTION(R.string.category_non_fiction),
    CHILDREN(R.string.category_children),
    ACADEMIC(R.string.category_academic),
    ISLAMIC_STUDIES(R.string.category_islamic_studies),
    BIOGRAPHY(R.string.category_biography),
}