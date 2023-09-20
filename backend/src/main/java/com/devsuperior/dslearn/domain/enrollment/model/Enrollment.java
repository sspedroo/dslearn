package com.devsuperior.dslearn.domain.enrollment.model;

import com.devsuperior.dslearn.domain.enrollment.pk.EnrollmentPK;
import com.devsuperior.dslearn.domain.offer.model.Offer;
import com.devsuperior.dslearn.domain.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "tb_enrollment")
@Table(name = "tb_enrollment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Enrollment {
    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment = null;
    private boolean availiable = true;
    private boolean onlyUpdate;

    public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean availiable, boolean onlyUpdate){
        this.id.setUser(user);
        this.id.setOffer(offer);
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.availiable = availiable;
        this.onlyUpdate = onlyUpdate;
    }

    public User getStudent(){
        return this.id.getUser();
    }
    public void setStudent(User user){
        this.id.setUser(user);
    };
    public Offer getOffer(){
        return this.id.getOffer();
    }

    public void setOffer(Offer offer){
        this.id.setOffer(offer);
    }
}
