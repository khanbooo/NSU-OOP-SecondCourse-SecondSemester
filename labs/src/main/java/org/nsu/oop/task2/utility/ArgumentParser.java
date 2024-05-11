package org.nsu.oop.task2.utility;

public class ArgumentParser {
    private String filename = null;
    private String error = null;
    private Boolean isValid = false;

    public ArgumentParser(String[] args){
        this.parse(args);
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void parse(String[] args){
        if (args.length > 1){
            setError("invalid input");
            return;
        } else if (args.length == 1) {
            setFilename(args[0]);
        }
        setValid(true);
    }
}
