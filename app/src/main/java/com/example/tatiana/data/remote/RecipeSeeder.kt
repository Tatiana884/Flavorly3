package com.example.tatiana.data.remote

import com.example.tatiana.data.model.Recipe
import com.example.tatiana.data.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RecipeSeeder {
    private val repository = RecipeRepository()

    val kenyanRecipes = listOf(
        Recipe(
            title = "Ugali Sukuma Wiki & Eggs",
            description = "A staple budget-friendly meal for many Kenyan youths. Quick to prepare and very filling.",
            imageUrl = "https://images.unsplash.com/photo-1606787366850-de6330128bfc",
            ingredients = listOf(
                "2 cups Maize Flour",
                "1 bunch Sukuma Wiki (Kale)",
                "2 Eggs",
                "1 Onion",
                "2 Tomatoes",
                "Cooking Oil",
                "Salt"
            ),
            instructions = listOf(
                "Boil 3 cups of water in a pot.",
                "Gradually add maize flour while stirring until thick. Cover and let cook for 5-10 mins to make Ugali.",
                "Heat oil in a pan, fry chopped onions until golden.",
                "Add tomatoes and cook until soft. Add chopped sukuma wiki and salt. Stir and cook for 5 mins.",
                "In another pan, fry the eggs (scrambled or sunny side up).",
                "Serve the Ugali hot with Sukuma Wiki and Eggs."
            ),
            estimatedCost = 150,
            webUrl = null,
            category = "Budget Friendly"
        ),
        Recipe(
            title = "Chapati & Dondo (Yellow Beans)",
            description = "The ultimate 'mtaani' favorite. Soft chapatis paired with tasty fried beans.",
            imageUrl = "https://images.unsplash.com/photo-1589187151003-fb66cc3ad17f",
            ingredients = listOf(
                "3 cups Wheat Flour",
                "2 cups Cooked Yellow Beans (Dondo)",
                "1 Onion",
                "2 Tomatoes",
                "Garlic/Ginger paste",
                "Cooking Oil",
                "Salt and Sugar"
            ),
            instructions = listOf(
                "Make chapati dough with flour, water, salt, sugar, and oil. Roll and fry on a pan until golden brown.",
                "For the beans: Fry onions in a pot until soft.",
                "Add garlic/ginger paste and tomatoes. Cook until tomatoes form a paste.",
                "Add the pre-cooked yellow beans and a little water for soup.",
                "Simmer for 10 minutes. Serve hot with the chapatis."
            ),
            estimatedCost = 250,
            webUrl = null,
            category = "Popular"
        ),
        Recipe(
            title = "Smokie Pasua with Kachumbari",
            description = "The most popular Kenyan street food. Quick, spicy, and delicious.",
            imageUrl = "https://images.unsplash.com/photo-1599487488170-d11ec9c173f0",
            ingredients = listOf(
                "4 Smokie sausages",
                "1 Onion",
                "2 Tomatoes",
                "Dania (Coriander)",
                "Green Chilies (optional)",
                "Tomato Sauce/Chili Sauce"
            ),
            instructions = listOf(
                "Deep fry or grill the smokies until heated through and slightly crispy.",
                "Prepare Kachumbari: Finely chop onions, tomatoes, dania, and chilies. Mix in a bowl with a pinch of salt.",
                "Slice each smokie lengthwise (pasua) but not all the way through.",
                "Stuff the smokie with a generous amount of kachumbari.",
                "Add tomato or chili sauce as desired and enjoy."
            ),
            estimatedCost = 120,
            webUrl = null,
            category = "Quick Meals"
        ),
        Recipe(
            title = "Githeri (Special)",
            description = "A mixture of maize and beans, elevated with vegetables for a hearty meal.",
            imageUrl = "https://images.unsplash.com/photo-1547592166-23ac45744acd",
            ingredients = listOf(
                "2 cups Pre-boiled Maize and Beans",
                "2 Potatoes (peeled and cubed)",
                "1 Onion",
                "2 Tomatoes",
                "Carrots (chopped)",
                "Capsicum (Hoho)",
                "Salt and spices (Beef masala)"
            ),
            instructions = listOf(
                "Fry onions and hoho until fragrant.",
                "Add tomatoes, carrots, and potatoes. Cook until tomatoes are soft.",
                "Add the pre-boiled maize and beans (githeri).",
                "Add a cup of water, salt, and beef masala spices.",
                "Cover and let it simmer until potatoes are well cooked and the soup thickens.",
                "Serve hot."
            ),
            estimatedCost = 200,
            webUrl = null,
            category = "Traditional"
        ),
         Recipe(
            title = "Pilau (Kienyeji Style)",
            description = "Fragrant rice cooked with beef and traditional pilau spices.",
            imageUrl = "https://images.unsplash.com/photo-1512058560366-cd2429598642",
            ingredients = listOf(
                "2 cups Rice",
                "500g Beef (cubed)",
                "2 Onions (large)",
                "3 cloves Garlic",
                "1 piece Ginger",
                "Pilau Masala",
                "Cooking Oil"
            ),
            instructions = listOf(
                "Boil beef until tender.",
                "Fry onions until dark brown (this gives Pilau its color).",
                "Add crushed garlic and ginger, then the pilau masala.",
                "Add the boiled beef and stir for 2 minutes.",
                "Add rice and 4 cups of water/beef broth.",
                "Cook on low heat until water is absorbed. Serve with Kachumbari."
            ),
            estimatedCost = 450,
            webUrl = null,
            category = "Special"
        )
    )

    suspend fun seedDatabase() = withContext(Dispatchers.IO) {
        kenyanRecipes.forEach { recipe ->
            try {
                repository.createRecipe(recipe)
            } catch (e: Exception) {
                println("Failed to insert recipe: ${recipe.title}")
            }
        }
    }
}
