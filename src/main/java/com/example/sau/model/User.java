package com.example.sau.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
//    @Column(nullable = false)
//    private String firstname;
//    private String lastname;
    @Column(nullable = false, unique = true)

    private String email;
    private String password;
    @Column(nullable = false, unique = true)
    private String username;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private List<Role> roles;

@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
private Cart cart;

    public User(Long id, String username, String password, String email) {
    }
}
