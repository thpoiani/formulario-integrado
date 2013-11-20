package formulario.integrado.model;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class Model implements IModel {

    private ArrayList<String> errors;

    public abstract boolean validate();

    public Model() {
        this.errors = new ArrayList<String>();
    }
    
    public Iterator createErrorIterator() {
        return this.getErrors().iterator();
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
