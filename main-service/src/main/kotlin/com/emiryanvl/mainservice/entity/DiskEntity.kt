package com.emiryanvl.mainservice.entity

import jakarta.persistence.*

@Entity
@Table(name = "_disk")
class DiskEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    @Column(name = "is_rented")
    var isRented: Boolean
)