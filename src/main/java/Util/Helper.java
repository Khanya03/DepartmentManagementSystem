package Util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {
      public static boolean isNullOrEmpty(String s){
         return  s == null || s.isEmpty();
      }

      public static boolean isValidEmail(String email){
          EmailValidator validator = EmailValidator.getInstance();
          return validator.isValid(email);
      }

      public static boolean isValidPhone(String phone){
          String regex = "^\\d{10}$";
          return phone != null && phone.matches(regex);
      }
    public static String generateDepartmentCode(String departmentName) {
        if (isNullOrEmpty(departmentName)) return null;
        StringBuilder code = new StringBuilder();
        String[] words = departmentName.trim().split(" ");
        for (String word : words) {
            if (!word.isEmpty()) {
                code.append(Character.toUpperCase(word.charAt(0)));
            }
        }
        return code.toString();
    }
}
