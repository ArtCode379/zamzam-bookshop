package shop.zamzambookshop.app.ui.composable.screen.products

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
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
    val content: String,
)

val literaryArticles = listOf(
    LiteraryArticle(
        title = "The Rise of Islamic Literature",
        subtitle = "Exploring timeless wisdom through modern narratives",
        imageRes = R.drawable.book_islamic_1,
        content = "Islamic literature has experienced a remarkable renaissance in the 21st century. " +
            "Authors across the globe are weaving classical wisdom from the Quran and Hadith into " +
            "contemporary storytelling, creating works that speak to both devout readers and those " +
            "simply curious about the tradition.\n\n" +
            "From the poetry of Rumi to the modern novels of Leila Aboulela, the breadth of Islamic " +
            "literary tradition is vast and vibrant. Today's readers can explore spiritual journeys, " +
            "social justice narratives, and philosophical explorations — all rooted in a rich " +
            "centuries-old heritage.\n\n" +
            "At ZamZam Bookshop, our Islamic Studies section features over 200 titles spanning " +
            "classical scholarship, contemporary fiction, children's books, and academic texts. " +
            "Whether you are beginning your journey or deepening existing knowledge, our curated " +
            "collection has something for every seeker.",
    ),
    LiteraryArticle(
        title = "Top Non-Fiction of 2025",
        subtitle = "Must-read titles that shaped the year",
        imageRes = R.drawable.book_nonfiction_1,
        content = "2025 was a landmark year for non-fiction publishing. Readers turned to books " +
            "for clarity in an increasingly complex world, and authors delivered with remarkable " +
            "depth and honesty.\n\n" +
            "Among the standout titles were works on artificial intelligence and its societal " +
            "impact, memoirs from global leaders navigating unprecedented crises, and groundbreaking " +
            "explorations of climate science written for general audiences.\n\n" +
            "The year also saw a surge in books about mental health, community resilience, and " +
            "the rediscovery of analog life in a digital age. Non-fiction in 2025 did not merely " +
            "inform — it challenged assumptions and inspired action.\n\n" +
            "Browse our Non-Fiction section to discover the titles that defined the year and " +
            "continue to shape conversations around the world.",
    ),
    LiteraryArticle(
        title = "Classic Fiction for Everyone",
        subtitle = "Stories that transcend generations",
        imageRes = R.drawable.book_fiction_1,
        content = "Great fiction never truly ages. The works of Jane Austen, Charles Dickens, " +
            "Fyodor Dostoevsky, and Gabriel García Márquez remain as relevant today as when they " +
            "were first published — because they speak to the unchanging core of the human experience.\n\n" +
            "Classic fiction teaches empathy by placing us inside lives very different from our own. " +
            "It challenges us to think critically about society, morality, and what it means to live " +
            "well. And it does all of this while telling unforgettable stories.\n\n" +
            "Whether you are revisiting a beloved favourite or discovering a classic for the first " +
            "time, our Fiction section offers beautifully printed editions, annotated scholarly " +
            "versions, and accessible modern translations. There is no better time to begin.",
    ),
    LiteraryArticle(
        title = "Books That Spark Young Minds",
        subtitle = "Best children's titles for curious readers",
        imageRes = R.drawable.book_children_1,
        content = "Reading early and often is one of the greatest gifts a child can receive. " +
            "Books spark imagination, build vocabulary, develop empathy, and instil a lifelong " +
            "love of learning.\n\n" +
            "Our Children's section is carefully curated to nurture curiosity at every age. " +
            "For toddlers and early readers, we stock vibrant picture books with rich illustrations. " +
            "For middle-grade readers, we offer adventure stories, mysteries, and age-appropriate " +
            "classics. For young adults, our shelves feature coming-of-age novels, fantasy epics, " +
            "and thought-provoking contemporary fiction.\n\n" +
            "We also carry a wonderful selection of children's books rooted in Islamic values and " +
            "multicultural perspectives — helping young readers see themselves in the stories they read " +
            "while learning about the wider world.",
    ),
    LiteraryArticle(
        title = "Academic Reading Guide",
        subtitle = "Smart strategies for scholarly texts",
        imageRes = R.drawable.book_academic_1,
        content = "Academic texts demand a different approach from leisure reading. The density of " +
            "argument, the specificity of language, and the depth of footnotes can be daunting — " +
            "but with the right strategies, scholarly reading becomes deeply rewarding.\n\n" +
            "Start with the abstract or introduction to understand the thesis before diving in. " +
            "Read actively: annotate margins, underline key claims, and write brief summaries " +
            "at the end of each chapter. Engage with the text as a conversation rather than " +
            "a monologue.\n\n" +
            "Our Academic section covers a wide range of disciplines: history, philosophy, " +
            "linguistics, science, law, and more. We stock both introductory textbooks and " +
            "cutting-edge research monographs. Our staff are always happy to recommend titles " +
            "suited to your level and area of study.",
    ),
)

@Composable
fun ArticleCarousel(
    modifier: Modifier = Modifier,
    onArticleClick: (Int) -> Unit = {},
) {
    val pagerState = rememberPagerState(pageCount = { literaryArticles.size })

    Column(modifier = modifier) {
        Text(
            text = "Literary Insights",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
        )

        HorizontalPager(
            state = pagerState,
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp),
            pageSpacing = 12.dp,
            modifier = Modifier.fillMaxWidth(),
        ) { page ->
            ArticleCard(
                article = literaryArticles[page],
                modifier = Modifier.fillMaxWidth(),
                onClick = { onArticleClick(page) },
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(literaryArticles.size) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .size(if (isSelected) 8.dp else 6.dp)
                        .clip(CircleShape)
                        .background(
                            if (isSelected)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.outline
                        ),
                )
            }
        }
    }
}

@Composable
private fun ArticleCard(
    article: LiteraryArticle,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .height(160.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick),
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
