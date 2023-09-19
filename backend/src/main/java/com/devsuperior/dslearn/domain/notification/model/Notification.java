package com.devsuperior.dslearn.domain.notification.model;

import com.devsuperior.dslearn.domain.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_notification")
@Table(name = "tb_notification")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Instant moment;
    private Boolean read = false;
    private String route;

    @OneToMany(mappedBy = "notifications")
    private List<User> user = new ArrayList<>();
}
