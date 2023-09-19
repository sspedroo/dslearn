package com.devsuperior.dslearn.domain.resource.model;

import com.devsuperior.dslearn.domain.offer.model.Offer;
import com.devsuperior.dslearn.domain.resource.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "tb_resource")
@Table(name = "tb_resource")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String description;
    private Integer position;
    @Lob
    private String imgUri;
    private ResourceType type;
    private String externalLink;

    @ManyToOne()
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(id, resource.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
