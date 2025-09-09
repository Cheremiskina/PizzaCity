class PizzaMoscow(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double, sicilianPizzaPrice: Double,tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto {
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
    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }
    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }
    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }
    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }

}