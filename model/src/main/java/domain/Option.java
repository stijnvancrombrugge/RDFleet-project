package domain;


import javax.persistence.*;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String optionName;

    //other variables


    public Option(String optionName) {
        this.optionName = optionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
