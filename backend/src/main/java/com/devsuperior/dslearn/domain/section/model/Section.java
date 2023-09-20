package com.devsuperior.dslearn.domain.section.model;

import com.devsuperior.dslearn.domain.resource.model.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "tb_section")
@Table(name = "tb_section")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String description;
    private Integer position;
    @Lob
    private String imgUri;

    @ManyToOne()
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @ManyToOne()
    @JoinColumn(name = "prerequisite_id")
    private Section prerequisite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(id, section.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
