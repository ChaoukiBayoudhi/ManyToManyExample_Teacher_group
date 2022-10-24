package tn.esb.bis.ManyToManyExample;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull //for the java programming
    @Column(nullable = false) //nullable = false <=> NOT NULL in SQL
    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private String familyName;
    private String grade;

    @ManyToMany
    //create the association table:
    @JoinTable(name = "planning",
    )
    private List<GroupStudents> groups=new ArrayList<>();
}
