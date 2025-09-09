package src

abstract class PizzaCity(val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
                         val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double) {
    protected var neapolitanPizzaCount = 0
    protected var romanPizzaCount = 0
    protected var sicilianPizzaCount = 0
    protected var tyroleanPizzaCount = 0

    protected var discountCount = 0
    protected var totalDiscount = 0.0
    protected var discountValue = 50

    protected var drinksCount = 0
    protected var drinkPrice = 200.0
    protected var drinksRevenue = 0.0

    protected var showCheckOffers = 0
    protected var coffeeOffers = 0

    protected var coffeeWithNeapolitan = 0
    protected var coffeeWithRoman = 0
    protected var coffeeWithSicilian = 0
    protected var coffeeWithTyrolean = 0

    protected var sauce1Price = 30.0
    protected var sauce2Price = 40.0
    protected var sauceRevenue = 0.0
    protected var sauce1Count = 0
    protected var sauce2Count = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    open fun showStatistics() {
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        val pizzaRevenue = neapolitanPizzaCount * neapolitanPizzaPrice + sicilianPizzaCount * sicilianPizzaPrice +
                romanPizzaCount * romanPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice

        val revenue = pizzaRevenue + drinksRevenue + sauceRevenue - totalDiscount

        println("\nВыручка по пиццерии: $revenue")

        if (this is CheckPhoto && showCheckOffers > 0) {
            println("\nКоличество показанных чеков: $discountCount")
            println("Общая сумма скидок: $totalDiscount")

            val percentWithCheck = discountCount.toDouble() / showCheckOffers * 100
            val percentWithoutCheck = 100 - percentWithCheck
            println("Процент клиентов с чеком: ${"%.2f".format(percentWithCheck)}%")
            println("Процент клиентов без чека: ${"%.2f".format(percentWithoutCheck)}%")
        }

        if (this is Drink && coffeeOffers > 0) {
            val percentWithCoffee = drinksCount.toDouble() / coffeeOffers * 100
            val percentWithoutCoffee = 100 - percentWithCoffee
            println("\nПроцент клиентов, купивших кофе: ${"%.2f".format(percentWithCoffee)}%")
            println("Процент клиентов, отказавшихся от кофе: ${"%.2f".format(percentWithoutCoffee)}%")

            println("\nСтатистика заказа кофе к пиццам:")
            val totalCoffeeWithPizza = coffeeWithNeapolitan + coffeeWithRoman +
                    coffeeWithSicilian + coffeeWithTyrolean
            if (totalCoffeeWithPizza > 0) {
                fun percent(part: Int) = part.toDouble() / totalCoffeeWithPizza * 100
                println("К неаполитанской пицце: $coffeeWithNeapolitan (${"%.2f".format(percent(coffeeWithNeapolitan))}%)")
                println("К римской пицце: $coffeeWithRoman (${"%.2f".format(percent(coffeeWithRoman))}%)")
                println("К сицилийской пицце: $coffeeWithSicilian (${"%.2f".format(percent(coffeeWithSicilian))}%)")
                println("К тирольской пицце: $coffeeWithTyrolean (${"%.2f".format(percent(coffeeWithTyrolean))}%)")
            }
        }

        if (this is Sauce && (sauce1Count > 0 || sauce2Count > 0)){
            println("\nПродано соусов:")
            if (sauce1Count > 0) {
                println("Соус 1: $sauce1Count шт., выручка: ${sauce1Count * sauce1Price}")
            }
            if (sauce2Count > 0) {
                println("Соус 2: $sauce2Count шт., выручка: ${sauce2Count * sauce2Price}")
            }
        }
    }
}