/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.javacourseadv.lesson1.lambda;

/**
 *
 * @author Andrey
 */
public class CheckEmployeeEligibleForSelectiveService implements CheckEmployee {

        @Override
        public boolean test(Employee empl) {
                return empl.getGender() == Employee.Sex.MALE
                        && empl.getAge() >= 18
                        && empl.getAge() <= 25;
        }

}
