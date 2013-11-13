package formulario.integrado.model;

import java.util.ArrayList;
import org.apache.commons.lang3.builder.ToStringBuilder;

abstract class Model implements IModel {

    private ArrayList<String> errors;

    public abstract boolean validate();

    public Model() {
        this.errors = new ArrayList<String>();
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return validate();
    }

    /**
     * @return the errors
     */
    public ArrayList<String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void addErrors(String error) {
        this.errors.add(error);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
