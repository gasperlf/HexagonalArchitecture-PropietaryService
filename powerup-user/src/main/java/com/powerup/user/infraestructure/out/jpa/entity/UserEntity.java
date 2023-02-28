package com.powerup.user.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;
    @Column(name = "phone", nullable = false, length = 13)
    private String phone;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @JoinColumn(name = "id_role", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch =
    FetchType.EAGER)
    private RoleEntity role;
    @Column(name = "id_document", nullable = false)
    private String idDocument;
}