/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TuanTA
 */
public class ToolCheckInput {

    public static boolean checkInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean checkFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean checkPhoneNumber(String s) {
        Pattern pattern = Pattern.compile("[0-9]{6,10}");
        Matcher m = pattern.matcher(s);
        return m.matches();
    }

    public static boolean checkLengthPassword(String s) {
        return s.length() > 5;
    }

    public static boolean checkIDCard(String s) {
        Pattern pattern = Pattern.compile("[0-9]{6,12}");
        Matcher m = pattern.matcher(s);
        return m.matches();
    }
}
