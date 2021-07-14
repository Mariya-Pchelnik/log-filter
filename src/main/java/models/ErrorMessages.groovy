package models

enum ErrorMessages {

    INVALID_DIRECTORY("Directory wasn't found: "),
    NO_FILES("Files with .log extension were not found"),
    NO_RECORDS("No log records were found")
    private String message;

    EnumErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}