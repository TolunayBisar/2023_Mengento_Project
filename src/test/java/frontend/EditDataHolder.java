package frontend;

import basefunc.FunctionLibray;

public class EditDataHolder {
    public EditDataHolder() {
    }
    private static String email=FunctionLibray.generateFakeEmail();

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        EditDataHolder.email = email;
    }
}
