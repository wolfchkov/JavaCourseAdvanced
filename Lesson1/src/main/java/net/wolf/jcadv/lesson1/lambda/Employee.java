/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson1.lambda;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Сотрудник компании
 *
 * @author Andrey
 */
public class Employee {

        public enum Sex {
                MALE, FEMALE
        }

        private final String name;
        private final LocalDate birthday;
        private final Sex gender;
        private String emailAddress;

        public Employee(String name, LocalDate birthday, Sex gender, String emailAddress) {
                this.name = name;
                this.birthday = birthday;
                this.gender = gender;
                this.emailAddress = emailAddress;
        }

        public String getName() {
                return name;
        }

        public LocalDate getBirthday() {
                return birthday;
        }

        public int getAge() {
                return Period.between(birthday, LocalDate.now()).getYears();
        }

        public Sex getGender() {
                return gender;
        }

        public void setEmailAddress(String emailAddress) {
                this.emailAddress = emailAddress;
        }

        public String getEmailAddress() {
                return emailAddress;
        }

        @Override
        public int hashCode() {
                int hash = 5;
                hash = 97 * hash + Objects.hashCode(this.name);
                hash = 97 * hash + Objects.hashCode(this.birthday);
                hash = 97 * hash + Objects.hashCode(this.gender);
                return hash;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj) {
                        return true;
                }
                if (obj == null) {
                        return false;
                }
                if (getClass() != obj.getClass()) {
                        return false;
                }
                final Employee other = (Employee) obj;
                if (!Objects.equals(this.name, other.name)) {
                        return false;
                }
                if (!Objects.equals(this.birthday, other.birthday)) {
                        return false;
                }
                if (this.gender != other.gender) {
                        return false;
                }
                return true;
        }

        public void print() {
                System.out.println("===================Employee================");
                System.out.format("Name : %s%n", name);
                System.out.format("Birthday : %s%n", birthday);
                System.out.format("Gender : %s%n", gender);
                System.out.format("Email : %s%n", emailAddress);
                System.out.println("---------------------------------------------------------------------------");
        }

        @Override
        public String toString() {
                return "Employee{" + "name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", emailAddress=" + emailAddress + '}';
        }
        
        

        public static int compareByAge(Employee a, Employee b) {
                return a.birthday.compareTo(b.birthday);
        }

        public static List<Employee> getEmpoyees() {
                return Arrays.asList(
                        new Employee("Yann", LocalDate.of(1986, Month.JULY, 15), Employee.Sex.MALE, "yann@gmail.com"),
                        new Employee("Glotia", LocalDate.of(1955, Month.JANUARY, 13), Employee.Sex.FEMALE, "glotia1@gmail.com"),
                        new Employee("John", LocalDate.of(1978, Month.NOVEMBER, 2), Employee.Sex.MALE, "john@gmail.com"),
                        new Employee("Susann", LocalDate.of(1989, Month.AUGUST, 20), Employee.Sex.FEMALE, "susann@gmail.com"),
                        new Employee("Anne", LocalDate.of(1979, Month.JULY, 30), Employee.Sex.FEMALE, "anne@gmail.com"),
                        new Employee("Brenda", LocalDate.of(1991, Month.APRIL, 1), Employee.Sex.FEMALE, "brenda@gmail.com"),
                        new Employee("Brain", LocalDate.of(1992, Month.SEPTEMBER, 17), Employee.Sex.MALE, "brain@gmail.com"),
                        new Employee("John", LocalDate.of(1982, Month.AUGUST, 1), Employee.Sex.MALE, "John2@gmail.com"),
                        new Employee("Barbara", LocalDate.of(1985, Month.FEBRUARY, 7), Employee.Sex.FEMALE, "barbara@gmail.com"),
                        new Employee("Carl", LocalDate.of(1988, Month.MAY, 4), Employee.Sex.MALE, "carl@gmail.com"),
                        new Employee("Glotia", LocalDate.of(1984, Month.JULY, 29), Employee.Sex.FEMALE, "glotia@gmail.com"),
                        new Employee("Gerald", LocalDate.of(1961, Month.NOVEMBER, 17), Employee.Sex.MALE, "gerald@gmail.com")
                );
        }
}
