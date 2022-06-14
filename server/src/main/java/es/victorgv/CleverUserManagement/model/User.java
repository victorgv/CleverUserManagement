package es.victorgv.CleverUserManagement.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "user_id_generator")
    @SequenceGenerator(name="user_id_generator", sequenceName = "user_seq")
    private Long userId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String userName;

}
