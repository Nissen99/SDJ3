package shared;

import java.io.Serializable;

public class TransferObject implements Serializable {
    private String type;
    private Object contents;


    public TransferObject(String type, Object contents) {
        this.type = type;
        this.contents = contents;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object contents) {
        this.contents = contents;
    }
}
