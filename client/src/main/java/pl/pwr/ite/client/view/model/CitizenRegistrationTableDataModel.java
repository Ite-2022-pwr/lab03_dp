package pl.pwr.ite.client.view.model;

import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.client.model.dto.RegistrationDto;

@Getter
@Setter
public class CitizenRegistrationTableDataModel {

    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty status = new SimpleStringProperty("");
    private final SimpleStringProperty time = new SimpleStringProperty("");
    private final RegistrationDto registration;

    public CitizenRegistrationTableDataModel(RegistrationDto registration) {
        this.registration = registration;
        this.setId(registration.getId().toString());
        this.setStatus(registration.getStatus().toString());
        this.setTime(registration.getTime().toString());
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public RegistrationDto getRegistration() {
        return registration;
    }
}
