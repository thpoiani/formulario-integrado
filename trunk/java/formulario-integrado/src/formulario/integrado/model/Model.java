package formulario.integrado.model;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class Model implements IModel {

    private ArrayList<String> errors;
    
    public Model() {
        this.errors = new ArrayList<>();
    }

    public Iterator<String> createErrorIterator() {
        return this.getErrors().iterator();
    }

    /**
     * @return the valid
     */
    @Override
    public boolean isValid() {
        return validate();
    }

    /**
     * @return the errors
     */
    @Override
    public ArrayList<String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    @Override
    public void addErrors(String error) {
        this.errors.add(error);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    @Override
    public int getId(){
        throw new UnsupportedOperationException();
    }
}
