/*
 * The MIT License
 *
 * Copyright 2017 Andrey.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.wolf.jcadv.lesson1.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author Andrey
 */
public class LocalSamples {

        public static void create() {
                // Текущие дата и время
                LocalDateTime timePoint = LocalDateTime.now();
                System.out.println(timePoint);

                // с значениями год, месяц и день
                LocalDate date = LocalDate.of(2012, Month.DECEMBER, 12);
                System.out.println(date);

                // с значениями год, день года
                LocalDate ofYearDay = LocalDate.ofYearDay(2017, 256);
                System.out.println(ofYearDay);

                // с значениями часов, минут
                LocalTime time = LocalTime.of(17, 18);
                System.out.println(time);

                // из строки
                LocalTime timeParsed = LocalTime.parse("10:15:30");
                System.out.println(timeParsed);
        }

        public static void usefulMethods() {
                // Получаем текущую дату и время
                LocalDateTime currentTime = LocalDateTime.now();
                System.out.println("Теукщая DateTime: " + currentTime);

                LocalDate date1 = currentTime.toLocalDate();
                System.out.println("Дата и время1: " + date1);

                Month month = currentTime.getMonth();
                int day = currentTime.getDayOfMonth();
                int seconds = currentTime.getSecond();

                System.out.println("Месяц: " + month + " день: " + day + " секунд: " + seconds);

                LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
                System.out.println("Дата и время2: " + date2);
        }

        public void zonedDateTime() {
                // Ntreofz 
                ZonedDateTime date = ZonedDateTime.now();
                System.out.println("Дата и : " + date);

                ZoneId id = ZoneId.of("Europe/Paris");
                System.out.println("Часовой пояс : " + id);                                

                ZoneId currentZone = ZoneId.systemDefault();
                System.out.println("Часовой пояс по умолчанию: " + currentZone);
        }

        public static void main(String[] args) {
                create();
        }

}
