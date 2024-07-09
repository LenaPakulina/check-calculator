# Консольное приложение, реализующее функционал формирования чека в магазине

Это консольное приложение на Java генерирует чек для магазина на основе предоставленных 
идентификаторов продуктов, количества, скидочных карт и остатков по дебетовым картам. 
Ниже будет подробное описание входных и выходных параметров.

***Слабонервным не смотреть, проект без использования Spring***

## Инструменты
Убедитесь, что у вас установлено следующее:

Java (версия 17 или выше)

## Запуск

1. Склонируйте репозиторий:
```bash
git clone https://github.com/LenaPakulina/check-calculator
 ```
2. Скомпилируйте проект:
```bash
javac -d out -cp src src/main/java/ru/clevertec/check/*.java
 ```
Примечание: Вы должны выполнить эту команду из каталога check-calculator. 
Скомпилированные классы будут расположены в папке out. 
Флаг -cp указывает, где найти все исходные файлы.
3. Запуск приложения:
```bash
java -cp out ./src/main/java/ru/clevertec/check/CheckRunner.java id-quantity discountCard=xxxx balanceDebitCard=xxxx
```
Note:
1. id - идентификатор продукта (смотри [таблицу продуктов](./src/main/resources/products.csv))
2. quantity - количество товара
3. discountCard=xxxx - номер и название дисконтной карты магазина (смотри [таблицу дисконтных карт](./src/main/resources/discountCards.csv)). 
Карта может отсутствовать. В случае, если карта, представленная покупателем отсутствует в таблице, нужно предоставить 2% скидки. 
Помимо этого, среди товаров, предусмотрены оптовые (смотри [таблицу продуктов](./src/main/resources/products.csv), колонка wholesale product). 
Если в чеке, в оптовой позиции пять и более товаров, то сделать скидку 10% по этой позиции (если применяется оптовая скидка 10% на 
позицию, то на данную позицию не действует персональная скидка по карте, например 3%). Данную информацию отразить в чеке
4. balanceDebitCard=xxxx - баланс дебетовой карты, с которой будет осуществляться покупка

- Результат запуска программ осуществляется в консоль + в файл ***./src/main/result.csv***

## Важно учесть

**Входные идентификаторы продуктов могут повторяться: 1-3 2-5 1-1 означает то же, что и 1-4 2-5.**
**balanceDebitCard=xxxx, где xxxx - для числа с плавающей точкой разделитель точка. Пример: 1.12**

## Пример работы программы

Пример параметров для запуска приложения:
```bash
java -cp out ./src/main/java/ru/clevertec/check/CheckRunner.java 13-1 9-1 4-30 13-2 1-6 13-2 discountCard=1111 balanceDebitCard=100
```
Файл вывода:
``` 
Date;Time                                
09.07.2024;11:01:24                      
                                         
QTY;DESCRIPTION;PRICE;DISCOUNT;TOTAL     
6;Milk;1,07$;0,64$;6,42$                 
30;Packed potatoes 1kg;1,47$;1,32$;44,10$
1;Packed bananas 1kg;1,10$;0,03$;1,10$   
5;Baguette 360g;1,30$;0,65$;6,50$

DISCOUNT CARD;DISCOUNT PERCENTAGE
1111;3

TOTAL PRICE;TOTAL DISCOUNT;TOTAL WITH DISCOUNT
58,12$;2,64$;55,48$
```

Где:
Date - Дата генерации файла
Time - Время генерации файла
QTY - Количество заказанного товара
DESCRIPTION - Название заказанного товара
PRICE - Цена за 1шт.
TOTAL - Итоговая цена без скидки
DISCOUNT - Скидка на итоговую цену товара 

При наличии карты:
DISCOUNT CARD - Номер скидочной карты
DISCOUNT PERCENTAGE - Процент скидки по карте

TOTAL PRICE - Итоговая цена за все товары (TOTAL 1 + TOTAL 2 + …)
TOTAL DISCOUNT - Итоговая скидка на все товары (DISCOUNT 1 + DISCOUNT 2 + …)
TOTAL WITH DISCOUNT - Итоговая стоимость (TOTAL PRICE - TOTAL DISCOUNT)

ВАЖНО! Значения разделяются: “;”
ВАЖНО! Значения с плавающей точкой пишутся через точку
ВАЖНО! Все значения имеющие $ в конце пишутся до 2 знаков после запятой

Запустим программу с наличием ошибки: 
```bash
java -cp out ./src/main/java/ru/clevertec/check/CheckRunner.java 3-1 2-5 5-1 discountCard=1111 balanceDebitCard=1.23
```
Файл вывода:
``` 
ERROR
NOT ENOUGH MONEY
```

Еще несколько примеров расчета: 
```bash
java -cp out ./src/main/java/ru/clevertec/check/CheckRunner.java 13-1 9-1 4-30 13-2 1-6 13-2 balanceDebitCard=90.09
```
Файл вывода:
``` 
Date;Time
09.07.2024;11:02:09

QTY;DESCRIPTION;PRICE;DISCOUNT;TOTAL
6;Milk;1,07$;0,64$;6,42$
30;Packed potatoes 1kg;1,47$;0,00$;44,10$
1;Packed bananas 1kg;1,10$;0,00$;1,10$
5;Baguette 360g;1,30$;0,65$;6,50$

TOTAL PRICE;TOTAL DISCOUNT;TOTAL WITH DISCOUNT
58,12$;1,29$;56,83$
```
