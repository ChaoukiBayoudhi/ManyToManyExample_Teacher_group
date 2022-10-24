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
public class GroupStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull //for the java programming
    @Column(unique = true, nullable = false) //nullable = false <=> NOT NULL in SQL
    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private int studyLevel;
    private int studentsNumber;

    @ManyToMany(mappedBy = "groups")//mappedBy ===> the two attributes groups (declared in Teacher class) and lstTeachers are provided by the same relationship
    private List<Teacher> lstTeachers=new ArrayList<>();
}
