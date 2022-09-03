package br.com.bright.chefbot.core.dto;

public class AutoCompleteDTO {
    private String label;
    private String value;

    @Deprecated
    private AutoCompleteDTO(){}

    public AutoCompleteDTO(String label, Long value){
        this.label = label;
        this.value = Long.toString(value);
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
