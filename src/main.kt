package src

fun main(){
    val pizzaPeter = PizzaPeter(175.0, 241.5, 167.5, 215.0)
    val pizzaMoscow = PizzaMoscow(215.0, 250.5, 180.5, 240.0)
    val pizzaKirov = PizzaKirov(200.0, 230.0, 180.0, 220.0)
    var currentPizzaCity: PizzaCity

    while (true){
        println("\nДобрый день! Выберете город")
        println("1. Москва\n2. Санкт-Петербург\n3. Киров\n\n0. Выход из программы")

        currentPizzaCity = when (readln()){
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaKirov
            "0" -> break
            else -> {
                println("Ошибка: выберите 1, 2, 3 или 0")
                continue
            }
        }
        println("Выберете пиццу:")
        println("1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n4. Тирольская пицца\n\n0. Показать статистику")
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    while (true) {
        when (readln()) {
            "1" -> {
                currentPizzaCity.neapolitanPizzaSale()
                selectAddService(currentPizzaCity, "neapolitan")
                break
            }
            "2" -> {
                currentPizzaCity.romanPizzaSale()
                selectAddService(currentPizzaCity, "roman")
                break
            }
            "3" -> {
                currentPizzaCity.sicilianPizzaSale()
                selectAddService(currentPizzaCity, "sicilian")
                break
            }
            "4" -> {
                currentPizzaCity.tyroleanPizzaSale()
                selectAddService(currentPizzaCity, "tyrolean")
                break
            }
            "0" -> {
                currentPizzaCity.showStatistics()
                break
            }
            else -> {
                println("Ошибка: неверный ввод. Пожалуйста, выберите пиццу заново:")
                println("1. Неаполитанская\n2. Римская\n3. Сицилийская\n4. Тирольская\n0. Показать статистику")
            }
        }
    }
}

fun selectAddService(currentPizzaCity: PizzaCity, pizzaType: String){
    when (currentPizzaCity) {
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
    }
    when (currentPizzaCity) {
        is Drink -> currentPizzaCity.drinkSale(pizzaType)
    }
    when (currentPizzaCity) {
        is Sauce -> currentPizzaCity.chooseSauce()
    }
}