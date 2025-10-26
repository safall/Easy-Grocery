package com.whitecatlabs.easygrocery.database

import com.whitecatlabs.easygrocery.database.entity.MasterGroceryEntity
import com.whitecatlabs.easygrocery.database.entity.MasterGroceryItemEntity

object MasterTableData {
    val groceries = listOf(
        MasterGroceryEntity(
            id = "1",
            title = "Vegetables",
            color = "#008000",
        ),
        MasterGroceryEntity(
            id = "2",
            title = "Meat and Eggs",
            color = "#800000",
        ),
        MasterGroceryEntity(
            id = "3",
            title = "Fruits",
            color = "#FF7F50",
        ),
        MasterGroceryEntity(
            id = "4",
            title = "Cleaning Stuffs",
            color = "#0080FF",
        ),
        MasterGroceryEntity(
            id = "5",
            title = "Dairy Products",
            color = "#A4BC3F",
        ),
        MasterGroceryEntity(
            id = "6",
            title = "Liquors",
            color = "#FBB117",
        ),
        MasterGroceryEntity(
            id = "7",
            title = "Kitchen Utilities",
            color = "#A0522D",
        ),
        MasterGroceryEntity(
            id = "8",
            title = "Cooking Essentials",
            color = "#C68642",
        ),
        MasterGroceryEntity(
            id = "9",
            title = "Bakery",
            color = "#D2691E",
        ),
        MasterGroceryEntity(
            id = "10",
            title = "Snacks",
            color = "#F4A460",
        ),
        MasterGroceryEntity(
            id = "11",
            title = "Soft Drinks",
            color = "#4682B4",
        ),
        MasterGroceryEntity(
            id = "12",
            title = "Frozen Goods",
            color = "#5F9EA0",
        ),
        MasterGroceryEntity(
            id = "13",
            title = "Beverages",
            color = "#3f6837",
        ),
    )

    val groceryItems = listOf(
        // Vegetables
        MasterGroceryItemEntity("1", "1", "Potato"),
        MasterGroceryItemEntity("2", "1", "Tomato"),
        MasterGroceryItemEntity("3", "1", "Spinach"),
        MasterGroceryItemEntity("19", "1", "Cauliflower"),
        MasterGroceryItemEntity("20", "1", "Broccoli"),
        MasterGroceryItemEntity("21", "1", "Zuchini (Squash)"),
        MasterGroceryItemEntity("22", "1", "Capsicum"),
        MasterGroceryItemEntity("23", "1", "Chayote"),
        MasterGroceryItemEntity("24", "1", "Bitter Gourd"),
        MasterGroceryItemEntity("25", "1", "Bottle Gourd"),
        MasterGroceryItemEntity("26", "1", "Eggplant"),
        MasterGroceryItemEntity("27", "1", "Red Raddish"),
        MasterGroceryItemEntity("28", "1", "Carrot"),
        MasterGroceryItemEntity("29", "1", "Cucumber"),
        MasterGroceryItemEntity("30", "1", "Okra"),
        MasterGroceryItemEntity("31", "1", "Green Chilly"),
        MasterGroceryItemEntity("32", "1", "Green Corainder"),
        MasterGroceryItemEntity("33", "1", "Spring Onion"),
        MasterGroceryItemEntity("34", "1", "Red Onion"),
        MasterGroceryItemEntity("35", "1", "White Onion"),
        MasterGroceryItemEntity("36", "1", "Garlic"),
        MasterGroceryItemEntity("37", "1", "Ginger"),
        MasterGroceryItemEntity("38", "1", "Cabbage"),
        MasterGroceryItemEntity("39", "1", "Ruccola"),
        MasterGroceryItemEntity("61", "1", "Celery"),
        MasterGroceryItemEntity("62", "1", "Lemon (Yellow)"),
        MasterGroceryItemEntity("63", "1", "Lime (Green)"),
        MasterGroceryItemEntity("64", "1", "Nappa Cabbage"),
        MasterGroceryItemEntity("65", "1", "Onion"),
        MasterGroceryItemEntity("66", "1", "Pointed Gourd"),
        MasterGroceryItemEntity("67", "1", "Salad Cabbage"),
        MasterGroceryItemEntity("69", "1", "Sivri"),
        MasterGroceryItemEntity("70", "1", "Olives"),
        MasterGroceryItemEntity("71", "1", "Squash"),
        MasterGroceryItemEntity("123", "1", "Sweet potatoes"),

        // Meat and Eggs
        MasterGroceryItemEntity("4", "2", "Chicken"),
        MasterGroceryItemEntity("5", "2", "Fish"),
        MasterGroceryItemEntity("41", "2", "Chicken Sausage"),
        MasterGroceryItemEntity("42", "2", "Pork"),
        MasterGroceryItemEntity("43", "2", "Mutton"),
        MasterGroceryItemEntity("44", "2", "Lamb"),
        MasterGroceryItemEntity("45", "2", "Chicken Wings"),
        MasterGroceryItemEntity("46", "2", "Chicken Breast"),
        MasterGroceryItemEntity("47", "2", "Chicken Thighs"),
        MasterGroceryItemEntity("48", "2", "Whole Chicken"),
        MasterGroceryItemEntity("124", "2", "Tuna"),
        MasterGroceryItemEntity("125", "2", "Eggs"),

        // Fruits
        MasterGroceryItemEntity("6", "3", "Apple"),
        MasterGroceryItemEntity("7", "3", "Banana"),
        MasterGroceryItemEntity("8", "3", "Mango"),
        MasterGroceryItemEntity("49", "3", "Cherry"),
        MasterGroceryItemEntity("50", "3", "Kiwi"),
        MasterGroceryItemEntity("51", "3", "Blueberry"),
        MasterGroceryItemEntity("52", "3", "Redberry"),
        MasterGroceryItemEntity("53", "3", "Strawberry"),
        MasterGroceryItemEntity("54", "3", "Pineapple"),
        MasterGroceryItemEntity("55", "3", "Avocado"),
        MasterGroceryItemEntity("57", "3", "Dragon fruit"),
        MasterGroceryItemEntity("58", "3", "Red Grapes"),
        MasterGroceryItemEntity("146", "3", "Green Grapes"), // FIXED duplicate ID
        MasterGroceryItemEntity("59", "3", "Orange"),
        MasterGroceryItemEntity("60", "3", "Watermelon"),

        // Cleaning & Hygiene
        MasterGroceryItemEntity("9", "4", "Detergent"),
        MasterGroceryItemEntity("10", "4", "Softner"),
        MasterGroceryItemEntity("11", "4", "Hand wash"),
        MasterGroceryItemEntity("12", "4", "Dishwasher tablets"),
        MasterGroceryItemEntity("74", "4", "Steel sponges"),
        MasterGroceryItemEntity("75", "4", "Gloves"),
        MasterGroceryItemEntity("76", "4", "Toilet Cleaning"),
        MasterGroceryItemEntity("77", "4", "Dishwash liquid"),
        MasterGroceryItemEntity("78", "4", "Dishwash sponges"),
        MasterGroceryItemEntity("79", "4", "Kitchen paper"),
        MasterGroceryItemEntity("80", "4", "Toilet paper"),
        MasterGroceryItemEntity("81", "4", "Soft towels (Kitchen)"),
        MasterGroceryItemEntity("82", "4", "Pink Stuff"),
        MasterGroceryItemEntity("84", "4", "Jif Cream"),
        MasterGroceryItemEntity("85", "4", "Body wash"),
        MasterGroceryItemEntity("86", "4", "Bathroom Spray"),
        MasterGroceryItemEntity("87", "4", "Kitchen Spray"),
        MasterGroceryItemEntity("88", "4", "Glass Spray"),
        MasterGroceryItemEntity("89", "4", "Parket cleaning liquid"),

        // Dairy & Bakery
        MasterGroceryItemEntity("13", "5", "Low Fat Milk"),
        MasterGroceryItemEntity("14", "5", "Whole Milk"),
        MasterGroceryItemEntity("90", "5", "Oats Milk"),
        MasterGroceryItemEntity("91", "5", "Whipped Cream"),
        MasterGroceryItemEntity("92", "5", "Sour Cream"),
        MasterGroceryItemEntity("93", "5", "Yeast"),
        MasterGroceryItemEntity("94", "5", "Greek yoghurt (Vanilla)"),
        MasterGroceryItemEntity("95", "5", "Cheese"),
        MasterGroceryItemEntity("96", "5", "Brown Cheese"),
        MasterGroceryItemEntity("97", "5", "Butter"),
        MasterGroceryItemEntity("98", "5", "Bread"),
        MasterGroceryItemEntity("99", "5", "Almond milk"),
        MasterGroceryItemEntity("126", "5", "Feta cheese"),

        // Liquors
        MasterGroceryItemEntity("15", "6", "Beer"),
        MasterGroceryItemEntity("16", "6", "Red Wine"),
        MasterGroceryItemEntity("17", "6", "White Wine"),
        MasterGroceryItemEntity("18", "6", "Whisky"),

        // Kitchen Utilities
        MasterGroceryItemEntity("100", "7", "Baking paper"),
        MasterGroceryItemEntity("101", "7", "Aluminium foil"),
        MasterGroceryItemEntity("102", "7", "Plastic Wrap"),
        MasterGroceryItemEntity("103", "7", "Zip lock plastic bags"),
        MasterGroceryItemEntity("104", "7", "Freezer plastic bags"),

        // Cooking Essentials
        MasterGroceryItemEntity("105", "8", "Black Chickpeas"),
        MasterGroceryItemEntity("106", "8", "White Chickpeas"),
        MasterGroceryItemEntity("108", "8", "Salt"),
        MasterGroceryItemEntity("109", "8", "Apple Cider Vinegar"),
        MasterGroceryItemEntity("110", "8", "Biryani Masala"),
        MasterGroceryItemEntity("111", "8", "Black Pepper"),
        MasterGroceryItemEntity("112", "8", "Brown Sugar"),
        MasterGroceryItemEntity("113", "8", "Coffee"),
        MasterGroceryItemEntity("114", "8", "Cooking Oil"),
        MasterGroceryItemEntity("115", "8", "Coriander Seeds"),
        MasterGroceryItemEntity("116", "8", "Dried Chilli"),
        MasterGroceryItemEntity("117", "8", "Vanilla Sugar"),
        MasterGroceryItemEntity("118", "8", "Vegetable Oil"),
        MasterGroceryItemEntity("119", "8", "Balsamic Vinegar"),
        MasterGroceryItemEntity("120", "8", "Red Dal"),
        MasterGroceryItemEntity("121", "8", "Basmati Rice"),
        MasterGroceryItemEntity("122", "8", "Toor Dal"),
        MasterGroceryItemEntity("147", "8", "Olive Oil"), // FIXED duplicate ID

        // Bakery
        MasterGroceryItemEntity("127", "9", "Bread"),

        // Snacks
        MasterGroceryItemEntity("128", "10", "Biscuits High Fiber"),
        MasterGroceryItemEntity("129", "10", "Digestive Biscuits"),
        MasterGroceryItemEntity("130", "10", "Pani Poori"),
        MasterGroceryItemEntity("131", "10", "Peanuts"),
        MasterGroceryItemEntity("132", "10", "Pistachio Nuts"),
        MasterGroceryItemEntity("133", "10", "Ramen Noodles"),
        MasterGroceryItemEntity("134", "10", "Taco Sauce"),
        MasterGroceryItemEntity("135", "10", "Tortilla Wrap"),
        MasterGroceryItemEntity("136", "10", "Sriracha"),

        // Soft Drinks
        MasterGroceryItemEntity("137", "11", "Juice"),
        MasterGroceryItemEntity("138", "11", "Cola"),

        // Frozen Goods
        MasterGroceryItemEntity("139", "12", "Gyoza Wrapper"),
        MasterGroceryItemEntity("140", "12", "Potato Chips"),
        MasterGroceryItemEntity("141", "12", "Frozen Potato"),

        // Beverages
        MasterGroceryItemEntity("142", "13", "Chamomile Tea"),
        MasterGroceryItemEntity("143", "13", "Green Tea"),
        MasterGroceryItemEntity("144", "13", "Ginger Tea"),
        MasterGroceryItemEntity("145", "13", "Coffee"),
    )
}
