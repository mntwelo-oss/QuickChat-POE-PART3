
package com.mycompany.poe1;


public class Login {

private String firstName;
private String lastName;
private String username;
private String password;
private String cellPhoneNumber;

public Login(String firstName, String lastName,
String username, String password,
String cellPhoneNumber) {

this.firstName = firstName;
this.lastName = lastName;
this.username = username;
this.password = password;
this.cellPhoneNumber = cellPhoneNumber;
}

public boolean checkUserName() {
return username.contains("_")
&& username.length() <= 5;
}

public boolean checkPasswordComplexity() {
return password.length() >= 8
&& password.matches(".*[A-Z].*")
&& password.matches(".*[0-9].*")
&& password.matches(".*[^a-zA-Z0-9].*");
}

public boolean checkCellPhoneNumber() {
return cellPhoneNumber.matches("\\+27[0-9]{9}");
}

public String registerUser() {

if (!checkUserName()) {
return "Username is not correctly formatted.";                  
}

if (!checkPasswordComplexity()) {
return "Password is not correctly formatted.";
}

if (!checkCellPhoneNumber()) {
return "Cell phone number is incorrectly formatted.";
}

return "User registered successfully.";
}

public boolean loginUser(String enteredUsername,
String enteredPassword) {

return username.equals(enteredUsername)
&& password.equals(enteredPassword);
}

public String returnLoginStatus(boolean loggedIn) {

if (loggedIn) {
return "Welcome " + firstName + ", "
+ lastName
+ " it is great to see you again.";
}

return "Username or password incorrect, please try again.";
}
}
