package src

class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double, sicilianPizzaPrice: Double,tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {
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