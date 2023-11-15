package pl.pwr.ite.client.view.model;

import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.client.model.dto.RegistrationDto;

@Getter
@Setter
public class ManagerRegistrationTableDataModel {

    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty userId = new SimpleStringProperty("");
    private final SimpleStringProperty status = new SimpleStringProperty("");
    private final SimpleStringProperty time = new SimpleStringProperty("");
    private final RegistrationDto registration;

    public ManagerRegistrationTableDataModel(RegistrationDto registration) {
        this.registration = registration;
        this.setId(registration.getId().toString());
        this.setStatus(registration.getStatus().toString());
        this.setTime(registration.getTime().toString());
        this.setUserId(registration.getUser().getId().toString());
    }

    public String getUserId() {
        return userId.get();
    }

    public SimpleStringProperty userIdProperty() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId.set(userId);
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
