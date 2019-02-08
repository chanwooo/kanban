package me.chan.kanban.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    private String name;

/*    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "board")
    private List<Section> sections = new ArrayList<>();

    public void addSection(String sectionName){
        sections.add(Section.builder().name(sectionName).build());
    }
*/
}
