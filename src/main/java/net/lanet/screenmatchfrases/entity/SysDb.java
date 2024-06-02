package net.lanet.screenmatchfrases.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sys_db")
public class SysDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer Id;
}
