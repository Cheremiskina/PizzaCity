class PizzaKirov(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double, sicilianPizzaPrice: Double,tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), Drink, CheckPhoto, Sauce {
    override fun drinkSale(pizzaType: String) {
        println("Вы будете кофе?")
        coffeeOffers++

        while (true) {
            println("1. Да\n2. Нет")
            when (readln()) {
                "1" -> {
                    println("С вас $drinkPrice рублей")
                    drinksCount++
                    drinksRevenue += drinkPrice

                    when (pizzaType) {
                        "neapolitan" -> coffeeWithNeapolitan++
                        "roman" -> coffeeWithRoman++
                        "sicilian" -> coffeeWithSicilian++
                        "tyrolean" -> coffeeWithTyrolean++
                    }
                    break
                }
                "2" -> {
                    break
                }
                else -> {
                    println("Ошибка: введите 1 или 2")
                }
            }
        }
    }
    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        showCheckOffers++

        while (true) {
            println("1. Да\n2. Нет")
            when (readln()) {
                "1" -> {
                    println("У вас будет скидка $discountValue рублей с покупки")
                    discountCount++
                    totalDiscount += discountValue
                    break
                }
                "2" -> {
                    break
                }
                else -> {
                    println("Ошибка: введите 1 или 2")
                }
            }
        }
    }
    override fun chooseSauce() {
        println("Выберите соус к пицце:")
        while (true) {
            println("1. Соус 1 ($sauce1Price рублей)\n2. Соус 2 ($sauce2Price рублей)\n3. Без соуса")
            when (readln()) {
                "1" -> {
                    println("Вы выбрали Соус 1")
                    sauceRevenue += sauce1Price
                    sauce1Count++
                    break
                }
                "2" -> {
                    println("Вы выбрали Соус 2")
                    sauceRevenue += sauce2Price
                    sauce2Count++
                    break
                }
                "3" -> {
                    break
                }
                else -> println("Ошибка: введите 1 или 2")
            }
        }
    }
    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }
    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }
    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }
    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }

}