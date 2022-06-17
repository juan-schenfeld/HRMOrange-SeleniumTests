package dto;

public class AddEmployeeDataBuilder {

    private AddEmployeeData data;


    public AddEmployeeDataBuilder() {
        data = new AddEmployeeData();
    }


    public AddEmployeeDataBuilder firstname(String value) {
        data.setFirstname(value);
        return this;
    }

    public AddEmployeeDataBuilder middlename(String value) {
        data.setMiddlename(value);
        return this;
    }

    public AddEmployeeDataBuilder lastname(String value) {
        data.setLastname(value);
        return this;
    }

    public AddEmployeeDataBuilder id(String value) {
        data.setId(value);
        return this;
    }

    public AddEmployeeDataBuilder photoPath(String value) {
        data.setPhotographPath(value);
        return this;
    }

    public AddEmployeeDataBuilder addCredentials() {
        data.setWithCredentials(true);
        return this;
    }

    public AddEmployeeDataBuilder password(String value) {
        data.setPassword(value);
        return this;
    }

    public AddEmployeeDataBuilder confirmPassword(String value) {
        data.setConfirmPassword(value);
        return this;
    }

    public AddEmployeeDataBuilder username(String value) {
        data.setUsername(value);
        return this;
    }

    public AddEmployeeDataBuilder disableAccount() {
        data.setDisabled(true);
        return this;
    }

    public AddEmployeeData build() {
        return data;
    }


}
