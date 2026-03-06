package shop.zamzambookshop.app.ui.composable.screen.products

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shop.zamzambookshop.app.R

data class LiteraryArticle(
    val title: String,
    val subtitle: String,
    @DrawableRes val imageRes: Int,
)

val literaryArticles = listOf(
    LiteraryArticle(
        title = "The Rise of Islamic Literature",
        subtitle = "Exploring timeless wisdom through modern narratives",
        imageRes = R.drawable.book_islamic_1,
    ),
    LiteraryArticle(
        title = "Top Non-Fiction of 2025",
        subtitle = "Must-read titles that shaped the year",
        imageRes = R.drawable.book_nonfiction_1,
    ),
    LiteraryArticle(
        title = "Classic Fiction for Everyone",
        subtitle = "Stories that transcend generations",
        imageRes = R.drawable.book_fiction_1,
    ),
    LiteraryArticle(
        title = "Books That Spark Young Minds",
        subtitle = "Best children\'s titles for curious readers",
        imageRes = R.drawable.book_children_1,
    ),
    LiteraryArticle(
        title = "Academic Reading Guide",
        subtitle = "Smart strategies for scholarly texts",
        imageRes = R.drawable.book_academic_1,
    ),
)

@Composable
fun ArticleCarousel(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = "Literary Insights",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(literaryArticles) { article ->
                ArticleCard(article = article)
            }
        }
    }
}

@Composable
private fun ArticleCard(
    article: LiteraryArticle,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(160.dp)
            .fillMaxWidth(0.75f)
            .clip(RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.BottomStart,
    ) {
        Image(
            painter = painterResource(id = article.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.75f)),
                        startY = 60f,
                    )
                )
        )

        Column(
            modifier = Modifier.padding(12.dp),
        ) {
            Text(
                text = article.title,
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 18.sp,
            )
            Text(
                text = article.subtitle,
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 11.sp,
                lineHeight = 15.sp,
            )
        }
    }
}
