package shop.zamzambookshop.app.data.repository

import shop.zamzambookshop.app.R
import shop.zamzambookshop.app.data.model.Product
import shop.zamzambookshop.app.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products: List<Product> = listOf(
        // Fiction
        Product(
            id = 1,
            title = "The Kite Runner",
            description = "A powerful story of friendship, betrayal, and redemption set against the backdrop of a turbulent Afghanistan. Khaled Hosseini's debut novel is a sweeping epic that follows Amir on a journey of self-discovery and forgiveness.",
            category = ProductCategory.FICTION,
            price = 9.99,
            imageRes = R.drawable.book_fiction_1,
        ),
        Product(
            id = 2,
            title = "A Thousand Splendid Suns",
            description = "An unforgettable portrait of a resilient people. Hosseini weaves an extraordinary story of two women whose lives become intertwined in the most unexpected ways during three decades of war in Afghanistan.",
            category = ProductCategory.FICTION,
            price = 10.99,
            imageRes = R.drawable.book_fiction_2,
        ),
        Product(
            id = 3,
            title = "The Alchemist",
            description = "Paulo Coelho's masterpiece tells the mystical story of Santiago, an Andalusian shepherd boy who yearns to travel in search of a worldly treasure. A global phenomenon, this book has sold over 65 million copies worldwide.",
            category = ProductCategory.FICTION,
            price = 8.99,
            imageRes = R.drawable.book_fiction_3,
        ),

        // Non-Fiction
        Product(
            id = 4,
            title = "Sapiens: A Brief History of Humankind",
            description = "Yuval Noah Harari takes us on a breathtaking ride through the entire history of the human species. From the Stone Age to the Silicon Age, Harari explores how biology and history have defined us and enhanced our understanding of what it means to be human.",
            category = ProductCategory.NON_FICTION,
            price = 12.99,
            imageRes = R.drawable.book_nonfiction_1,
        ),
        Product(
            id = 5,
            title = "Thinking, Fast and Slow",
            description = "Daniel Kahneman, the world-famous psychologist and winner of the Nobel Prize in Economics, takes us on a groundbreaking tour of the mind and explains the two systems that drive the way we think.",
            category = ProductCategory.NON_FICTION,
            price = 11.99,
            imageRes = R.drawable.book_nonfiction_2,
        ),

        // Children's
        Product(
            id = 6,
            title = "The Lion, the Witch and the Wardrobe",
            description = "C.S. Lewis's timeless fantasy epic. Four siblings step through a wardrobe door and into the land of Narnia, a world frozen in eternal winter by the White Witch. A story of courage, friendship, and the ultimate battle between good and evil.",
            category = ProductCategory.CHILDREN,
            price = 7.99,
            imageRes = R.drawable.book_children_1,
        ),
        Product(
            id = 7,
            title = "Charlie and the Chocolate Factory",
            description = "Roald Dahl's irresistible story of Charlie Bucket and his adventures inside Willy Wonka's mysterious chocolate factory. A beloved classic that enchants readers of all ages with its delicious imagination.",
            category = ProductCategory.CHILDREN,
            price = 6.99,
            imageRes = R.drawable.book_children_2,
        ),

        // Academic
        Product(
            id = 8,
            title = "Introduction to Algorithms",
            description = "The most comprehensive guide to algorithms in computer science. Whether used as a textbook for a first course in computing algorithms or as a professional reference, this book covers a broad range of algorithms in depth.",
            category = ProductCategory.ACADEMIC,
            price = 49.99,
            imageRes = R.drawable.book_academic_1,
        ),
        Product(
            id = 9,
            title = "Principles of Economics",
            description = "N. Gregory Mankiw's market-leading text remains the most popular and widely used economics textbook. With its clear writing style and built-in learning aids, this book offers an accessible introduction to economics.",
            category = ProductCategory.ACADEMIC,
            price = 44.99,
            imageRes = R.drawable.book_academic_2,
        ),

        // Islamic Studies
        Product(
            id = 10,
            title = "In the Footsteps of the Prophet",
            description = "Tariq Ramadan presents a multifaceted portrait of Muhammad, exploring his spiritual and ethical teachings and his relevance to Muslims today. A compelling and accessible biography of one of the world's most influential figures.",
            category = ProductCategory.ISLAMIC_STUDIES,
            price = 13.99,
            imageRes = R.drawable.book_islamic_1,
        ),
        Product(
            id = 11,
            title = "The Heart of Islam",
            description = "Seyyed Hossein Nasr illuminates the key beliefs and practices of Islam for general readers. Exploring the Quran, Islamic law, prayer, and mystical traditions, this book provides a rich and nuanced understanding of Islam's enduring spiritual message.",
            category = ProductCategory.ISLAMIC_STUDIES,
            price = 14.99,
            imageRes = R.drawable.book_islamic_2,
        ),

        // Biography
        Product(
            id = 12,
            title = "Long Walk to Freedom",
            description = "Nelson Mandela's inspiring autobiography covers his childhood, his years as a political prisoner on Robben Island, and his eventual rise to the Presidency of South Africa. A story of extraordinary courage and moral leadership.",
            category = ProductCategory.BIOGRAPHY,
            price = 11.99,
            imageRes = R.drawable.book_biography_1,
        ),
        Product(
            id = 13,
            title = "Steve Jobs",
            description = "Walter Isaacson's compelling biography of Apple's co-founder is based on more than forty interviews with Jobs conducted over two years. A candid portrait of the creative entrepreneur whose passion for perfection revolutionised six industries.",
            category = ProductCategory.BIOGRAPHY,
            price = 13.99,
            imageRes = R.drawable.book_biography_2,
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}