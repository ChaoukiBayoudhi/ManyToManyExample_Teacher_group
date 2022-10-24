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
    @JoinTable(name = "planning", //"planning" is the name of the association table on the database
            joinColumns = @JoinColumn(name="teacher_id",referencedColumnName = "id"), //"teacher_id" is the name of the first foreign key
            inverseJoinColumns = @JoinColumn(name="group_students_id",referencedColumnName = "id") //"group_students_id" is the name of the second foreign key

    )
    private List<GroupStudents> groups=new ArrayList<>();
}
