package pl.pwr.ite.client.view.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.client.model.dto.TreeDto;

@Getter
@Setter
public class TreeTableDataModel {

    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleDoubleProperty diameter = new SimpleDoubleProperty(0.0);
    private final TreeDto tree;

    public TreeTableDataModel(TreeDto tree) {
        this.setName(tree.getName());
        this.setDiameter(tree.getDiameter());
        this.tree = tree;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getDiameter() {
        return diameter.get();
    }

    public SimpleDoubleProperty diameterProperty() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter.set(diameter);
    }
}
